package net.albhon.starbound.block.entity;

import net.albhon.starbound.block.ModBlocks;
import net.albhon.starbound.block.custom.ModStandingSignBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;



import java.util.function.Supplier;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pState) {
        super(pPos, pState);
    }

    public BlockEntityType<?> getType() {
        return ModBlockEntityTypes.SIGN_BLOCK_ENTITIES.get();
    }
}
