package straywave.minecraft.oldnewcombat.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import straywave.minecraft.oldnewcombat.OldNewCombat;

#if MC_1_16_5
import me.shedaniel.architectury.platform.forge.EventBuses;
#elif MC_1_18_2
import dev.architectury.platform.forge.EventBuses;
#endif

@Mod(Entrypoint.MOD_ID)
public class Entrypoint {
    public static final String MOD_ID = "oldnewcombat";

    public Entrypoint() {
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        OldNewCombat.init();
    }
}
