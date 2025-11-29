package mod.noobulus.badastratweaks.network;

import java.util.Objects;

public class AdditionalData {
    private static final int AIR_STATE_BIT_LENGTH = 2;
    private static final int TEMPERATURE_BIT_LENGTH = 16;
    private static final int AIR_STATE_BIT = 0;
    private static final int TEMPERATURE_BIT = 2;
    private short airState;
    private short temperature;

    public AdditionalData(short airState, short temperature) {
        this.airState = airState;
        this.temperature = temperature;
    }

    public short getAirState() {
        return this.airState;
    }

    public void setAirState(short state) {
        this.airState = state;
    }

    public short getTemperature() {
        return this.temperature;
    }

    public void setTemperature(short temperature) {
        this.temperature = temperature;
    }


    public int pack() {
        int packedData = 0;
        packedData |= (this.airState) << AIR_STATE_BIT;
        packedData |= (this.temperature) << TEMPERATURE_BIT;
        return packedData;
    }

    public static AdditionalData unpack(int packedData) {
        short state = (short)(packedData >> AIR_STATE_BIT);
        short temperature = (short)(packedData >> TEMPERATURE_BIT);
        return new AdditionalData(state, temperature);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            AdditionalData that = (AdditionalData) obj;
            return this.airState == that.airState && this.temperature == that.temperature;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.airState, this.temperature});
    }

    public String toString() {
        return "AdditionalData[airState=" + this.airState + ", temperature=" + this.temperature + "]";
    }
}
