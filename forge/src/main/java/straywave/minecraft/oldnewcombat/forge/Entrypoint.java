package straywave.minecraft.oldnewcombat.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import straywave.minecraft.oldnewcombat.OldNewCombat;

#if MC_1_16_5
import me.shedaniel.architectury.platform.forge.EventBuses;
#else
import dev.architectury.platform.forge.EventBuses;
#endif

@Mod(Entrypoint.MOD_ID)
public class Entrypoint {
    public static final String MOD_ID = "oldnewcombat";

    public Entrypoint() {
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        OldNewCombat.init();
        MinecraftForge.EVENT_BUS.register(EventListener.class);
    }
}
