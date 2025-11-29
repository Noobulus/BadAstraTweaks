package mod.noobulus.badastratweaks.network;

import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.bytecodecs.base.object.ObjectByteCodec;
import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.ClientboundPacketType;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import net.minecraft.resources.ResourceLocation;

public record ClientboundSyncAdditionalDataPacket(AdditionalData localData) implements Packet<ClientboundSyncAdditionalDataPacket> {
    public static final ClientboundPacketType<ClientboundSyncAdditionalDataPacket> TYPE = new Type();

    public PacketType<ClientboundSyncAdditionalDataPacket> type() {
        return TYPE;
    }

    private static class Type extends CodecPacketType<ClientboundSyncAdditionalDataPacket> implements ClientboundPacketType<ClientboundSyncAdditionalDataPacket> {
        public Type() {
            super(ClientboundSyncAdditionalDataPacket.class, ResourceLocation.fromNamespaceAndPath("bad_astra_tweaks", "sync_additional_data"),
                    ObjectByteCodec.create(ByteCodec.INT.map(AdditionalData::unpack, AdditionalData::pack)
                            .fieldOf(ClientboundSyncAdditionalDataPacket::localData), ClientboundSyncAdditionalDataPacket::new));
        }

        public Runnable handle(ClientboundSyncAdditionalDataPacket packet) {
            return () -> ClientData.updateLocalData(packet.localData);
        }
    }
}
