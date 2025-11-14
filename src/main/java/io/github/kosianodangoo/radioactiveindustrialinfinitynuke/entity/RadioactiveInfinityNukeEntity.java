package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import com.buuz135.industrial.utils.explosion.ProcessExplosion;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.Config;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.item.infinity.item.ItemRadioactiveInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.api.mixin.IProcessRadioactiveExplosion;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.mixin.InfinityNukeEntityAccessor;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.module.ModuleRadioactiveInfinityNuke;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RadioactiveInfinityNukeEntity extends InfinityNukeEntity {
    public RadioactiveInfinityNukeEntity(EntityType<? extends InfinityNukeEntity> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.setOriginal(new ItemStack(ModuleRadioactiveInfinityNuke.RADIOACTIVE_INFINITY_NUKE.get()));
    }

    public RadioactiveInfinityNukeEntity(Level worldIn, LivingEntity owner, ItemStack original) {
        this((EntityType<? extends InfinityNukeEntity>) ModuleRadioactiveInfinityNuke.RADIOACTIVE_INFINITY_NUKE_ENTITY_TYPE.get(), worldIn);
        ((InfinityNukeEntityAccessor) this).setPlacedBy(owner);
        this.setOriginal(original);
        this.setRadius(ItemRadioactiveInfinityNuke.getRadius(original));
    }

    public void initExplosion(ProcessExplosion explosionHelper){
        ((IProcessRadioactiveExplosion)explosionHelper).radioactive_industrial_infinity_nuke$setRadiation(getRadius() * getRadius() * Config.SIEVERT_MULTIPLIER.get());
    }
}
