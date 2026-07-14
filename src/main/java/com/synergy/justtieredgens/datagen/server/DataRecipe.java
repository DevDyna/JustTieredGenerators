package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.direwolf20.justdirethings.setup.Registration;
import com.synergy.justtieredgens.api.x;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<Provider> registries) {
                super(output, registries);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.BLAZEGOLD_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.BlazegoldIngot.get())
                                .define('C', Registration.Coal_T1.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Registration.GeneratorT1.get())
                                .unlockedBy(getHasName(Registration.GeneratorT1.get()),
                                                has(Registration.GeneratorT1.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.CELESTIGEM_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.Celestigem.get())
                                .define('C', Registration.Coal_T2.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', zBlocks.BLAZEGOLD_COAL.get())
                                .unlockedBy(getHasName(zBlocks.BLAZEGOLD_COAL.get()), has(zBlocks.BLAZEGOLD_COAL.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.Coal_T3.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', zBlocks.CELESTIGEM_COAL.get())
                                .unlockedBy(getHasName(zBlocks.CELESTIGEM_COAL.get()),
                                                has(zBlocks.CELESTIGEM_COAL.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.BLAZEGOLD_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.BlazegoldIngot.get())
                                .define('C', Registration.Coal_T1.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.BLAZEGOLD_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.CELESTIGEM_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.Celestigem.get())
                                .define('C', Registration.Coal_T2.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.CELESTIGEM_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_COAL.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.Coal_T3.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.ECLIPSE_ALLOY_COAL.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.BLAZEGOLD_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.BlazegoldIngot.get())
                                .define('C', Registration.POLYMORPHIC_FLUID_BUCKET.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Registration.GeneratorFluidT1.get())
                                .unlockedBy(getHasName(Registration.GeneratorFluidT1.get()),
                                                has(Registration.GeneratorFluidT1.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.CELESTIGEM_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.Celestigem.get())
                                .define('C', Registration.PORTAL_FLUID_BUCKET.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', zBlocks.BLAZEGOLD_FLUID.get())
                                .unlockedBy(getHasName(zBlocks.BLAZEGOLD_FLUID.get()),
                                                has(zBlocks.BLAZEGOLD_FLUID.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.TIME_FLUID_BUCKET.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', zBlocks.CELESTIGEM_FLUID.get())
                                .unlockedBy(getHasName(zBlocks.CELESTIGEM_FLUID.get()),
                                                has(zBlocks.CELESTIGEM_FLUID.get()))
                                .save(c);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.BLAZEGOLD_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.BlazegoldIngot.get())
                                .define('C', Registration.POLYMORPHIC_FLUID_BUCKET.get())
                                .define('R', Tags.Items.DUSTS_GLOWSTONE)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.BLAZEGOLD_FLUID.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.CELESTIGEM_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.Celestigem.get())
                                .define('C', Registration.PORTAL_FLUID_BUCKET.get())
                                .define('R', Items.ENDER_PEARL)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.CELESTIGEM_FLUID.get().asItem(), "_alt"));

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, zBlocks.ECLIPSE_ALLOY_FLUID.get())
                                .pattern("FRF")
                                .pattern("CBC")
                                .pattern("FRF")
                                .define('F', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.TIME_FLUID_BUCKET.get())
                                .define('R', Items.ECHO_SHARD)
                                .define('B', Items.BLAST_FURNACE)
                                .unlockedBy(getHasName(Items.BLAST_FURNACE), has(Items.BLAST_FURNACE))
                                .save(c, asRecipeID(zBlocks.ECLIPSE_ALLOY_FLUID.get().asItem(), "_alt"));

        }

        private String asRecipeID(Item i, String suffix) {
                return MODULE_ID + ":" + x.name(i) + suffix;
        }

}