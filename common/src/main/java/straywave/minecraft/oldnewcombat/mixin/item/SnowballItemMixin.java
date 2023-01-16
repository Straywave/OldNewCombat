package straywave.minecraft.oldnewcombat.mixin.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SnowballItem.class)
public class SnowballItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static Item.Properties setMaxStackSize(Item.Properties properties) {
        return properties.stacksTo(64);
    }
}
