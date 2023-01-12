package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import straywave.minecraft.oldnewcombat.OldNewCombat;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow public abstract float getAttackStrengthScale(float adjustTicks);

    int attackerCleavingLevel = 0;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyConstant(method = "createAttributes", constant = @Constant(doubleValue = 1.0))
    private static double doubleFistAttackDamage(double constant) {
        return constant * 2; // 1.0 => 2.0
    }

    @Inject(method = "blockUsingShield", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureAttackerCleavingEnchantment(LivingEntity attacker, CallbackInfo ci) {
        this.attackerCleavingLevel = EnchantmentHelper.getEnchantmentLevel(OldNewCombat.ENCHANTMENT_CLEAVING.get(), attacker);
    }

    @ModifyConstant(method = "disableShield", constant = @Constant(floatValue = 0.75F))
    private float forceAxesAlwaysDisableShields(float constant) {
        return 1.0F; // Any random float will always be lower than 1.0
    }

    @ModifyConstant(method = "disableShield", constant = @Constant(intValue = 100))
    private int calculateBlockDuration(int constant) {
        return 32 + (attackerCleavingLevel * 10);
    }

    @ModifyVariable(method = "attack", at = @At("STORE"), ordinal = 4)
    private boolean sweepIfChargedAndHasSweepingEdge(boolean value) {
        return getAttackStrengthScale(0.5F) == 1.0F && EnchantmentHelper.getSweepingDamageRatio(this) != 0.0F;
    }

    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"), index = 1)
    private float nerfSweepingAttack(float amount) {
        return amount / 2;
    }

//    Breaks hand item rendering
//    @ModifyConstant(method = "getAttackStrengthScale", constant = @Constant(floatValue = 1.0F))
//    private float doubleChargedAttacks(float constant) {
//        return constant * 2; // 1.0F => 2.0F (200% Charged Attacks)
//    }
}
