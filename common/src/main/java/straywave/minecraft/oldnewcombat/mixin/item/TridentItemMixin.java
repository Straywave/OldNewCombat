package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TridentItem.class)
public class TridentItemMixin {
    @ModifyConstant(method = "<init>", constant = @Constant(doubleValue = 8.0))
    private double tridentAttackDamage(double constant) {
        return constant - 3.0;
    }

    @ModifyConstant(method = "<init>", constant = @Constant(doubleValue = -2.9000000953674316))
    private double tridentAttackSpeed(double constant) {
        return -2.0;
    }
}
