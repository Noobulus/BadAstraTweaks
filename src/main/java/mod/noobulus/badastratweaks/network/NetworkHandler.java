package mod.noobulus.badastratweaks.network;

import com.teamresourceful.resourcefullib.common.network.NetworkChannel;
import mod.noobulus.badastratweaks.BadAstraTweaks;

public final class NetworkHandler {
    public static final NetworkChannel CHANNEL = new NetworkChannel(BadAstraTweaks.MODID, 1, "main");

    public static void init() {
        CHANNEL.register(ClientboundSyncAdditionalDataPacket.TYPE);
    }
}
