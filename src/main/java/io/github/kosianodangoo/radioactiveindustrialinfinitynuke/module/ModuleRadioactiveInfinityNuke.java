package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.module;

import com.buuz135.industrial.module.IModule;
import com.hrznstudio.titanium.capability.CapabilityItemStackHolder;
import com.hrznstudio.titanium.itemstack.ItemStackHarness;
import com.hrznstudio.titanium.itemstack.ItemStackHarnessRegistry;
import com.hrznstudio.titanium.module.DeferredRegistryHelper;
import com.hrznstudio.titanium.network.IButtonHandler;
import com.hrznstudio.titanium.tab.TitaniumTab;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.RadioactiveIndustrialInfinityNuke;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.RadioactiveInfinityNukeEntity;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.item.infinity.item.ItemRadioactiveInfinityNuke;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModuleRadioactiveInfinityNuke implements IModule {
    public static TitaniumTab TAB_RADIOACTIVE_INFINITY_NUKE = new TitaniumTab(new ResourceLocation(RadioactiveIndustrialInfinityNuke.MODID , "radioactive_infinity_nuke"));

    public static RegistryObject<Item> RADIOACTIVE_INFINITY_NUKE;
    public static RegistryObject<EntityType<?>> RADIOACTIVE_INFINITY_NUKE_ENTITY_TYPE;

    @Override
    public void generateFeatures(DeferredRegistryHelper registryHelper) {
        RADIOACTIVE_INFINITY_NUKE = registryHelper.registerGeneric(ForgeRegistries.ITEMS.getRegistryKey(), "radioactive_infinity_nuke", () -> new ItemRadioactiveInfinityNuke(TAB_RADIOACTIVE_INFINITY_NUKE));
        RADIOACTIVE_INFINITY_NUKE_ENTITY_TYPE = registryHelper.registerEntityType("infinity_nuke", () -> EntityType.Builder.<RadioactiveInfinityNukeEntity>of(RadioactiveInfinityNukeEntity::new, MobCategory.MISC).sized(0.5F, 1.5F)
                .setShouldReceiveVelocityUpdates(true)
                .setCustomClientFactory((spawnEntity, world) -> new RadioactiveInfinityNukeEntity((EntityType<? extends RadioactiveInfinityNukeEntity>) RADIOACTIVE_INFINITY_NUKE_ENTITY_TYPE.get(), world)).fireImmune().clientTrackingRange(8).updateInterval(20).build("radioactive_infinity_nuke"));

        ItemStackHarnessRegistry.register(RADIOACTIVE_INFINITY_NUKE, stack -> new ItemStackHarness(stack, null, (IButtonHandler) stack.getItem(), ForgeCapabilities.ENERGY, ForgeCapabilities.FLUID_HANDLER_ITEM, CapabilityItemStackHolder.ITEMSTACK_HOLDER_CAPABILITY));
    }
}
