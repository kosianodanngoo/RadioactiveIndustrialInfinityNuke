package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin;

import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.api.mixin.IProcessRadioactiveExplosion;
import mekanism.api.Coord4D;
import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ProcessExplosion.class, remap = false)
public class ProcessExplosionMixin implements IProcessRadioactiveExplosion {
    @Shadow @Final public Vector3f origin;
    @Shadow @Final private ServerLevel world;
    @Unique public double radioactive_industrial_infinity_nuke$radiation = 0.0D;

    @Inject(method = "detonate", at = @At("RETURN"))
    public void detonateInject(CallbackInfoReturnable<Boolean> cir) {
        if (radioactive_industrial_infinity_nuke$radiation == 0.0D) {
            return;
        }
        try {
            Coord4D raditePos = new Coord4D(new BlockPos((int) origin.x(), (int) origin.y(), (int) origin.z()), world);
            RadiationManager.INSTANCE.radiate(raditePos, radioactive_industrial_infinity_nuke$radiation);
        } catch (Exception e) {
            RadioactiveIndustrialInfinityNuke.LOGGER.error("Error occurred while radiating:", e);
        }
    }

    @Override
    public double radioactive_industrial_infinity_nuke$getRadiation() {
        return radioactive_industrial_infinity_nuke$radiation;
    }

    @Override
    public void radioactive_industrial_infinity_nuke$setRadiation(double radiation) {
        radioactive_industrial_infinity_nuke$radiation = radiation;
    }
}
