package net.albhon.starbound.world.feature;

import net.albhon.starbound.StarboundMod;
import net.albhon.starbound.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry., StarboundMod.MOD_ID);


    public static final Feature<HugeMushroomFeatureConfiguration> HUGE_SHIMMERMUSHROOM = register("huge_shimmershroom", new HugeShimmershroomFeature(HugeMushroomFeatureConfiguration.CODEC));

   // public static final RegistryObject<ConfiguredFeature<?, ?>> HUGE_SHIMMERSHROOM =
   //         CONFIGURED_FEATURES.register("huge_shimmershroom"), () ->
   //             new ConfiguredFeature<>(Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfiguration(
   //                     BlockStateProvider.simple(ModBlocks.SHIMMERSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(true)).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 3)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
