package io.github.kosianodangoo.radioactiveindustrialinfinitynuke.recipe.provider;

import com.hrznstudio.titanium.api.IRecipeProvider;
import com.hrznstudio.titanium.recipe.generator.TitaniumRecipeProvider;
import io.github.kosianodangoo.radioactiveindustrialinfinitynuke.module.ModuleRadioactiveInfinityNuke;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class RadioactiveInfinityNukeRecipeProvider extends TitaniumRecipeProvider {
    public RadioactiveInfinityNukeRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public void register(Consumer<FinishedRecipe> consumer) {
        ((IRecipeProvider) ModuleRadioactiveInfinityNuke.RADIOACTIVE_INFINITY_NUKE.get()).registerRecipe(consumer);
    }
}
