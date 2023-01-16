package straywave.minecraft.oldnewcombat.fabric.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import straywave.minecraft.oldnewcombat.Attributes;

@Mixin(SwordItem.class)
public class SwordItemMixin {
    @Inject(method = "getDefaultAttributeModifiers", at = @At("RETURN"), cancellable = true)
    private void addAttackReachAttribute(EquipmentSlot slot, CallbackInfoReturnable<Multimap<Attribute, AttributeModifier>> cir) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(cir.getReturnValue());
            builder.put(Attributes.ATTACK_REACH, new AttributeModifier(Attributes.ATTACK_REACH_UUID, "Weapon modifier", 0.5D, AttributeModifier.Operation.ADDITION));
            cir.setReturnValue(builder.build());
        }
    }
}
