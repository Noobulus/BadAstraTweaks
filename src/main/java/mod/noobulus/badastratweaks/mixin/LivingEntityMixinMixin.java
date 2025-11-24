package mod.noobulus.badastratweaks.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.sugar.Local;
import mod.noobulus.badastratweaks.util.GravityTweakHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class LivingEntityMixinMixin extends Entity {

    protected LivingEntityMixinMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @TargetHandler(
            mixin = "earth.terrarium.adastra.mixins.common.LivingEntityMixin",
            name = "adastra$travel"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInWater()Z"), cancellable = true)
    private void injectGravityTweak(Vec3 travelVector, CallbackInfo originalCi, CallbackInfo ci, @Local(ordinal = 0) float gravity) {
        GravityTweakHelper.applyGravity(((LivingEntity) (Object) this), gravity);
        ci.cancel();
    }
}
