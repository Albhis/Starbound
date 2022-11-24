package net.albhon.starbound.item;

import net.albhon.starbound.StarboundMod;
import net.albhon.starbound.block.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StarboundMod.MOD_ID);

    public static final RegistryObject<Item> TAR_BALL = ITEMS.register( "tar_ball",
            () -> new Item(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> RIB_BONES = ITEMS.register("rib_bones",
            () -> new StandingAndWallBlockItem(ModBlocks.RIB_BONES.get(), ModBlocks.WALL_RIB_BONES.get(),
                    (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> BONEBOO_SEED = ITEMS.register( "boneboo_seed",
            () -> new ItemNameBlockItem(ModBlocks.BONEBOO_CROP_LOWER.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> BONEBOO = ITEMS.register( "boneboo",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.BONEBOO)));


    public static final RegistryObject<Item> PUSSPLUM = ITEMS.register( "pussplum",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.PUSSPLUM)));

    public static final RegistryObject<Item> PUSSPLUM_SEED = ITEMS.register( "pussplum_seed",
            () -> new ItemNameBlockItem(ModBlocks.PUSSPLUM_CROP.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static final RegistryObject<Item> SHIMMERSHROOM = ITEMS.register( "shimmershroom",
            () -> new ItemNameBlockItem(ModBlocks.SHIMMERSHROOM.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    public static final RegistryObject<Item> RAINBOW_SIGN = ITEMS.register( "rainbow_sign",
            () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(16),
                    ModBlocks.RAINBOW_SIGN.get(), ModBlocks.RAINBOW_WALL_SIGN.get()));

    public static final RegistryObject<Item> RAINBOW_FRONDS = ITEMS.register( "rainbow_fronds",
            () -> new ItemNameBlockItem(ModBlocks.RAINBOW_FRONDS.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> VORTEX_NOVABLOOM = ITEMS.register( "vortex_novabloom",
            () -> new ItemNameBlockItem(ModBlocks.VORTEX_NOVABLOOM.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> NEBULA_NOVABLOOM = ITEMS.register( "nebula_novabloom",
            () -> new ItemNameBlockItem(ModBlocks.NEBULA_NOVABLOOM.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> STARDUST_NOVABLOOM = ITEMS.register( "stardust_novabloom",
            () -> new ItemNameBlockItem(ModBlocks.STARDUST_NOVABLOOM.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register( "grape_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRAPE_VINES.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Item> GRAPES = ITEMS.register( "grapes",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.GRAPES)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
