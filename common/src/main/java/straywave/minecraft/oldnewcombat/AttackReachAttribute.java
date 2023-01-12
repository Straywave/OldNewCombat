package straywave.minecraft.oldnewcombat;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.UUID;

public class AttackReachAttribute extends RangedAttribute {
    public static final String ID = "generic.attack_reach";
    public static final UUID BASE_ATTACK_REACH_UUID = UUID.fromString("26CB07A3-209D-4110-8E10-1010243614C8");

    public AttackReachAttribute() {
        super("attribute.name.generic.attack_reach", 2.5, 0.0, 6.0);
    }
}
