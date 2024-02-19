package net.yupno.what_lurks_beneath.entity.the_goliath.attacks;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.ConditionlessAttack;
import net.yupno.what_lurks_beneath.entity.the_goliath.TheGoliathEntity;

import java.util.Random;

public class GroundSlamAttack<E extends LivingEntity> extends ConditionlessAttack<E> {
    public GroundSlamAttack(int delayTicks) {
        super(delayTicks);

        attack(this::doSlam);
    }

    protected void doSlam(E entity) {
        Level level = entity.getLevel();
        Random random = new Random();
        AABB aabb = entity.getBoundingBox().inflate(3.0D);

        for (int i = 0; i < 100; i++) {
            ((ServerLevel) level).sendParticles(ParticleTypes.EXPLOSION, random.nextDouble(aabb.minX, aabb.maxX),
                    entity.getY() + random.nextDouble(-1, 1), random.nextDouble(aabb.minZ, aabb.maxZ),
                    1, 0, 0, 0, 0);
        }

        for (LivingEntity target : level.getEntities(EntityTypeTest.forClass(LivingEntity.class), aabb, Entity::isAlive)) {
            if (target instanceof LivingEntity && !(target instanceof TheGoliathEntity) && (!(target instanceof Player pl) || !pl.isCreative()))
                entity.doHurtTarget(target);
        }
    }
}
