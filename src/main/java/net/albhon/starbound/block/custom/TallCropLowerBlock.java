package net.albhon.starbound.block.custom;

import net.albhon.starbound.block.ModBlocks;
import net.albhon.starbound.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class TallCropLowerBlock extends BushBlock implements BonemealableBlock {
    public static final int Max_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 12.0D,13.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D,13.0D)};

    public TallCropLowerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }


    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(ModItems.BONEBOO_SEED.get());
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(ModBlocks.FLESH_BLOCK.get()) || pState.is(Blocks.FARMLAND);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        if (blockstate.is(ModBlocks.TAR_BLOCK.get()) || blockstate.is(Blocks.FARMLAND)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isRandomlyTicking(BlockState pState, ServerLevel pLevel, BlockPos pPos) {
        BlockState blockState = pLevel.getBlockState(pPos.above());
        return !(blockState.getValue(TallCropUpperBlock.AGE) == 3);
    }


    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        int i = pState.getValue(AGE);
        if (pLevel.getRawBrightness(pPos.above(), 0) >= 6 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState,pRandom.nextInt(5) == 0)) {
            if (i < 3) {
                pLevel.setBlock(pPos, pState.setValue(AGE, i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
            } else if ((i == 3) && ModBlocks.BONEBOO_CROP_UPPER.get().defaultBlockState().canSurvive(pLevel, pPos.above()) && pLevel.isEmptyBlock(pPos.above())) {
                pLevel.setBlockAndUpdate(pPos.above(), ModBlocks.BONEBOO_CROP_UPPER.get().defaultBlockState());
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
            }
        }
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof Ravager && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(pLevel, pEntity)) {
            pLevel.destroyBlock(pPos, true, pEntity);
        }

        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        BlockPos blockPos = pPos.above();
        BlockState blockState = pLevel.getBlockState(pPos.above());
        if (blockState.is(ModBlocks.BONEBOO_CROP_UPPER.get())) {
            return (blockState.getValue(TallCropUpperBlock.AGE) < 3);
        }
        else {
            return true;
        }
    }

    public boolean isBonemealSuccess(Level pLevel, Random pRand, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, Random pRand, BlockPos pPos, BlockState pState) {
        int i = Math.min(3, pState.getValue(AGE) + 1);
        BlockPos blockPos = pPos.above();
        BlockState blockState = pLevel.getBlockState(pPos.above());
        if (pState.getValue(AGE) < 3) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, i));
        }
        else if (blockState.is(ModBlocks.BONEBOO_CROP_UPPER.get())) {
        BonemealableBlock growable = (BonemealableBlock)pLevel.getBlockState(blockPos).getBlock();
            if (growable.isValidBonemealTarget(pLevel, blockPos, blockState, false)) {
                growable.performBonemeal(pLevel, pLevel.random, blockPos, blockState);
            }
        } else {
            if (ModBlocks.BONEBOO_CROP_UPPER.get().defaultBlockState().canSurvive(pLevel, blockPos) && pLevel.isEmptyBlock(blockPos)) {
                pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, 3));
                pLevel.setBlock(blockPos, ModBlocks.BONEBOO_CROP_UPPER.get().defaultBlockState().setValue(TallCropUpperBlock.AGE, 0), 2);
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
    }
}
