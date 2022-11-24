package net.albhon.starbound.sound;

import net.albhon.starbound.StarboundMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, StarboundMod.MOD_ID);

    public static RegistryObject<SoundEvent> BONES_BLOCK_BREAK = registerSoundEvents("bones_block_break");
    public static RegistryObject<SoundEvent> BONES_BLOCK_STEP = registerSoundEvents("bones_block_step");
    public static RegistryObject<SoundEvent> BONES_BLOCK_PLACE = registerSoundEvents("bones_block_place");
    public static RegistryObject<SoundEvent> BONES_BLOCK_HIT = registerSoundEvents("bones_block_hit");
    public static RegistryObject<SoundEvent> BONES_BLOCK_FALL = registerSoundEvents("bones_block_fall");

    public static final ForgeSoundType BONES_BLOCK = new ForgeSoundType(1f, 1f,
            ModSounds.BONES_BLOCK_BREAK, ModSounds.BONES_BLOCK_STEP, ModSounds.BONES_BLOCK_PLACE,
            ModSounds.BONES_BLOCK_HIT, ModSounds.BONES_BLOCK_FALL);


    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(StarboundMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
