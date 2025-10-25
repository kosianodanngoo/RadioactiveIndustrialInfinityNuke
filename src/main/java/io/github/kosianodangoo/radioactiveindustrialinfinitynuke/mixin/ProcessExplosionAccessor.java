package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin;

import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ProcessExplosion.class, remap = false)
public interface ProcessExplosionAccessor {
    @Accessor
    public ServerLevel getWorld();
}
