package net.yupno.what_lurks_beneath.entity.meteor;

import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import software.bernie.geckolib.model.GeoModel;

public class MeteorModel extends GeoModel<MeteorEntity> {
    @Override
    public ResourceLocation getModelResource(MeteorEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "geo/thrown_object.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MeteorEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/thrown_object_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MeteorEntity animatable) {
        return null;
        //new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "animations/chomper.animation.json");
    }
}
