package mod.noobulus.badastratweaks.mixin;

import earth.terrarium.adastra.client.renderers.ti69.apps.SensorApp;
import mod.noobulus.badastratweaks.network.ClientData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = SensorApp.class, remap = false)
public class SensorAppMixin {

    @ModifyArg(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lorg/joml/Matrix4f;Lnet/minecraft/client/gui/Font;Lnet/minecraft/client/multiplayer/ClientLevel;Z)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;", ordinal = 0), index = 1)
    private Object[] reportColdSweatTemperature(Object[] originalTemp) {
        return new Object[]{ClientData.getLocalTemperature()};
    }

}
