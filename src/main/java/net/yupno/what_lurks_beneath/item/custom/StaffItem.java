package net.yupno.what_lurks_beneath.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.yupno.what_lurks_beneath.entity.meteor.MeteorEntity;

import java.util.Random;

public class StaffItem extends Item {
    public StaffItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.startUsingItem(pUsedHand);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player && (pRemainingUseDuration % 10 == 0 && pRemainingUseDuration < 90)){
            player.hurt(player.damageSources().magic(), 1);
        }

        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            if(!pLevel.isClientSide){
                player.getCooldowns().addCooldown(this, 200);
            }

            Random random = new Random();

            for (int amount = 0; amount < 100; amount++) {
                pLevel.addFreshEntity(new MeteorEntity(pLevel,
                        random.nextDouble(player.getX()- 100, player.getX() + 100), // X Position
                        pLevel.getMaxBuildHeight() + random.nextDouble(-100, 100), // Y Position
                        random.nextDouble(player.getZ()- 100, player.getZ() + 100), // Z Position
                        random.nextFloat(-0.1F, 0.1F), // X Offset
                        -1, // Y Offset
                        random.nextFloat(-0.1F, 0.1F), // Z Offset
                        2.5F + random.nextFloat(-1.5F, 1.5F)
                ));
            }

            pStack.hurtAndBreak(1, player, (p_276007_) -> {
                p_276007_.broadcastBreakEvent(player.getUsedItemHand());
            });
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    public int getUseDuration(ItemStack pStack) {
        return 100;
    }
}
