package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    DamageSource source = DamageSource.GENERIC;
    float amount = 0.0F;

    protected LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

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
    private float onlyBlockSomeDamageAndExplosions(float constant) {
        if (source.isExplosion() && !(source.getEntity() instanceof Player)) return 0.0F;
        return Math.max(amount - 5.0F, 0.0F);
    }

    @ModifyVariable(method = "hurt", at = @At("STORE"), ordinal = 0)
    private boolean setIsFullyBlockedFlag(boolean value) {
        return (amount - 5.0F) <= 0.0F; // This determines whether to shake the screen.
    }

    @Inject(method = "isDamageSourceBlocked", at = @At("HEAD"), cancellable = true)
    private void blockNonPlayerExplosions(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource.isExplosion() && !(damageSource.getEntity() instanceof Player)) cir.setReturnValue(true);
    }

    @Inject(method = "isDamageSourceBlocked", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getViewVector(F)Lnet/minecraft/world/phys/Vec3;", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void setBlockingArc(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir, Entity entity, boolean bl, Vec3 source) {
        if (source != null) {
            Vec3 view = this.getViewVector(1.0F);
            if (view.y > -0.99D && view.y < 0.99D) {
                view = (new Vec3(view.x, 0.0D, view.z)).normalize();
                Vec3 var5 = source.vectorTo(this.position());
                var5 = (new Vec3(var5.x, 0.0D, var5.z)).normalize();
                if (var5.dot(view) * (double)(float)Math.PI < (double)-0.87266463F) {
                    cir.setReturnValue(true);
                    return;
                }
            }
        }

        cir.setReturnValue(false);
    }
}
