package mod.noobulus.badastratweaks.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.momosoftworks.coldsweat.api.util.Temperature;
import com.momosoftworks.coldsweat.util.world.WorldHelper;
import earth.terrarium.adastra.AdAstra;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = AdAstra.class, remap = false)
public class AdAstraMixin {

    /*@ModifyVariable(method = "lambda$onServerTick$0(Lnet/minecraft/server/level/ServerPlayer;)V", at = @At(value = "INVOKE_ASSIGN", target = "Learth/terrarium/adastra/api/systems/TemperatureApi;getTemperature(Lnet/minecraft/world/entity/Entity;)S"), ordinal = 1)
    private static short injectedTemperature(short original, @Local(argsOnly = true) ServerPlayer player) {
        Level level = player.level();
        BlockPos pos = player.blockPosition();
        return (short) Temperature.convert(WorldHelper.getTemperatureAt(level, pos), Temperature.Units.MC, Temperature.Units.C, true);
    }*/
}
