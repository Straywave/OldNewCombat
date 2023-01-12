package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FoodData.class)
public class FoodDataMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isHurt()Z", ordinal = 0))
    private boolean skipSaturationRegenerationBoost(Player instance) {
        return false; // Skips boost in natural regeneration that occurs if saturation is high
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 18))
    private int regenerateUntilLowerHunger(int constant) {
        return 7; // 18 => 7 Hunger Points
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 80, ordinal = 0))
    private int fasterNaturalRegeneration(int constant) {
        return constant / 2; // 80 => 40 Ticks
    }

    @ModifyConstant(method = "tick", constant = @Constant(floatValue = 6.0F, ordinal = 2))
    private float drainLessFoodWhenRegenerating(float constant) {
        return constant / 2; // 6.0F => 3.0F Exhaustion
    }
}
