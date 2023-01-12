package straywave.minecraft.oldnewcombat;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;

public class CleavingEnchantment extends DamageEnchantment {
    public static final String ID = "cleaving";

    public CleavingEnchantment() {
        super(Rarity.UNCOMMON, 0, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof AxeItem;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
