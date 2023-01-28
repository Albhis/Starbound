package net.albhon.starbound.block;

import net.albhon.starbound.StarboundMod;
import net.albhon.starbound.block.custom.*;
import net.albhon.starbound.item.ModItems;
import net.albhon.starbound.sound.ModSounds;
import net.albhon.starbound.world.feature.ModConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StarboundMod.MOD_ID);

    public  static final RegistryObject<Block> TAR_BLOCK = registerBlock("tar_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(2f, 3f).sound(SoundType.SLIME_BLOCK).jumpFactor(0.9f)
                    .speedFactor(0.7f)));

    public  static final RegistryObject<Block> WET_SANDSTONE = registerBlock("wet_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.3f).requiresCorrectToolForDrops()));

    public  static final RegistryObject<Block> LEAKING_WET_SANDSTONE = registerBlock("leaking_wet_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops()));

    public  static final RegistryObject<Block> PACKED_BONES = registerBlock("packed_bones",
            () -> new FallingBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.1f).requiresCorrectToolForDrops().sound(ModSounds.BONES_BLOCK)));

    public  static final RegistryObject<Block> BONE_CLUSTER = registerBlock("bone_cluster",
            () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(ModSounds.BONES_BLOCK).noCollission().noOcclusion()));

    public  static final RegistryObject<Block> RIB_BONES = BLOCKS.register("rib_bones",
            () -> new RibBonesBlock(BlockBehaviour.Properties.copy(Blocks.HORN_CORAL).sound(ModSounds.BONES_BLOCK)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> WALL_RIB_BONES = BLOCKS.register("wall_rib_bones",
            () -> new RibBonesWallBlock(BlockBehaviour.Properties.copy(ModBlocks.RIB_BONES.get())
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> BONEBOO_CROP_LOWER = BLOCKS.register("boneboo_crop_lower",
            () -> new TallCropLowerBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).sound(SoundType.CORAL_BLOCK)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> BONEBOO_CROP_UPPER = BLOCKS.register("boneboo_crop_upper",
            () -> new TallCropUpperBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).sound(SoundType.CORAL_BLOCK)
                    .noCollission().noOcclusion()));



    public  static final RegistryObject<Block> BRAINS_BLOCK = registerBlock("brains_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(2f).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRAINS = registerBlock("brains",
            () -> new BrainsBlock(BlockBehaviour.Properties.of(Material.TOP_SNOW)
                    .strength(2f).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops().dynamicShape()));

    public  static final RegistryObject<Block> FLESH_BLOCK = registerBlock("flesh_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(3f).sound(SoundType.WART_BLOCK)));

    public static final RegistryObject<Block> NERVE = registerBlock("nerve",
            () -> new NerveBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.2f).sound(SoundType.NETHER_WART).noCollission().noOcclusion()
                    .lightLevel((state) -> state.getValue(NerveBlock.WRITHING) ? 6 : 4)));

    public static final RegistryObject<Block> CELL_HELIX = registerBlock("cell_helix",
            () -> new CellHelixBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> TALL_CELL_HELIX = registerBlock("tall_cell_helix",
            () -> new TallCellHelixBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> EYE_STALK_HEAD = registerBlock("eye_stalk_head",
            () -> new EyeStalkHeadBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()));

    public static final RegistryObject<Block> EYE_STALK = BLOCKS.register("eye_stalk",
            () -> new EyeStalkBlock(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES_PLANT)
                    .noCollission().noOcclusion()));
    public static final RegistryObject<Block> PUSSPLUM_CROP = BLOCKS.register("pussplum_crop",
            () -> new PussplumCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)
                    .noCollission().noOcclusion()));



    public  static final RegistryObject<Block> SLUDGE = registerBlock("sludge",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.ROOTED_DIRT)
                    .strength(2.2f, 4f)));

    public  static final RegistryObject<Block> OOZE = registerBlock("ooze",
            () -> new OozeBlock(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(1.0f, 3f).sound(SoundType.SLIME_BLOCK)
                    .speedFactor(0.8f).jumpFactor(0.9f).friction(0.5f)));

    public  static final RegistryObject<Block> CELL_COMPOUND = registerBlock("cell_compound",
            () -> new DeadBushBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .noCollission().instabreak().sound(SoundType.GRASS)));

    public  static final RegistryObject<Block> SHIMMERSHROOM = BLOCKS.register("shimmershroom",
            () -> new MushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM)
                    .sound(SoundType.GRASS).lightLevel((p_50892_) -> {
                        return 7;
                    }), () -> {
                        return ModConfiguredFeatures.HUGE_SHIMMERSHROOM;
                    }));

    public  static final RegistryObject<Block> POTTED_SHIMMERSHROOM = BLOCKS.register("potted_shimmershroom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.SHIMMERSHROOM, BlockBehaviour.Properties.copy(Blocks.POTTED_BROWN_MUSHROOM)
                    ));

    public  static final RegistryObject<Block> SHIMMERSHROOM_BLOCK = registerBlock("shimmershroom_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.2f).sound(SoundType.WOOD).lightLevel((p_50892_) -> {
                        return 5;
                    })));


    public  static final RegistryObject<Block> RAINBOW_PLANKS = registerBlock("rainbow_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0f).sound(SoundType.WOOD)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }
        );

    public  static final RegistryObject<Block> RAINBOW_LOG = registerBlock("rainbow_log",
            () -> new RainbowLogsBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0f).sound(SoundType.WOOD)));

    public  static final RegistryObject<Block> RAINBOW_WOOD = registerBlock("rainbow_wood",
            () -> new RainbowLogsBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0f).sound(SoundType.WOOD)));

    public  static final RegistryObject<Block> STRIPPED_RAINBOW_LOG = registerBlock("stripped_rainbow_log",
            () -> new RainbowLogsBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0f).sound(SoundType.WOOD)));

    public  static final RegistryObject<Block> STRIPPED_RAINBOW_WOOD = registerBlock("stripped_rainbow_wood",
            () -> new RainbowLogsBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2.0f).sound(SoundType.WOOD)));

    public  static final RegistryObject<Block> RAINBOW_FRONDS = BLOCKS.register("rainbow_fronds",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 120;
                }
            });



    public  static final RegistryObject<Block> RAINBOW_SLAB = registerBlock("rainbow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                    }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                    }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                    }
                }
            );

    public  static final RegistryObject<Block> RAINBOW_STAIRS = registerBlock("rainbow_stairs",
            () -> new StairBlock(() -> ModBlocks.RAINBOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }
        );

    public  static final RegistryObject<Block> RAINBOW_BUTTON = registerBlock("rainbow_button",
            () -> woodenButton());

    public  static final RegistryObject<Block> RAINBOW_PRESSURE_PLATE = registerBlock("rainbow_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get()).noCollission())
            );

    public  static final RegistryObject<Block> RAINBOW_FENCE = registerBlock("rainbow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public  static final RegistryObject<Block> RAINBOW_FENCE_GATE = registerBlock("rainbow_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())));

    public  static final RegistryObject<Block> RAINBOW_DOOR = registerBlock("rainbow_door",
            () -> DoorBlock(BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())));

    public  static final RegistryObject<Block> RAINBOW_TRAPDOOR = registerBlock("rainbow_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(ModBlocks.RAINBOW_PLANKS.get())));

    public  static final RegistryObject<Block> RAINBOW_SIGN = BLOCKS.register("rainbow_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().sound(SoundType.WOOD), ModWoodTypes.RAINBOW));

    public  static final RegistryObject<Block> RAINBOW_WALL_SIGN = BLOCKS.register("rainbow_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().sound(SoundType.WOOD), ModWoodTypes.RAINBOW));

    public  static final RegistryObject<Block> OASIS_GRASS = registerBlock("oasis_grass",
            () -> new OasisGrassBlock(BlockBehaviour.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND).randomTicks()));

    public static final RegistryObject<Block> VORTEX_NOVABLOOM = BLOCKS.register("vortex_novabloom",
            () -> new FlowerBlock(MobEffects.JUMP, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> NEBULA_NOVABLOOM = BLOCKS.register("nebula_novabloom",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> STARDUST_NOVABLOOM = BLOCKS.register("stardust_novabloom",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).sound(SoundType.GRASS)));

    public  static final RegistryObject<Block> GRAPE_VINES = BLOCKS.register("grape_vines",
            () -> new GrapeVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.GRASS).noCollission()));

    public  static final RegistryObject<Block> POTTED_VORTEX_NOVABLOOM = BLOCKS.register("potted_vortex_novabloom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.VORTEX_NOVABLOOM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)
            ));

    public  static final RegistryObject<Block> POTTED_NEBULA_NOVABLOOM = BLOCKS.register("potted_nebula_novabloom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.NEBULA_NOVABLOOM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)
            ));

    public  static final RegistryObject<Block> POTTED_STARDUST_NOVABLOOM = BLOCKS.register("potted_stardust_novabloom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.STARDUST_NOVABLOOM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)
            ));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

