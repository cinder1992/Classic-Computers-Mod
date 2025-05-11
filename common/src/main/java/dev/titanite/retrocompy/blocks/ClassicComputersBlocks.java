package dev.titanite.retrocompy.blocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import dev.titanite.retrocompy.items.ClassicComputersItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ClassicComputersBlocks {
    public static final DeferredRegister<Block> BLOCKS;
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistrySupplier<Block> COMPUTER_BLOCK;

    public static void init() {
        BLOCKS.register();
    }

    static {
        BLOCKS = DeferredRegister.create(ClassicComputers.MOD_ID, Registries.BLOCK);
        ITEMS = ClassicComputersItems.ITEMS;
        COMPUTER_BLOCK = BLOCKS.register(ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, "computer"),
                () -> new ComputerBlockBase(BlockBehaviour.Properties.of()
                        .destroyTime(2.0f)
                        .lightLevel(s -> 6)
                        .sound(SoundType.METAL)
                )
        );
    }
}
