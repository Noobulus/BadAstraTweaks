package mod.noobulus.badastratweaks.util;

import com.momosoftworks.coldsweat.api.util.Temperature;
import com.momosoftworks.coldsweat.util.world.WorldHelper;
import net.minecraft.server.level.ServerPlayer;

public class ColdSweatHelper {

    public static int getWorldTempForPlayer(ServerPlayer player) {
        return (int)Temperature.convert(WorldHelper.getTemperatureAt(player.level(), player.getOnPos().above()),
                Temperature.Units.MC, Temperature.Units.C, true);
    }
}
