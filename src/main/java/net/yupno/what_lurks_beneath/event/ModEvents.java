package net.yupno.what_lurks_beneath.event;


import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import net.yupno.what_lurks_beneath.entity.ModEntityTypes;
import net.yupno.what_lurks_beneath.entity.the_goliath.TheGoliathEntity;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = WhatLurksBeneathMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.THE_GOLIATH.get(), TheGoliathEntity.setAttributes());
        }
    }
}
