package mod.noobulus.badastratweaks.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class GravityTweakHelper {

    static Attribute gravityAttribute = ForgeRegistries.ATTRIBUTES.getValue(ResourceLocation.parse("forge:entity_gravity"));
    static UUID modifierUUID = UUID.fromString("290314c5-5379-4e35-868c-45f0ac53589d");

    public static void applyGravity(LivingEntity target, float gravity) {
        double modifierValue = calculateModifierValue(gravity);
        AttributeInstance instance = getInstance(target);
        AttributeModifier currentModifier = getModifier(instance);
        if (currentModifier != null && currentModifier.getAmount() == modifierValue) {
            return; // we don't need to touch the modifier
        }
        instance.removeModifier(modifierUUID); // remove old modifier because the game says so
        instance.addTransientModifier(makeModifier(modifierValue));
    }

    public static AttributeInstance getInstance(LivingEntity target) {
        return target.getAttribute(gravityAttribute);
    }

    public static AttributeModifier getModifier(AttributeInstance instance) {
        return instance.getModifier(modifierUUID);
    }

    private static double calculateModifierValue(float gravity) {
        return (gravity) - 1; // subtract 1 for multiply_base weirdness
    }

    private static AttributeModifier makeModifier(double modifierValue) {
        return new AttributeModifier(modifierUUID, "Bad Astra Gravity Modifier", modifierValue, AttributeModifier.Operation.MULTIPLY_BASE);
    }

    public static float computeScaledFallDistance(float fallDistance, LivingEntity target) {
        return (float) (fallDistance * (getModifier(getInstance(target)).getAmount() + 1));
    }
}
