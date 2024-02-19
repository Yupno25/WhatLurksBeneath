package net.yupno.what_lurks_beneath.entity.the_goliath;

import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import software.bernie.geckolib.model.GeoModel;

public class TheGoliathModel extends GeoModel<TheGoliathEntity> {
    @Override
    public ResourceLocation getModelResource(TheGoliathEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "geo/the_goliath.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TheGoliathEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/the_goliath_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TheGoliathEntity animatable) {
        return null;
        //new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "animations/chomper.animation.json");
    }
}
