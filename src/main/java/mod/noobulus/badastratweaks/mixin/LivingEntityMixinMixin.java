package mod.noobulus.badastratweaks.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import mod.noobulus.badastratweaks.BadAstraTweaks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class LivingEntityMixinMixin {
    @TargetHandler(
            mixin = "earth.terrarium.adastra.mixins.common.LivingEntityMixin",
            name = "adastra$travel"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInWater()Z"), cancellable = true)
    private void sevenToTenLayersOfMixins(Vec3 travelVector, CallbackInfo originalCi, CallbackInfo ci) {
        BadAstraTweaks.LOGGER.info("Injecting into adastra$travel");
        ci.cancel();
    }
}
