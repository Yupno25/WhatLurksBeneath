package net.yupno.what_lurks_beneath.entity.the_goliath.attacks;

import net.minecraft.world.entity.LivingEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.ConditionlessAttack;
import net.yupno.what_lurks_beneath.entity.thrown_object.ThrownObjectEntity;

public class ThrowAttack<E extends LivingEntity> extends ConditionlessAttack<E> {
    public ThrowAttack(int delayTicks) {
        super(delayTicks);

        attack(this::doThrow);
    }

    protected void doThrow(E entity){
        entity.getLevel().addFreshEntity(new ThrownObjectEntity(entity.getLevel(), target, entity));
    }
}
