package net.yupno.what_lurks_beneath.entity.thrown_object;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThrownObjectRenderer  extends GeoEntityRenderer<ThrownObjectEntity> {
    public ThrownObjectRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThrownObjectModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownObjectEntity instance) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/thrown_object_texture.png");
    }

    @Override
    public RenderType getRenderType(ThrownObjectEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
