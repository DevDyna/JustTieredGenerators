package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.cakesticklib.api.datagen.RecipeGenerators;
import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

public class DataRecipe extends RecipeProvider implements RecipeGenerators {

        protected DataRecipe(Provider registries, RecipeOutput output) {
                super(registries, output);
        }

        @Override
        protected void buildRecipes() {


                createSeriesGenerators(JDTRegistration.GeneratorT1.get(),
                                zBlocks.BLAZEGOLD_COAL.get(), JDTRegistration.Coal_T1.get(),
                                zBlocks.CELESTIGEM_COAL.get(), JDTRegistration.Coal_T2.get(),
                                zBlocks.ECLIPSE_ALLOY_COAL.get(), JDTRegistration.Coal_T3.get());

                createSeriesGenerators(JDTRegistration.GeneratorFluidT1.get(),
                                zBlocks.BLAZEGOLD_FLUID.get(), JDTRegistration.POLYMORPHIC_FLUID_BUCKET.get(),
                                zBlocks.CELESTIGEM_FLUID.get(), JDTRegistration.PORTAL_FLUID_BUCKET.get(),
                                zBlocks.ECLIPSE_ALLOY_FLUID.get(), JDTRegistration.TIME_FLUID_BUCKET.get());

        }

        public static final class RecipeRunner extends RecipeProvider.Runner {
                public RecipeRunner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
                        super(output, lookupProvider);
                }

                @Override
                protected RecipeProvider createRecipeProvider(
                                HolderLookup.Provider lookupProvider,
                                RecipeOutput output) {
                        return new DataRecipe(lookupProvider, output);
                }

                @Override
                public String getName() {
                        return "Just Tiered Generators";
                }
        }

        @Override
        public HolderGetter<Item> getItems() {
                return items;
        }

        @Override
        public String getModName() {
                return MODULE_ID;
        }

        @Override
        public Provider getProvider() {
                return registries;
        }

        private void createSeriesGenerators(ItemLike ferri_gen,
                        ItemLike blaze_gen, ItemLike blaze_item,
                        ItemLike celest_gen, ItemLike celest_item,
                        ItemLike eclipse_gen, ItemLike eclipse_item) {

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, blaze_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.BlazegoldIngot.get())
                                .define('C', blaze_item)
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', ferri_gen)
                                .unlockedBy(getHasName(ferri_gen), has(ferri_gen))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, celest_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.Celestigem.get())
                                .define('C', celest_item)
                                .define('R', Items.ENDER_PEARL)
                                .define('B', blaze_gen)
                                .unlockedBy(getHasName(blaze_gen), has(blaze_gen))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, eclipse_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', eclipse_item)
                                .define('R', Items.ECHO_SHARD)
                                .define('B', celest_gen)
                                .unlockedBy(getHasName(celest_gen), has(celest_gen))
                                .save(output);

        }

}