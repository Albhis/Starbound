package net.albhon.starbound;

import net.albhon.starbound.block.ModBlocks;
import net.albhon.starbound.block.ModWoodTypes;
import net.albhon.starbound.block.entity.ModBlockEntities;
import net.albhon.starbound.item.ModItems;
import net.albhon.starbound.sound.ModSounds;
import net.albhon.starbound.util.ModTags;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StarboundMod.MOD_ID)
public class StarboundMod
{
    public static final String MOD_ID = "starbound";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public StarboundMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModTags.register();
        ModSounds.register(eventBus);

        ModBlockEntities.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PUSSPLUM_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NERVE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EYE_STALK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EYE_STALK_HEAD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CELL_HELIX.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_CELL_HELIX.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIB_BONES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALL_RIB_BONES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_CLUSTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONEBOO_CROP_LOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONEBOO_CROP_UPPER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OOZE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHIMMERSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CELL_COMPOUND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAINBOW_FRONDS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_SHIMMERSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_VORTEX_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_NEBULA_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_STARDUST_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VORTEX_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NEBULA_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STARDUST_NOVABLOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPE_VINES.get(), RenderType.cutout());

        WoodType.register(ModWoodTypes.RAINBOW);
    }
    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.PUSSPLUM.get(), 0.5f);
            ComposterBlock.COMPOSTABLES.put(ModItems.PUSSPLUM_SEED.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.BONEBOO.get(), 0.45f);
            ComposterBlock.COMPOSTABLES.put(ModItems.BONEBOO_SEED.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.SHIMMERSHROOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.VORTEX_NOVABLOOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.NEBULA_NOVABLOOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.STARDUST_NOVABLOOM.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RAINBOW_FRONDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.GRAPE_SEEDS.get(), 0.3f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SHIMMERSHROOM.getId(), ModBlocks.POTTED_SHIMMERSHROOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.VORTEX_NOVABLOOM.getId(), ModBlocks.POTTED_VORTEX_NOVABLOOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.NEBULA_NOVABLOOM.getId(), ModBlocks.POTTED_NEBULA_NOVABLOOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.STARDUST_NOVABLOOM.getId(), ModBlocks.POTTED_STARDUST_NOVABLOOM);

            BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
            Sheets.addWoodType(ModWoodTypes.RAINBOW);
        });
    }
}
