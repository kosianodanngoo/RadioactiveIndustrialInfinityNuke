package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.RadioactiveInfinityNukeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = InfinityNukeEntity.class, remap = false)
public class InfinityNukeEntityMixin {
    @Shadow private ProcessExplosion explosionHelper;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
    public void tickInject(CallbackInfo ci){
        if((Object)this instanceof RadioactiveInfinityNukeEntity radioactiveInfinityNuke) radioactiveInfinityNuke.initExplosion(explosionHelper);
    }
}
