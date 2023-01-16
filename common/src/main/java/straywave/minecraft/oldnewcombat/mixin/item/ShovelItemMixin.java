package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ShovelItem.class)
public class ShovelItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 1, argsOnly = true)
    private static float setAttackSpeed(float value) {
        return -2.0F;
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float setAttackDamage(float value) {
        return 0.0F;
    }
}
