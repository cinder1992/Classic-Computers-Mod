package dev.titanite.retrocompy.blocks.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import dev.titanite.retrocompy.blocks.ClassicComputersBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class ClassicComputersBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES
            = DeferredRegister.create(ClassicComputers.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<ComputerBlockBaseEntity>> COMPUTER_BLOCK_ENTITY;

    public static void init() {
        BLOCK_ENTITIES.register();
    }

    static {
        COMPUTER_BLOCK_ENTITY
                = BLOCK_ENTITIES.register(ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, "computer"),
                () -> BlockEntityType.Builder.of(ComputerBlockBaseEntity::new, ClassicComputersBlocks.COMPUTER_BLOCK.get()).build(null)
        );
    }
}
