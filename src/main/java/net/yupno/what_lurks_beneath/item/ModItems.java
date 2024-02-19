package net.yupno.what_lurks_beneath.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import net.yupno.what_lurks_beneath.entity.ModEntityTypes;
import net.yupno.what_lurks_beneath.item.custom.StaffItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WhatLurksBeneathMod.MOD_ID);

    public static final RegistryObject<Item> STAFF = ITEMS.register("staff",
            () -> new StaffItem(new Item.Properties().stacksTo(1).defaultDurability(1)));

    public static final RegistryObject<Item> THE_GOLIATH_SPAWN_EGG = ITEMS.register("the_goliath_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THE_GOLIATH, 0x000000, 0x808080, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
