package dev.titanite.retrocompy;

import imgui.ImGui;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClassicComputers {
    public static final String MOD_ID = "classic_computers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Minecraft MINECRAFT = Minecraft.getInstance();
    private static boolean showText = false;

    public static void init() {
        LOGGER.info("Hello from ClassicComputers!");
    }

    public static void imgui() {
        ImGui.begin("Cool Window");

        if (ImGui.button("I am a button")) {
            showText = true;
        }

        if (showText) {
            ImGui.text("You clicked a button");
            ImGui.sameLine();
            if (ImGui.button("Stop showing text")) {
                showText = false;
            }
        }

        ImGui.end();
    }
}
