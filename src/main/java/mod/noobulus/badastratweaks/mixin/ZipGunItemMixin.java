package mod.noobulus.badastratweaks.mixin;

import earth.terrarium.adastra.common.items.ZipGunItem;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ZipGunItem.class)
public class ZipGunItemMixin {
    @ModifyArg(method = "onUseTick(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;addDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private Vec3 respectNewton(Vec3 thrustDirection) {
        return thrustDirection.multiply(-1, -1, -1); // reverse it because that's how this actually works
    }
}
