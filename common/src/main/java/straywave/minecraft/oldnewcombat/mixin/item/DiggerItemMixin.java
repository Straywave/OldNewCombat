package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(DiggerItem.class)
public abstract class DiggerItemMixin extends TieredItem implements Vanishable {
    public DiggerItemMixin(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @ModifyConstant(method = "hurtEnemy", constant = @Constant(intValue = 2))
    private int disableDurabilityPenaltyForAxes(int constant) {
        Item item = this;
        return item instanceof AxeItem ? 1 : constant;
    }
}
