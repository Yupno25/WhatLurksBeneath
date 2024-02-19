package net.yupno.what_lurks_beneath.entity.meteor;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MeteorRenderer extends GeoEntityRenderer<MeteorEntity> {
    public MeteorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MeteorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MeteorEntity instance) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/thrown_object_texture.png");
    }

    @Override
    public RenderType getRenderType(MeteorEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
