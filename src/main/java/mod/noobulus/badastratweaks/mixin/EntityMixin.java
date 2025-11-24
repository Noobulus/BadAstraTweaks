package mod.noobulus.badastratweaks.mixin;

import mod.noobulus.badastratweaks.util.GravityTweakHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Entity.class)
public abstract class EntityMixin extends net.minecraftforge.common.capabilities.CapabilityProvider<Entity> {

    @Shadow public float fallDistance;

    protected EntityMixin(Class<Entity> baseClass) {
        super(baseClass);
    }

    @ModifyArg(method = "checkFallDamage(DZLnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;fallOn(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;F)V"), index = 4)
    private float scaleByGravityAttribute(float fallDistance) {
        Entity target = ((Entity) (Object) this);
        if (target instanceof LivingEntity) {
            fallDistance = GravityTweakHelper.computeScaledFallDistance(fallDistance, (LivingEntity) target);
        }
        return fallDistance;
    }
}
