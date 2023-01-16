package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ PotionItem.class, MilkBucketItem.class /*, HoneyBottleItem.class */ })
public class DrinkableMixin {
    @ModifyConstant(method = "getUseDuration", constant = @Constant(intValue = 32))
    private int lowerUseDuration(int constant) {
        return 20;
    }
}
