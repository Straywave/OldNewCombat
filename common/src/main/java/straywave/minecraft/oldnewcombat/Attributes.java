package straywave.minecraft.oldnewcombat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import straywave.minecraft.oldnewcombat.OldNewCombat;

#if MC_1_16_5
import me.shedaniel.architectury.registry.Registry;
import net.minecraft.world.entity.ai.attributes.Attribute;
#else
import dev.architectury.registry.registries.Registrar;
import net.minecraft.core.Registry;
#endif

import java.util.UUID;

public class Attributes {
    #if MC_1_16_5
    private static final Registry<Attribute> ATTRIBUTES = OldNewCombat.REGISTRIES.get().get(net.minecraft.core.Registry.ATTRIBUTE_REGISTRY);
    #else
    private static final Registrar<net.minecraft.world.entity.ai.attributes.Attribute> ATTRIBUTES = OldNewCombat.REGISTRIES.get().get(Registry.ATTRIBUTE_REGISTRY);
    #endif

    public static final UUID ATTACK_REACH_UUID = UUID.fromString("26CB07A3-209D-4110-8E10-1010243614C8");
    public static net.minecraft.world.entity.ai.attributes.Attribute ATTACK_REACH = null;

    public static void register() {
        // This should only be called on Fabric as on Forge we use the built-in attribute.
        ATTACK_REACH = ATTRIBUTES.register(new ResourceLocation(OldNewCombat.MOD_ID, "generic.attack_reach"), () -> new RangedAttribute("generic.attack_reach", 2.5, 0.0, 6.0).setSyncable(true)).get();
    }

    public static float getAttackReachForPlayer(Player player, float adjustTicks) {
        float attackStrength = player.getAttackStrengthScale(adjustTicks);
        float baseAttackReach = (float) player.getAttribute(ATTACK_REACH).getValue();
        float reach = baseAttackReach + ((attackStrength > 1.95F && !player.isCrouching()) ? 1.0F : 0.0F);
        return reach == 0 ? 0 : (player.isCreative() ? reach + 3.0F : reach);
    }
}
