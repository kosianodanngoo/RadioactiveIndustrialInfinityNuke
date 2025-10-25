package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = InfinityNukeEntity.class, remap = false)
public interface InfinityNukeEntityAccessor {
    @Accessor("placedBy")
    public void setPlacedBy(LivingEntity owner);
}
