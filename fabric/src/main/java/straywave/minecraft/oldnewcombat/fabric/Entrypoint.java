package straywave.minecraft.oldnewcombat.fabric;

import net.fabricmc.api.ModInitializer;
import straywave.minecraft.oldnewcombat.OldNewCombat;

public class Entrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        OldNewCombat.init();
    }
}
