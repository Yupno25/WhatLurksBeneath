package net.yupno.what_lurks_beneath.entity.the_goliath;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TheGoliathRenderer extends GeoEntityRenderer<TheGoliathEntity> {
    public TheGoliathRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TheGoliathModel());
        this.scaleHeight = 6f;
        this.scaleWidth = 6f;
        //this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TheGoliathEntity instance) {
        return new ResourceLocation(WhatLurksBeneathMod.MOD_ID, "textures/entity/the_goliath_texture.png");
    }

    @Override
    public RenderType getRenderType(TheGoliathEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
