package net.yupno.what_lurks_beneath;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yupno.what_lurks_beneath.entity.meteor.MeteorRenderer;
import net.yupno.what_lurks_beneath.entity.ModEntityTypes;
import net.yupno.what_lurks_beneath.entity.the_goliath.TheGoliathRenderer;
import net.yupno.what_lurks_beneath.entity.thrown_object.ThrownObjectRenderer;
import net.yupno.what_lurks_beneath.item.ModCreativeModeTab;
import net.yupno.what_lurks_beneath.item.ModItems;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WhatLurksBeneathMod.MOD_ID)
public class WhatLurksBeneathMod
{
    public static final String MOD_ID = "what_lurks_beneath";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WhatLurksBeneathMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTab.WHAT_LURKS_BENEATH_TAB){
            event.accept(ModItems.STAFF);
            event.accept(ModItems.THE_GOLIATH_SPAWN_EGG);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.THE_GOLIATH.get(), TheGoliathRenderer::new);
            EntityRenderers.register(ModEntityTypes.THROWN_OBJECT.get(), ThrownObjectRenderer::new);
            EntityRenderers.register(ModEntityTypes.METEOR.get(), MeteorRenderer::new);
        }
    }
}
