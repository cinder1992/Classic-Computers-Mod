package dev.titanite.retrocompy.items;

import dev.architectury.event.CompoundEventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.titanite.retrocompy.tabs.ClassicComputersCreativeTab;
import dev.titanite.retrocompy.imgui.ImGuiRenderable;
import dev.titanite.retrocompy.imgui.ImGuiStateHandler;
import imgui.ImGui;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class ItemDebugger extends Item implements InteractionEvent.RightClickItem,ImGuiRenderable {
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

    private static boolean showText = false;
    public ItemDebugger() {
        super(
                new Properties()
                        //.setId(ResourceKey.create(Registries.ITEM,
                        //  ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, name))1.21.4
                        .stacksTo(1)
                        .arch$tab(ClassicComputersCreativeTab.CLASSIC_COMPUTERS_TAB)
        );
        InteractionEvent.RIGHT_CLICK_ITEM.register(this);
    }

    @Override
    public CompoundEventResult<ItemStack> click(Player player, InteractionHand interactionHand) {
        if(player.getItemInHand(interactionHand).is(this)) {
            if(player.level().isClientSide) {
                if (!ImGuiStateHandler.add(this)) ImGuiStateHandler.remove(this);
            }
            return CompoundEventResult.interruptTrue(player.getItemInHand(interactionHand));
        }
        return CompoundEventResult.pass();
    }
}
