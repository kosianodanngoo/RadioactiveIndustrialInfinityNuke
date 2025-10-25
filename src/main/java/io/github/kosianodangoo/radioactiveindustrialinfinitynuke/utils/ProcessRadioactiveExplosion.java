package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.utils;

import com.buuz135.industrial.IndustrialForegoing;
import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.Config;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin.ProcessExplosionAccessor;
import mekanism.api.Coord4D;
import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class ProcessRadioactiveExplosion extends ProcessExplosion {
    public ProcessRadioactiveExplosion(BlockPos origin, int radius, ServerLevel world, int minimumDelayTime, String owner) {
        super(origin, radius, world, minimumDelayTime, owner);
    }

    @Override
    public boolean detonate() {
        if(!super.detonate()){
            return false;
        }
        try {
            Coord4D raditePos = new Coord4D(new BlockPos((int) origin.x(), (int) origin.y(), (int) origin.z()), ((ProcessExplosionAccessor) this).getWorld());
            RadiationManager.INSTANCE.radiate(raditePos, maxRadius * maxRadius * Config.SIEVERT_MULTIPLIER.get());
        } catch (Exception e) {
            RadioactiveIndustrialInfinityNuke.LOGGER.error("Error occurred while radiating:", e);
            return false;
        }
        return true;
    }
}
