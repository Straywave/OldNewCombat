package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HoeItem.class)
public class HoeItemMixin {
    private static int itemCount = 0;

    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float setAttackSpeed(float value) {
        if (value == -3.0F) {
            itemCount++; // Dirty hack as wood and gold share same value
            if (itemCount == 1) return value + 1.0F; // Wood
            else return value + 2.5F; // Gold
        } else if (value == -2.0F) return value + 0.5F; // Stone
        else if (value == -1.0F) return value; // Iron
        else if (value == 0.0F) return value - 0.5F; // Diamond, Netherite
        else return value + 1.5F; // Baseline for unknown attack speeds (custom)
    }

    @ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
    private static int setAttackDamage(int value) {
        if (value <= -3) return -1; // Diamond, Netherite
        else return 0;
    }
}
