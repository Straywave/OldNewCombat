package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    DamageSource source = DamageSource.GENERIC;
    float amount = 0.0F;

    @ModifyConstant(method = "isBlocking", constant = @Constant(intValue = 5))
    private int forceSkipBlockDelay(int constant) {
        return 0; // Ticks, 5 => 0
    }

    @Inject(method = "hurt", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureLocals(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        this.source = source;
        this.amount = amount;
    }

    @Redirect(method = "hurt", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/LivingEntity;invulnerableTime:I", opcode = Opcodes.PUTFIELD))
    private void skipProjectileInvulnerability(LivingEntity instance, int value) {
        if (!source.isProjectile()) instance.invulnerableTime = value;
    }

    @ModifyConstant(method = "hurt", constant = @Constant(floatValue = 0.0F, ordinal = 2))
    private float onlyBlockSomeDamage(float constant) {
        if (source.isExplosion() && !(source.getEntity() instanceof Player)) return 0.0F;
        return amount - 5.0F;
    }

    @Inject(method = "isDamageSourceBlocked", at = @At("HEAD"), cancellable = true)
    private void blockNonPlayerExplosions(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource.isExplosion() && !(damageSource.getEntity() instanceof Player)) cir.setReturnValue(true);
    }

    @ModifyVariable(method = "hurt", at = @At("STORE"), ordinal = 0)
    private boolean setFlag(boolean value) {
        return !(amount > 0.0F);
    }
}
