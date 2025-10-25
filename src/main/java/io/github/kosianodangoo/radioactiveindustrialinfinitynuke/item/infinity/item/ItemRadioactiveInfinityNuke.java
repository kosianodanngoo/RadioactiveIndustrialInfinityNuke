package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.item.infinity.item;

import com.buuz135.industrial.IndustrialForegoing;
import com.buuz135.industrial.item.infinity.InfinityTier;
import com.buuz135.industrial.item.infinity.ItemInfinity;
import com.buuz135.industrial.item.infinity.item.ItemInfinityNuke;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.module.ModuleTool;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.hrznstudio.titanium.tab.TitaniumTab;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.entity.RadioactiveInfinityNukeEntity;
import mekanism.common.registries.MekanismItems;
import net.minecraft.core.BlockPos;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ItemRadioactiveInfinityNuke extends ItemInfinity {
    public ItemRadioactiveInfinityNuke(TitaniumTab group) {
        super("radiocatable_infinity_nuke", group, new Properties().stacksTo(1), ItemInfinityNuke.POWER_CONSUMPTION, ItemInfinityNuke.FUEL_CONSUMPTION, true);
    }

    public static int getRadius(ItemStack stack) {
        int tier = getSelectedTier(stack).getRadius() + 1;
        double fluidAmount = 1 + ((ItemInfinityNuke) ModuleTool.INFINITY_NUKE.get()).getFuelFromStack(stack) / 1_000_000D * 0.5;
        return (int) ((1 + Math.ceil((tier * tier * tier) / 2D)) * fluidAmount);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        RadioactiveInfinityNukeEntity entity = new RadioactiveInfinityNukeEntity(context.getLevel(), context.getPlayer(), context.getItemInHand().copy());
        BlockPos blockPos = context.getClickedPos().relative(context.getClickedFace());
        entity.absMoveTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0);
        context.getPlayer().setItemInHand(context.getHand(), ItemStack.EMPTY);
        context.getLevel().addFreshEntity(entity);
        IndustrialForegoing.LOGGER.info(context.getPlayer().getUUID() + " (" + context.getPlayer().getDisplayName().toString() + ") placed an Infinity Nuke");
        return InteractionResult.SUCCESS;
    }

    @Override
    public String getFormattedArea(ItemStack stack, InfinityTier tier, int radius, boolean usesDepth) {
        return getRadius(stack) + "r";
    }

    @Override
    public void registerRecipe(Consumer<FinishedRecipe> consumer) {
        new DissolutionChamberRecipe(ForgeRegistries.ITEMS.getKey(this),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(Items.TNT)),
                        new Ingredient.TagValue(ItemTags.create(new ResourceLocation("forge:storage_blocks/uranium"))),
                        new Ingredient.TagValue(ItemTags.create(new ResourceLocation("forge:storage_blocks/uranium"))),
                        new Ingredient.TagValue(ItemTags.create(new ResourceLocation("forge:storage_blocks/uranium"))),
                        new Ingredient.TagValue(ItemTags.create(new ResourceLocation("forge:storage_blocks/uranium"))),
                        new Ingredient.ItemValue(new ItemStack(ModuleTool.INFINITY_NUKE.get())),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHER_STAR)),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHER_STAR)),
                },
                new FluidStack(ModuleCore.ETHER.getSourceFluid().get(), 2000), 400, new ItemStack(this), FluidStack.EMPTY);
    }
}
