package straywave.minecraft.oldnewcombat.fabric.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import straywave.minecraft.oldnewcombat.Attributes;

@Mixin(DiggerItem.class)
public abstract class DiggerItemMixin {
    @Inject(method = "getDefaultAttributeModifiers", at = @At("RETURN"), cancellable = true)
    private void doIt(EquipmentSlot slot, CallbackInfoReturnable<Multimap<Attribute, AttributeModifier>> cir) {
        if (slot == EquipmentSlot.MAINHAND && (Object)this instanceof HoeItem) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(cir.getReturnValue());
            builder.put(Attributes.ATTACK_REACH, new AttributeModifier(Attributes.ATTACK_REACH_UUID, "Weapon modifier", 1.0D, AttributeModifier.Operation.ADDITION));
            cir.setReturnValue(builder.build());
        }
    }
}
