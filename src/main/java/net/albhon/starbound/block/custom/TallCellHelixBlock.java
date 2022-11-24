package net.albhon.starbound.block.custom;

import net.albhon.starbound.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class TallCellHelixBlock extends TallSeagrassBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = DoublePlantBlock.HALF;
    protected static final float AABB_OFFSET = 1.0F;
    protected static final VoxelShape UPPER_AABB = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 4.0D, 12.0D);
    protected static final VoxelShape LOWER_AABB = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 16.0D, 12.0D);

    public TallCellHelixBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }


    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        DoubleBlockHalf blockHalf = pState.getValue(HALF);
        switch(blockHalf) {
        case UPPER:
            return UPPER_AABB;
        default:
            return LOWER_AABB;
        }
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(BlockTags.CORAL_BLOCKS) || pState.is(ModBlocks.FLESH_BLOCK.get());
    }

    public ItemStack getCloneItemStack(BlockGetter p_154749_, BlockPos p_154750_, BlockState p_154751_) {
        return new ItemStack(ModBlocks.TALL_CELL_HELIX.get());
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XYZ;
    }
}
