package net.albhon.starbound.block.custom;

import net.albhon.starbound.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class CellHelixBlock extends SeagrassBlock {
    protected static final float AABB_OFFSET = 1.0F;
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 8.0D, 12.0D);

    public CellHelixBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(BlockTags.CORAL_BLOCKS) || pState.is(ModBlocks.FLESH_BLOCK.get());
    }

    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    public boolean isBonemealSuccess(Level pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        BlockState blockstate = ModBlocks.TALL_CELL_HELIX.get().defaultBlockState();
        BlockState blockstate1 = blockstate.setValue(TallCellHelixBlock.HALF, DoubleBlockHalf.UPPER);
        BlockPos blockPos = pPos.above();
        if (pLevel.getBlockState(blockPos).is(Blocks.WATER)) {
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.setBlock(blockPos, blockstate1, 2);
        }
    }


    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XYZ;
    }
}
