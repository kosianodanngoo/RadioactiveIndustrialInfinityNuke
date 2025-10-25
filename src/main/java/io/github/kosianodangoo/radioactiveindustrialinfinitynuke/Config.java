package io.github.kosianodangoo.radioactiveindustrialinfinitynuke;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = RadioactiveIndustrialInfinityNuke.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.DoubleValue SIEVERT_MULTIPLIER = BUILDER.comment("Sievert Multiplier When Radioactive Infinity Nuke has exploded").defineInRange("sievertMultiplier", 64D, 0D, Double.POSITIVE_INFINITY);

    static final ForgeConfigSpec SPEC = BUILDER.build();
}
