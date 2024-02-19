package net.yupno.what_lurks_beneath.entity.thrown_object;

import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import software.bernie.geckolib.model.GeoModel;

public class ThrownObjectModel  extends GeoModel<ThrownObjectEntity> {
    @Override
    public ResourceLocation getModelResource(ThrownObjectEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "geo/thrown_object.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThrownObjectEntity object) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/thrown_object_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThrownObjectEntity animatable) {
        return null;
        //new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "animations/chomper.animation.json");
    }
}
