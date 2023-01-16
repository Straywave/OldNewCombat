package straywave.minecraft.oldnewcombat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;

#if MC_1_16_5
import me.shedaniel.architectury.registry.Registry;
#else
import dev.architectury.registry.registries.Registrar;
import net.minecraft.core.Registry;
#endif

import java.util.function.Supplier;

public class Enchantments {
    #if MC_1_16_5
    private static final Registry<Enchantment> ENCHANTMENTS = OldNewCombat.REGISTRIES.get().get(net.minecraft.core.Registry.ENCHANTMENT_REGISTRY);
    #else
    private static final Registrar<Enchantment> ENCHANTMENTS = OldNewCombat.REGISTRIES.get().get(Registry.ENCHANTMENT_REGISTRY);
    #endif

    public static final Supplier<Enchantment> CLEAVING = ENCHANTMENTS.register(new ResourceLocation(OldNewCombat.MOD_ID, "cleaving"), () -> new DamageEnchantment(Enchantment.Rarity.UNCOMMON, 0, EquipmentSlot.MAINHAND) {
        @Override
        public boolean canEnchant(ItemStack stack) {
            return stack.getItem() instanceof AxeItem;
        }

        @Override
        public int getMaxLevel() {
            return 3;
        }
    });

    public static void register() {
        /* no-op */
    }
}
