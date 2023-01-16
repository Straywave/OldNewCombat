package straywave.minecraft.oldnewcombat;

import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

#if MC_1_16_5
import me.shedaniel.architectury.registry.Registries;
import me.shedaniel.architectury.registry.Registry;
#else
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.Registrar;
#endif

import java.util.UUID;
import java.util.function.Supplier;

public class OldNewCombat {
    public static String MOD_ID = "oldnewcombat";
    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

    public static void init() {
        Enchantments.register();
    }

    public static float getBowFatigueForTime(int charge) {
        if (charge < 60) {
            return 0.5F;
        } else {
            return charge >= 200 ? 10.5F : 0.5F + 10.0F * (float)(charge - 60) / 140.0F;
        }
    }
}
