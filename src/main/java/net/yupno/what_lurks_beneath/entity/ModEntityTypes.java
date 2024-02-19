package net.yupno.what_lurks_beneath.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import net.yupno.what_lurks_beneath.entity.meteor.MeteorEntity;
import net.yupno.what_lurks_beneath.entity.the_goliath.TheGoliathEntity;
import net.yupno.what_lurks_beneath.entity.thrown_object.ThrownObjectEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WhatLurksBeneathMod.MOD_ID);

    public static final RegistryObject<EntityType<TheGoliathEntity>> THE_GOLIATH =
            ENTITY_TYPES.register("the_goliath",
                    () -> EntityType.Builder.of(TheGoliathEntity::new, MobCategory.MONSTER)
                            .sized(6f, 8f)
                            .build(new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "the_goliath").toString()));

    public static final RegistryObject<EntityType<ThrownObjectEntity>> THROWN_OBJECT =
            ENTITY_TYPES.register("thrown_object",
                    () -> EntityType.Builder.<ThrownObjectEntity>of(ThrownObjectEntity::new, MobCategory.MISC)
                            .sized(1f, 1f)
                            .build(new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "thrown_object").toString()));

    public static final RegistryObject<EntityType<MeteorEntity>> METEOR =
            ENTITY_TYPES.register("meteor",
                    () -> EntityType.Builder.<MeteorEntity>of(MeteorEntity::new, MobCategory.MISC)
                            .sized(1f, 1f)
                            .build(new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "meteor").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}