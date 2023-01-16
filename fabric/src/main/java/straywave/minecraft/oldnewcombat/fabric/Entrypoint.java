package straywave.minecraft.oldnewcombat.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import straywave.minecraft.oldnewcombat.Attributes;
import straywave.minecraft.oldnewcombat.OldNewCombat;

public class Entrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        OldNewCombat.init();
        Attributes.register();
        FabricDefaultAttributeRegistry.register(EntityType.PLAYER, Player.createAttributes().add(Attributes.ATTACK_REACH));
    }
}
