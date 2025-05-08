package dev.titanite.retrocompy.blocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import dev.titanite.retrocompy.tabs.ClassicComputersCreativeTab;
import dev.titanite.retrocompy.items.ClassicComputersItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ClassicComputersBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ClassicComputers.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = ClassicComputersItems.ITEMS;

    public static final RegistrySupplier<Block> COMPUTER_BLOCK = registerBlock("computer",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final RegistrySupplier<BlockItem> COMPUTER_BLOCK_ITEM = ITEMS.register(
        "computer", () -> new BlockItem(COMPUTER_BLOCK.get(), new Item.Properties().arch$tab(ClassicComputersCreativeTab.CLASSIC_COMPUTERS_TAB)));

    public static void init() {
        BLOCKS.register();
    }

    private static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, name), block);
    }
}
