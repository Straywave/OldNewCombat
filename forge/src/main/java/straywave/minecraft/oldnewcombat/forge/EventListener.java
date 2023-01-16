package straywave.minecraft.oldnewcombat.forge;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import straywave.minecraft.oldnewcombat.Attributes;

public class EventListener {
    #if MC_1_16_5
    private static final Attribute RANGE_ATTRIBUTE = ForgeMod.REACH_DISTANCE.get();
    #else
    private static final Attribute RANGE_ATTRIBUTE = ForgeMod.ATTACK_RANGE.get();
    #endif

    @SubscribeEvent
    public static void onItemAttributeModifierEvent(ItemAttributeModifierEvent event) {
        if (event.getSlotType() != EquipmentSlot.MAINHAND) return;
        Item item = event.getItemStack().getItem();

        if (item instanceof SwordItem) {
            event.addModifier(RANGE_ATTRIBUTE, new AttributeModifier(Attributes.ATTACK_REACH_UUID, "Weapon modifier", 0.5, AttributeModifier.Operation.ADDITION));
        } else if (item instanceof HoeItem || item instanceof TridentItem) {
            event.addModifier(RANGE_ATTRIBUTE, new AttributeModifier(Attributes.ATTACK_REACH_UUID, "Weapon modifier", 1.0, AttributeModifier.Operation.ADDITION));
        }
    }

    @SubscribeEvent
    public static void onEntityAttributeModificationEvent(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, RANGE_ATTRIBUTE, 2.5D);
    }
}
