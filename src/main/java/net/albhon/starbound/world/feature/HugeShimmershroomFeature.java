package net.albhon.starbound.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeShimmershroomFeature extends AbstractHugeMushroomFeature {
        public HugeShimmerMushroomFeature(Codec<HugeMushroomFeatureConfiguration> pHugeMushroomConfig) {
            super(pHugeMushroomConfig);
        }

        protected void makeCap(LevelAccessor pLevel, RandomSource pRandom, BlockPos pPos, int pInt, BlockPos.MutableBlockPos pMutablePos, HugeMushroomFeatureConfiguration pHugeMushroomConfig) {
            int i = pHugeMushroomConfig.foliageRadius;

            for(int j = -i; j <= i; ++j) {
                for(int k = -i; k <= i; ++k) {
                    boolean flag = j == -i;
                    boolean flag1 = j == i;
                    boolean flag2 = k == -i;
                    boolean flag3 = k == i;
                    boolean flag4 = flag || flag1;
                    boolean flag5 = flag2 || flag3;
                    if (!flag4 || !flag5) {
                        pMutablePos.setWithOffset(pPos, j, pInt, k);
                        if (!pLevel.getBlockState(pMutablePos).isSolidRender(pLevel, pMutablePos)) {
                            boolean flag6 = flag || flag5 && j == 1 - i;
                            boolean flag7 = flag1 || flag5 && j == i - 1;
                            boolean flag8 = flag2 || flag4 && k == 1 - i;
                            boolean flag9 = flag3 || flag4 && k == i - 1;
                            BlockState blockstate = pHugeMushroomConfig.capProvider.getState(pRandom, pPos);
                            if (blockstate.hasProperty(HugeMushroomBlock.WEST) && blockstate.hasProperty(HugeMushroomBlock.EAST) && blockstate.hasProperty(HugeMushroomBlock.NORTH) && blockstate.hasProperty(HugeMushroomBlock.SOUTH)) {
                                blockstate = blockstate.setValue(HugeMushroomBlock.WEST, Boolean.valueOf(flag6)).setValue(HugeMushroomBlock.EAST, Boolean.valueOf(flag7)).setValue(HugeMushroomBlock.NORTH, Boolean.valueOf(flag8)).setValue(HugeMushroomBlock.SOUTH, Boolean.valueOf(flag9));
                            }

                            this.setBlock(pLevel, pMutablePos, blockstate);
                        }
                    }
                }
            }

        }

        protected int getTreeRadiusForHeight(int p_65881_, int p_65882_, int p_65883_, int p_65884_) {
            return p_65884_ <= 3 ? 0 : p_65883_;
        }
    }
}
