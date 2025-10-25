package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.proxy.client;

import com.buuz135.industrial.entity.InfinityNukeEntity;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.RadioactiveInfinityNukeEntity;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.client.RadioactiveInfinityNukeRenderer;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.module.ModuleRadioactiveInfinityNuke;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<? extends RadioactiveInfinityNukeEntity>) ModuleRadioactiveInfinityNuke.RADIOACTIVE_INFINITY_NUKE_ENTITY_TYPE.get(), RadioactiveInfinityNukeRenderer::new);
    }
}
