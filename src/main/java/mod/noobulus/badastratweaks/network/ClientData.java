package mod.noobulus.badastratweaks.network;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT) // sourcesets are almost certainly better but we ball
public class ClientData {
    private static short localAirState;
    private static short localTemperature;

    public static void updateLocalData(AdditionalData data) {
        localAirState = data.getAirState();
        localTemperature = data.getTemperature();
    }

    public static short getLocalAirState() {
        return localAirState;
    }

    public static short getLocalTemperature() {
        return localTemperature;
    }
}
