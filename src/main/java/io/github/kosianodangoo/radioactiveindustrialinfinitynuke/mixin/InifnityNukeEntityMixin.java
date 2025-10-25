package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import com.buuz135.industrial.utils.explosion.ExplosionTickHandler;
import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.RadioactiveInfinityNukeEntity;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.utils.ProcessRadioactiveExplosion;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;

@Mixin(value = InfinityNukeEntity.class, remap = false)
public abstract class InifnityNukeEntityMixin extends Entity {

    @Shadow public abstract int getRadius();

    @Shadow private ProcessExplosion explosionHelper;

    @Shadow @Nullable private LivingEntity placedBy;

    @Shadow private boolean exploding;

    public InifnityNukeEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Definition(id = "explosionHelper", field = "Lcom/buuz135/industrial/entity/InfinityNukeEntity;explosionHelper:Lcom/buuz135/industrial/utils/explosion/ProcessExplosion;")
    @Expression("this.explosionHelper == null")
    @ModifyExpressionValue(method = "tick", at = @At("MIXINEXTRAS:EXPRESSION"), remap = true)
    public boolean modifyBool(boolean original) {
        if(!exploding || !(level() instanceof ServerLevel)) {
            return original;
        }
        InfinityNukeEntity self = (InfinityNukeEntity) (Object) this;
        if (original && self instanceof RadioactiveInfinityNukeEntity radioactiveInfinityNuke) {
            this.explosionHelper = new ProcessRadioactiveExplosion(this.blockPosition(), this.getRadius(), (ServerLevel) this.level(), 39, placedBy != null ? placedBy.getDisplayName().getString() : "");
            ExplosionTickHandler.processExplosionList.add(explosionHelper);
            return false;
        }
        return original;
    }
}
