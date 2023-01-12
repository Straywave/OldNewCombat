package straywave.minecraft.oldnewcombat.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import straywave.minecraft.oldnewcombat.OldNewCombat;

// Currently not included due to java.lang.NoClassDefFoundError: org/spongepowered/asm/synthetic/args/Args$1
@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {
    @Shadow @Final private Minecraft minecraft;

    ItemStack stack = ItemStack.EMPTY;
    float partialTicks = 0.0F;

    @Inject(method = "renderArmWithItem", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureItemStack(AbstractClientPlayer player, float partialTicks, float pitch, InteractionHand hand, float swingProgress, ItemStack stack, float equippedProgress, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, CallbackInfo ci) {
        this.stack = stack;
        this.partialTicks = partialTicks;
    }

    @ModifyArgs(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", ordinal = 6))
    private void injected(Args args) {
        float duration = stack.getUseDuration() - (minecraft.player.getUseItemRemainingTicks() - partialTicks + 1.0F);

        // This took too long to figure out
        float jitter = Mth.sin((duration - 0.1F) * 1.3F);
        float fatigue = OldNewCombat.getBowFatigueForTime((int) duration);
        float position = jitter * fatigue;

        args.set(0, (double) (position * 0.0F));
        args.set(1, (double) (position * 0.004F));
        args.set(2, (double) (position * 0.0F));
    }
}
