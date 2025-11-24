package mod.noobulus.badastratweaks.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.sugar.Local;
import mod.noobulus.badastratweaks.BadAstraTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class LivingEntityMixinMixin extends Entity {
    @Unique
    Attribute badAstraTweaks$gravityAttribute = ForgeRegistries.ATTRIBUTES.getValue(ResourceLocation.parse("forge:entity_gravity"));

    @Unique
    UUID badAstraTweaks$modifierUUID = UUID.fromString("290314c5-5379-4e35-868c-45f0ac53589d");

    protected LivingEntityMixinMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @TargetHandler(
            mixin = "earth.terrarium.adastra.mixins.common.LivingEntityMixin",
            name = "adastra$travel"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInWater()Z"), cancellable = true)
    private void sevenToTenLayersOfMixins(Vec3 travelVector, CallbackInfo originalCi, CallbackInfo ci, @Local(ordinal = 0) float gravity) {
        double modifierValue = badAstraTweaks$calculateModifierValue(gravity);
        AttributeInstance instance = ((LivingEntity) (Object) this).getAttribute(badAstraTweaks$gravityAttribute);
        AttributeModifier currentModifier = instance.getModifier(badAstraTweaks$modifierUUID);
        if (currentModifier != null && currentModifier.getAmount() == modifierValue) {
            ci.cancel();
            return;
        }
        instance.removeModifier(badAstraTweaks$modifierUUID);
        instance.addTransientModifier(badAstraTweaks$makeModifier(modifierValue));
        ci.cancel();
    }

    @Unique
    private double badAstraTweaks$calculateModifierValue(float gravity) {
        double grav = (gravity) - 1; // subtract 1 for multiply_base weirdness
        return grav;
    }

    @Unique
    private AttributeModifier badAstraTweaks$makeModifier(double modifierValue) {
        return new AttributeModifier(badAstraTweaks$modifierUUID, "Bad Astra Gravity Modifier", modifierValue, AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
