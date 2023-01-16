package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import straywave.minecraft.oldnewcombat.OldNewCombat;

import java.util.Optional;

@Mixin(Minecraft.class)
public class MinecraftMixin {
//    @Shadow
//    public LocalPlayer player;
//
//    @Redirect(method = "startAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/HitResult;getType()Lnet/minecraft/world/phys/HitResult$Type;"))
//    private HitResult.Type checkAttackRange(HitResult instance) {
//        if (instance instanceof EntityHitResult entityHit) {
//            float reach = OldNewCombat.getAttackReachForPlayer(player, 0.0F);
//            Entity entity = entityHit.getEntity();
//            Vec3 eye = player.getEyePosition();
//            Vec3 targetCenter = entity.getPosition(1.0F).add(0, entity.getBbHeight() / 2, 0);
//            Optional<Vec3> hit = entity.getBoundingBox().clip(eye, targetCenter);
//            if ((hit.map(eye::distanceToSqr).orElseGet(() -> player.distanceToSqr(entity))) >= reach * reach) {
//                return HitResult.Type.MISS;
//            }
//        }
//
//        return instance.getType();
//    }
}
