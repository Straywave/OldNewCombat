package straywave.minecraft.oldnewcombat;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

#if MC_1_16_5
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
#elif MC_1_18_2
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.Registrar;
#endif

import java.util.function.Supplier;

public class OldNewCombat {
    public static String MOD_ID = "oldnewcombat";
    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    private static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

    #if MC_1_16_5
    private static final Registry<Enchantment> ENCHANTMENTS = REGISTRIES.get().get(net.minecraft.core.Registry.ENCHANTMENT_REGISTRY);
    private static final Registry<Attribute> ATTRIBUTES = REGISTRIES.get().get(net.minecraft.core.Registry.ATTRIBUTE_REGISTRY);
    #elif MC_1_18_2
    private static final Registrar<Enchantment> ENCHANTMENTS = REGISTRIES.get().get(net.minecraft.core.Registry.ENCHANTMENT_REGISTRY);
    private static final Registrar<Attribute> ATTRIBUTES = REGISTRIES.get().get(net.minecraft.core.Registry.ATTRIBUTE_REGISTRY);
    #endif

    public static final Supplier<Enchantment> ENCHANTMENT_CLEAVING = ENCHANTMENTS.register(new ResourceLocation(MOD_ID, CleavingEnchantment.ID), CleavingEnchantment::new);
    public static final Supplier<Attribute> ATTRIBUTE_ATTACK_REACH = ATTRIBUTES.register(new ResourceLocation(MOD_ID, AttackReachAttribute.ID), AttackReachAttribute::new);

    public static void init() {
    }

    public static float getBowFatigueForTime(int charge) {
        if (charge < 60) {
            return 0.5F;
        } else {
            return charge >= 200 ? 10.5F : 0.5F + 10.0F * (float)(charge - 60) / 140.0F;
        }
    }

    public static float getAttackReachForPlayer(Player player, float adjustTicks) {
        float attackStrength = player.getAttackStrengthScale(adjustTicks);
        float baseAttackReach = (float) player.getAttribute(ATTRIBUTE_ATTACK_REACH.get()).getValue();
        return baseAttackReach + ((attackStrength > 1.95F && !player.isCrouching()) ? 1.0F : 0.0F);
    }
}
