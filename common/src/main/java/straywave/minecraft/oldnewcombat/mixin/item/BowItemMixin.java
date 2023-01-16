package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import straywave.minecraft.oldnewcombat.OldNewCombat;

@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @Shadow public abstract int getUseDuration(ItemStack stack);
    private int holdDuration = 0;

    @Inject(method = "releaseUsing", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureHoldDuration(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged, CallbackInfo ci) {
        holdDuration = getUseDuration(stack) - timeCharged;
    }

    @ModifyArg(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;setCritArrow(Z)V"), index = 0)
    private boolean setCriticalArrow(boolean critArrow) {
        return OldNewCombat.getBowFatigueForTime(holdDuration) <= 0.5F;
    }

    @ModifyArg(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow;shootFromRotation(Lnet/minecraft/world/entity/Entity;FFFFF)V"), index = 5)
    private float setInaccuracy(float par2) {
        return 0.25F * OldNewCombat.getBowFatigueForTime(holdDuration);
    }
}
