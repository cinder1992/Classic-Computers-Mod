package dev.titanite.retrocompy.imgui;

import imgui.*;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import dev.titanite.retrocompy.ClassicComputers;

import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class ImGuiStateHandler {
    private static final ImGuiImplGlfw imGlfw = new ImGuiImplGlfw();
    private static final ImGuiImplGl3 imGl3 = new ImGuiImplGl3();
    private static final ArrayList<ImGuiRenderable> rlist = new ArrayList<>();
    private static final Object mutex = new Object();
    private static long windowHandle;
    private static boolean show = false;

    public static void onGLFWInit(long window) {
        ClassicComputers.LOGGER.debug("ClassicComputers GLFW mixin creating ImGui Context");
        ImGui.createContext();

        final ImGuiIO io = ImGui.getIO();

        io.setIniFilename(null);                               // We don't want to save .ini file
        io.addConfigFlags(ImGuiConfigFlags.NavEnableKeyboard); // Enable Keyboard Controls
        io.addConfigFlags(ImGuiConfigFlags.DockingEnable);     // Enable Docking
        io.addConfigFlags(ImGuiConfigFlags.ViewportsEnable);   // Enable Multi-Viewport / Platform Windows
        io.setConfigViewportsNoTaskBarIcon(true);

        final ImFontAtlas fontAtlas = io.getFonts();
        final ImFontConfig fontConfig = new ImFontConfig(); // Natively allocated object, should be explicitly destroyed

        fontConfig.setGlyphRanges(fontAtlas.getGlyphRangesCyrillic());

        fontAtlas.addFontDefault();

        fontConfig.setMergeMode(true); // When enabled, all fonts added with this config would be merged with the previously added font
        fontConfig.setPixelSnapH(true);

        fontConfig.destroy();

        if (io.hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final ImGuiStyle style = ImGui.getStyle();
            style.setWindowRounding(0.0f);
            style.setColor(ImGuiCol.WindowBg, ImGui.getColorU32(ImGuiCol.WindowBg, 1));
        }

        imGlfw.init(window, true);
        imGl3.init();
        windowHandle = window;
        show = true;
    }

    public static void onFrameRender() {
        if(!show) return; //Break out early to prevent attempting to render without initializing!
        imGlfw.newFrame();
        ImGui.newFrame();
        synchronized (mutex) {
            for (ImGuiRenderable im : rlist) {
                im.imgui();
            }
        }
        endFrame(windowHandle);
    }

    protected static void endFrame(long handle) {
        ImGui.render();
        imGl3.renderDrawData(ImGui.getDrawData());

        // Update and Render additional Platform Windows
        // (Platform functions may change the current OpenGL context, so we save/restore it to make it easier to paste this code elsewhere.
        //  For this specific demo app we could also call glfwMakeContextCurrent(window) directly)
        if (ImGui.getIO().hasConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            final long backupCurrentContext = GLFW.glfwGetCurrentContext();
            ImGui.updatePlatformWindows();
            ImGui.renderPlatformWindowsDefault();
            GLFW.glfwMakeContextCurrent(backupCurrentContext);
        }
    }

    public static boolean add(ImGuiRenderable im) {
        synchronized (mutex) {
            if (rlist.contains(im)) return false;
            rlist.add(im);
        }
        return true;
    }

    public static void remove(ImGuiRenderable im) {
        synchronized (mutex) {
            if (!rlist.contains(im)) return;
            rlist.remove(im);
        }
    }
}
