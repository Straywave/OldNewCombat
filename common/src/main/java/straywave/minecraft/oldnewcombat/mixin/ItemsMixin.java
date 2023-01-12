package straywave.minecraft.oldnewcombat.mixin;

import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Items.class)
public class ItemsMixin {
    private static final float SWORD_ATTACK_SPEED = -1.0F;
    private static final float AXE_ATTACK_SPEED = -2.0F;
    private static final float PICKAXE_ATTACK_SPEED = -1.5F;

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 1, ordinal = 53))
    private static int stackSizePotion(int constant) {
        return 16;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 16, ordinal = 9))
    private static int stackSizeSnowball(int constant) {
        return 64;
    }

    // === Sword Damage ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 3, ordinal = 1))
    private static int damageSwordStone(int constant) {
        return constant - 2;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 3, ordinal = 3))
    private static int damageSwordIron(int constant) {
        return constant - 2;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 3, ordinal = 4))
    private static int damageSwordDiamond(int constant) {
        return constant - 2;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 3, ordinal = 5))
    private static int damageSwordNetherite(int constant) {
        return constant - 2;
    }

    // === Sword Attack Speed ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 0))
    private static float attackSpeedSwordWood(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 1))
    private static float attackSpeedSwordStone(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 2))
    private static float attackSpeedSwordGold(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 3))
    private static float attackSpeedSwordIron(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 4))
    private static float attackSpeedSwordDiamond(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.4F, ordinal = 5))
    private static float attackSpeedSwordNetherite(float constant) {
        return SWORD_ATTACK_SPEED;
    }

    // === Axe Damage ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 6.0F, ordinal = 0))
    private static float damageAxeWood(float constant) {
        return constant - 3.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 7.0F, ordinal = 0))
    private static float damageAxeStone(float constant) {
        return constant - 5.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 6.0F, ordinal = 1))
    private static float damageAxeGold(float constant) {
        return constant - 3.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 6.0F, ordinal = 2))
    private static float damageAxeIron(float constant) {
        return constant - 4.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 5.0F, ordinal = 0))
    private static float damageAxeDiamond(float constant) {
        return constant - 3.0F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 5.0F, ordinal = 1))
    private static float damageAxeNetherite(float constant) {
        return constant - 3.0F;
    }

    // === Axe Attack Speed ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.2F, ordinal = 0))
    private static float attackSpeedAxeWood(float constant) {
        return AXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.2F, ordinal = 1))
    private static float attackSpeedAxeStone(float constant) {
        return AXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.0F, ordinal = 4))
    private static float attackSpeedAxeGold(float constant) {
        return AXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.1F, ordinal = 0))
    private static float attackSpeedAxeIron(float constant) {
        return AXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.0F, ordinal = 8))
    private static float attackSpeedAxeDiamond(float constant) {
        return AXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.0F, ordinal = 10))
    private static float attackSpeedAxeNetherite(float constant) {
        return AXE_ATTACK_SPEED;
    }

    // === Hoe Damage ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 0, ordinal = 0))
    private static int damageHoeWood(int constant) {
        return constant;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = -1, ordinal = 0))
    private static int damageHoeStone(int constant) {
        return constant;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 0, ordinal = 1))
    private static int damageHoeGold(int constant) {
        return constant;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = -2))
    private static int damageHoeIron(int constant) {
        return constant + 1;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = -3))
    private static int damageHoeDiamond(int constant) {
        return constant + 1;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = -4))
    private static int damageHoeNetherite(int constant) {
        return constant + 2;
    }

    // === Hoe Attack Speed ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.0F, ordinal = 1))
    private static float attackSpeedHoeWood(float constant) {
        return constant + 1;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.0F, ordinal = 0))
    private static float attackSpeedHoeStone(float constant) {
        return constant + 0.5F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -3.0F, ordinal = 5))
    private static float attackSpeedHoeGold(float constant) {
        return constant + 2.5F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 0.0F, ordinal = 0))
    private static float attackSpeedHoeDiamond(float constant) {
        return constant - 0.5F;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = 0.0F, ordinal = 1))
    private static float attackSpeedHoeNetherite(float constant) {
        return constant - 0.5F;
    }

    // === Pickaxe Damage ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 1, ordinal = 0))
    private static int damagePickaxeWood(int constant) {
        return constant - 1;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 1, ordinal = 3))
    private static int damagePickaxeGold(int constant) {
        return constant - 1;
    }

    // === Pickaxe Attack Speed ===

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 0))
    private static float attackSpeedPickaxeWood(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 1))
    private static float attackSpeedPickaxeStone(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 2))
    private static float attackSpeedPickaxeGold(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 3))
    private static float attackSpeedPickaxeIron(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 4))
    private static float attackSpeedPickaxeDiamond(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }

    @ModifyConstant(method = "<clinit>", constant = @Constant(floatValue = -2.8F, ordinal = 5))
    private static float attackSpeedPickaxeNetherite(float constant) {
        return PICKAXE_ATTACK_SPEED;
    }
}
