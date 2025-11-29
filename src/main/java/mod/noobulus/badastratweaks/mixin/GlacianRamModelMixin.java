package mod.noobulus.badastratweaks.mixin;

import earth.terrarium.adastra.client.models.entities.mobs.GlacianRamModel;
import earth.terrarium.adastra.common.entities.mob.GlacianRam;
import mod.noobulus.badastratweaks.BadAstraTweaks;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GlacianRamModel.class, remap = false)
public class GlacianRamModelMixin<T extends GlacianRam> extends QuadrupedModel<T> {

    protected GlacianRamModelMixin(ModelPart p_170857_, boolean p_170858_, float p_170859_, float p_170860_, float p_170861_, float p_170862_, int p_170863_) {
        super(p_170857_, p_170858_, p_170859_, p_170860_, p_170861_, p_170862_, p_170863_);
    }

    /*@ModifyConstant(method = "setupAnim(Learth/terrarium/adastra/common/entities/mob/GlacianRam;FFFFF)V", constant = @Constant(floatValue = 0))
    private float unreverseBabyRamHeads(float constant) {
        return 180;
    }

    @ModifyArg(method = "setupAnim(Learth/terrarium/adastra/common/entities/mob/GlacianRam;FFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/QuadrupedModel;setupAnim(Lnet/minecraft/world/entity/Entity;FFFFF)V"), index = 5)
    private float invertHeadPitch(float pitch) {
        return pitch + 180;
    }*/

    @Inject(method = "setupAnim(Learth/terrarium/adastra/common/entities/mob/GlacianRam;FFFFF)V", at = @At("HEAD"))
    private void debugDotLog(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        //BadAstraTweaks.LOGGER.info(String.valueOf(young) + " " + String.valueOf(((GlacianRamModel) (Object) this).young));
    }
}
