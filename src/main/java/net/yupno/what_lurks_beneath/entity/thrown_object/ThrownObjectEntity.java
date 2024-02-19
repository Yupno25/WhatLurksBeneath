package net.yupno.what_lurks_beneath.entity.thrown_object;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.yupno.what_lurks_beneath.WhatLurksBeneathMod;
import net.yupno.what_lurks_beneath.entity.ModEntityTypes;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class ThrownObjectEntity extends Projectile implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    private boolean properlySummoned = false;
    private Vec3 targetPos;
    private Vec3 startPos;


    public ThrownObjectEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    public ThrownObjectEntity(Level pLevel, Entity target, LivingEntity pShooter) {
        this(ModEntityTypes.THROWN_OBJECT.get(), pLevel);
        this.setOwner(pShooter);
        targetPos = target.position();

        BlockPos blockpos = pShooter.blockPosition();
        double X = (double)blockpos.getX() + 3.0D;
        double Y = (double)blockpos.getY() + 3.0D;
        double Z = (double)blockpos.getZ() + 3.0D;

        startPos = new Vec3(X, Y, Z);

        this.moveTo(X, Y, Z, this.getXRot(), this.getYRot());

        properlySummoned = true;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();
        if(properlySummoned){ // !this.level.isClientSide &&
            Vec3 vec3 = this.getDeltaMovement();
            double X = this.getX() + vec3.x;
            double Y = this.getY() + vec3.y;
            double Z = this.getZ() + vec3.z;

            this.setDeltaMovement(new Vec3((targetPos.x - startPos.x), (targetPos.y - startPos.y), (targetPos.z - startPos.z)).scale(0.05));
            this.setPos(X, Y, Z);

            HitResult hitresult = ProjectileUtil.getHitResult(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
            }
        }
    }



    @Override
    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && !pTarget.noPhysics;
    }

    public boolean isPickable() {
        return true;
    }

    /** Explodes on hit */

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 5.0F, Level.ExplosionInteraction.MOB);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 3.0F, Level.ExplosionInteraction.MOB);
    }

    /** THIS DEALS WITH THE ANIMATIONS */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }
}
