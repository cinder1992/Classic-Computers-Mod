package dev.titanite.retrocompy.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import dev.titanite.retrocompy.tabs.ClassicComputersCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import dev.titanite.retrocompy.blocks.ClassicComputersBlocks;

public class ClassicComputersItems {
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistrySupplier<Item> DEBUGGER_ITEM;

    public static final RegistrySupplier<BlockItem> COMPUTER_BLOCK_ITEM;

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, name), item);
    }

    static {
        ITEMS = DeferredRegister.create(ClassicComputers.MOD_ID, Registries.ITEM);
        DEBUGGER_ITEM = registerItem("debugger", ItemDebugger::new);
        COMPUTER_BLOCK_ITEM = ITEMS.register("computer",
                () -> new BlockItem(
                        ClassicComputersBlocks.COMPUTER_BLOCK.get(),
                        new Item.Properties().arch$tab(ClassicComputersCreativeTab.CLASSIC_COMPUTERS_TAB)
                )
        );
    }
}
