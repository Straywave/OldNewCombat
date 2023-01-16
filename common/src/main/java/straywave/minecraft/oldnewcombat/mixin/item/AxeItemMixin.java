package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SwordItem.class)
public class AxeItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float setAttackSpeed(float value) {
        return -2.0F;
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static int setAttackDamage(int value) {
        return 3;
    }
}
