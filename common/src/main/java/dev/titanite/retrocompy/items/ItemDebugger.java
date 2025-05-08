package dev.titanite.retrocompy.items;

import dev.titanite.retrocompy.tabs.ClassicComputersCreativeTab;
import dev.titanite.retrocompy.imgui.ImGuiRenderable;
import dev.titanite.retrocompy.imgui.ImGuiStateHandler;
import imgui.ImGui;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class ItemDebugger extends Item implements ImGuiRenderable {
    public ItemDebugger() {
        super(
                new Properties()
                        //.setId(ResourceKey.create(Registries.ITEM,
                        //  ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, name))1.21.4
                        .stacksTo(1)
                        .arch$tab(ClassicComputersCreativeTab.CLASSIC_COMPUTERS_TAB)
        );
    }

    private static boolean showText = false;

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(level != null && level.isClientSide()) {
            if(!ImGuiStateHandler.add(this))
                ImGuiStateHandler.remove(this);
        }
        return super.use(level, player, interactionHand);
    }

    public void imgui() {
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
