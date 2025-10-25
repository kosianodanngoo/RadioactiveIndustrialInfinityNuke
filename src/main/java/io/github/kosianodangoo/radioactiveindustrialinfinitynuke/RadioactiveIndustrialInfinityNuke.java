package io.github.kosianodangoo.radioactiveindustrialinfinitynuke;

import com.hrznstudio.titanium.module.ModuleController;
import com.mojang.logging.LogUtils;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.module.ModuleRadioactiveInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.recipe.provider.RadioactiveInfinityNukeRecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RadioactiveIndustrialInfinityNuke.MODID)
public class RadioactiveIndustrialInfinityNuke extends ModuleController {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "radioactive_industrial_infinity_nuke";

    public static final Logger LOGGER = LogUtils.getLogger();

    public RadioactiveIndustrialInfinityNuke() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @Override
    public void addDataProvider(GatherDataEvent event) {
        super.addDataProvider(event);
        event.getGenerator().addProvider(true, new RadioactiveInfinityNukeRecipeProvider(event.getGenerator()));
    }

    @Override
    protected void initModules() {
        new ModuleRadioactiveInfinityNuke().generateFeatures(getRegistries());
        this.addCreativeTab("radioactive_infinity_nuke", () ->  new ItemStack(ModuleRadioactiveInfinityNuke.RADIOACTIVE_INFINITY_NUKE.get()), RadioactiveIndustrialInfinityNuke.MODID, ModuleRadioactiveInfinityNuke.TAB_RADIOACTIVE_INFINITY_NUKE);
    }
}
