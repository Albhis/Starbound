package net.albhon.starbound.item;

import net.albhon.starbound.StarboundMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StarboundMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab STARBOUND_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        STARBOUND_TAB = event.registerCreativeModeTab(new ResourceLocation(StarboundMod.MOD_ID, "starbound tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.PUSSPLUM.get())).title(Component.translatable("starbound tab")).build());
    }
}
