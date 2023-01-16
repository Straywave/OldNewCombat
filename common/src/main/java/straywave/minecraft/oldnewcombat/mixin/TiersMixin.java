package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.item.Tiers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Tiers.class)
public class TiersMixin {
    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 1.0F))
    private static float setStoneDamage(float constant) {
        return 0.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 2.0F, ordinal = 1))
    private static float setIronDamage(float constant) {
        return 1.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 3.0F))
    private static float setDiamondDamage(float constant) {
        return 2.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 4.0F, ordinal = 1))
    private static float setNetheriteDamage(float constant) {
        return 3.0F;
    }
}
