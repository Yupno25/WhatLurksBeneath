package net.yupno.what_lurks_beneath.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;

@Mod.EventBusSubscriber(modid = WhatLurksBeneathMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab WHAT_LURKS_BENEATH_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        WHAT_LURKS_BENEATH_TAB = event.registerCreativeModeTab(new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "what_lurks_beneath_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.STAFF.get())).title(Component.translatable("what_lurks_beneath_tab")).build());
    }
}
