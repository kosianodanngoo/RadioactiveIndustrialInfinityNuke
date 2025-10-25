package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.client;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import com.buuz135.industrial.entity.client.InfinityNukeRenderer;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RadioactiveInfinityNukeRenderer extends InfinityNukeRenderer {
    public static ResourceLocation RADIOACTIVE_NUKE = new ResourceLocation(RadioactiveIndustrialInfinityNuke.MODID, "textures/entity/radioactive_infinity_nuke_entity.png");

    public RadioactiveInfinityNukeRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public ResourceLocation getTextureLocation(InfinityNukeEntity entity) {
        return RADIOACTIVE_NUKE;
    }
}
