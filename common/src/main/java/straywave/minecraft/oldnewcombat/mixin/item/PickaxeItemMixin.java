package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PickaxeItem.class)
public class PickaxeItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float setAttackSpeed(float value) {
        return -1.5F;
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static int setAttackDamage(int value) {
        return 1;
    }
}
