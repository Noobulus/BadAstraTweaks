package mod.noobulus.badastratweaks.network;

import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public abstract class CodecPacketType<T extends Packet<T>> implements PacketType<T> {
    protected ByteCodec<T> codec;
    protected final Class<T> clazz;
    protected final ResourceLocation id;

    public CodecPacketType(Class<T> clazz, ResourceLocation id, ByteCodec<T> codec) {
        this.codec = codec;
        this.clazz = clazz;
        this.id = id;
    }

    public Class<T> type() {
        return this.clazz;
    }

    public ResourceLocation id() {
        return this.id;
    }

    public void encode(T message, FriendlyByteBuf buffer) {
        this.codec.encode(message, buffer);
    }

    public T decode(FriendlyByteBuf buffer) {
        return (T)(this.codec.decode(buffer));
    }
}
