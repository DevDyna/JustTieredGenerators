package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.cakesticklib.api.datagen.RecipeGenerators;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

public class DataRecipe extends RecipeProvider implements RecipeGenerators {

        protected DataRecipe(Provider registries, RecipeOutput output) {
                super(registries, output);
        }

        @Override
        protected void buildRecipes() {

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.BLAZEGOLD_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.BlazegoldIngot.get())
                                .define('C', JDTRegistration.Coal_T1.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', JDTRegistration.GeneratorT1.get())
                                .unlockedBy(getHasName(JDTRegistration.GeneratorT1.get()),
                                                has(JDTRegistration.GeneratorT1.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.CELESTIGEM_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.Celestigem.get())
                                .define('C', JDTRegistration.Coal_T2.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', zBlocks.BLAZEGOLD_COAL.get())
                                .unlockedBy(getHasName(zBlocks.BLAZEGOLD_COAL.get()), has(zBlocks.BLAZEGOLD_COAL.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', JDTRegistration.Coal_T3.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', zBlocks.CELESTIGEM_COAL.get())
                                .unlockedBy(getHasName(zBlocks.CELESTIGEM_COAL.get()),
                                                has(zBlocks.CELESTIGEM_COAL.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.BLAZEGOLD_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.BlazegoldIngot.get())
                                .define('C', JDTRegistration.Coal_T1.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.BLAZEGOLD_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.CELESTIGEM_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.Celestigem.get())
                                .define('C', JDTRegistration.Coal_T2.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.CELESTIGEM_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', JDTRegistration.Coal_T3.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.ECLIPSE_ALLOY_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.BLAZEGOLD_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.BlazegoldIngot.get())
                                .define('C', JDTRegistration.POLYMORPHIC_FLUID_BUCKET.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', JDTRegistration.GeneratorFluidT1.get())
                                .unlockedBy(getHasName(JDTRegistration.GeneratorFluidT1.get()),
                                                has(JDTRegistration.GeneratorFluidT1.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.CELESTIGEM_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.Celestigem.get())
                                .define('C', JDTRegistration.PORTAL_FLUID_BUCKET.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', zBlocks.BLAZEGOLD_FLUID.get())
                                .unlockedBy(getHasName(zBlocks.BLAZEGOLD_FLUID.get()),
                                                has(zBlocks.BLAZEGOLD_FLUID.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', JDTRegistration.TIME_FLUID_BUCKET.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', zBlocks.CELESTIGEM_FLUID.get())
                                .unlockedBy(getHasName(zBlocks.CELESTIGEM_FLUID.get()),
                                                has(zBlocks.CELESTIGEM_FLUID.get()))
                                .save(output);

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.BLAZEGOLD_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.BlazegoldIngot.get())
                                .define('C', JDTRegistration.POLYMORPHIC_FLUID_BUCKET.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.BLAZEGOLD_FLUID.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.CELESTIGEM_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.Celestigem.get())
                                .define('C', JDTRegistration.PORTAL_FLUID_BUCKET.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.CELESTIGEM_FLUID.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', JDTRegistration.TIME_FLUID_BUCKET.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(output, asRecipeID(zBlocks.ECLIPSE_ALLOY_FLUID.get().asItem(), "_alt"));

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

}