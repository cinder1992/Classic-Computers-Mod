package dev.titanite.retrocompy.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.titanite.retrocompy.imgui.ImGuiStateHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import dev.titanite.retrocompy.ClassicComputers;

@Mixin(value = RenderSystem.class, remap = false)
public class TailRenderMixin {
    @Inject(at = @At("HEAD"), method = "flipFrame")
    private static void runTickTail(CallbackInfo ci) {
        ClassicComputers.MINECRAFT.getProfiler().push("CC Imgui Render");
        ImGuiStateHandler.onFrameRender();
        ClassicComputers.MINECRAFT.getProfiler().pop();
    }
}
