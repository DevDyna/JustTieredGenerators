package com.synergy.justtieredgens.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.direwolf20.justdirethings.setup.Registration;
import com.synergy.justtieredgens.api.x;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<Provider> registries) {
                super(output, registries);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                createPocketGenRecipes(
                                Registration.Pocket_Generator.get(), zItems.BLAZEGOLD_POCKET_GEN.get(),
                                zItems.CELESTIGEM_POCKET_GEN.get(), zItems.ECLIPSE_ALLOY_POCKET_GEN.get(), c);

                createSeriesGenerators(Registration.GeneratorT1.get(),
                                zBlocks.BLAZEGOLD_COAL.get(), Registration.Coal_T1.get(),
                                zBlocks.CELESTIGEM_COAL.get(), Registration.Coal_T2.get(),
                                zBlocks.ECLIPSE_ALLOY_COAL.get(), Registration.Coal_T3.get(), c);

                createSeriesGenerators(Registration.GeneratorFluidT1.get(),
                                zBlocks.BLAZEGOLD_FLUID.get(), Registration.POLYMORPHIC_FLUID_BUCKET.get(),
                                zBlocks.CELESTIGEM_FLUID.get(), Registration.PORTAL_FLUID_BUCKET.get(),
                                zBlocks.ECLIPSE_ALLOY_FLUID.get(), Registration.TIME_FLUID_BUCKET.get(), c);

        }

        private void createSeriesGenerators(ItemLike ferri_gen,
                        ItemLike blaze_gen, ItemLike blaze_item,
                        ItemLike celest_gen, ItemLike celest_item,
                        ItemLike eclipse_gen, ItemLike eclipse_item, RecipeOutput c) {

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, blaze_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.BlazegoldIngot.get())
                                .define('C', blaze_item)
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', ferri_gen)
                                .unlockedBy(getHasName(ferri_gen), has(ferri_gen))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, celest_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.Celestigem.get())
                                .define('C', celest_item)
                                .define('R', Items.ENDER_PEARL)
                                .define('B', blaze_gen)
                                .unlockedBy(getHasName(blaze_gen), has(blaze_gen))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, eclipse_gen)
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.EclipseAlloyIngot.get())
                                .define('C', eclipse_item)
                                .define('R', Items.ECHO_SHARD)
                                .define('B', celest_gen)
                                .unlockedBy(getHasName(celest_gen), has(celest_gen))
                                .save(c);

        }

        private void createPocketGenRecipes(
                        ItemLike ferri_gen, ItemLike blaze_gen,
                        ItemLike celest_gen, ItemLike eclipse_gen, RecipeOutput c) {

                SmithingTransformRecipeBuilder.smithing(
                                x.itemIngredient(Registration.TEMPLATE_BLAZEGOLD.get()),
                                x.itemIngredient(ferri_gen),
                                x.itemIngredient(Registration.BlazeGoldBlock.get()),
                                RecipeCategory.MISC, blaze_gen.asItem())
                                .unlocks(getHasName(ferri_gen), has(ferri_gen))
                                .save(c, getConversionRecipeName(blaze_gen, ferri_gen));

                SmithingTransformRecipeBuilder.smithing(
                                x.itemIngredient(Registration.TEMPLATE_CELESTIGEM.get()),
                                x.itemIngredient(blaze_gen),
                                x.itemIngredient(Registration.CelestigemBlock.get()),
                                RecipeCategory.MISC, celest_gen.asItem())
                                .unlocks(getHasName(blaze_gen), has(blaze_gen))
                                .save(c, getConversionRecipeName(celest_gen, blaze_gen));

                SmithingTransformRecipeBuilder.smithing(
                                x.itemIngredient(Registration.TEMPLATE_ECLIPSEALLOY.get()),
                                x.itemIngredient(celest_gen),
                                x.itemIngredient(Registration.EclipseAlloyBlock.get()),
                                RecipeCategory.MISC, eclipse_gen.asItem())
                                .unlocks(getHasName(celest_gen), has(celest_gen))
                                .save(c, getConversionRecipeName(eclipse_gen, celest_gen));

        }

}
