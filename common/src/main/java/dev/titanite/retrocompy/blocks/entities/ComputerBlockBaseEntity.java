package dev.titanite.retrocompy.blocks.entities;

import dev.titanite.retrocompy.ClassicComputers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class ComputerBlockBaseEntity extends BlockEntity {
    public ComputerBlockBaseEntity(BlockPos pos, BlockState state) {
        super(ClassicComputersBlockEntities.COMPUTER_BLOCK_ENTITY.get(), pos, state);
    }

    public static class Ticker<T extends BlockEntity> implements BlockEntityTicker<T> {

        @Override
        public void tick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
            if(!level.isClientSide) { //Only run Z80 code on the server, updates will be passed to the client
                ClassicComputers.LOGGER.info("Ticker at {} with state {} and entity type {}", blockPos.toShortString(), blockState.toString(), blockEntity.getClass().getName());
            }
        }
    }
}
