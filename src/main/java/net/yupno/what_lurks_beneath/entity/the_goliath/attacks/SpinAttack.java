package net.yupno.what_lurks_beneath.entity.the_goliath.attacks;

import net.minecraft.world.entity.LivingEntity;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.ConditionlessAttack;

public class SpinAttack<E extends LivingEntity> extends ConditionlessAttack<E> {
    public SpinAttack(int delayTicks) {
        super(delayTicks);

        attack(this::doSpin);
    }

    protected void doSpin(E entity) {

    }
}
