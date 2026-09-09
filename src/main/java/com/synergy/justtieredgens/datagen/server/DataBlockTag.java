package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class DataBlockTag extends BlockTagsProvider {

        public DataBlockTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
                super(output, lookupProvider, MODULE_ID);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zTags.Blocks.SOLID_GENERATORS)
                                .add(
                                                JDTRegistration.GeneratorT1.get(),
                                                zBlocks.BLAZEGOLD_COAL.get(),
                                                zBlocks.CELESTIGEM_COAL.get(),
                                                zBlocks.ECLIPSE_ALLOY_COAL.get());

                tag(zTags.Blocks.FLUID_GENERATORS)
                                .add(
                                                JDTRegistration.GeneratorFluidT1.get(),
                                                zBlocks.BLAZEGOLD_FLUID.get(),
                                                zBlocks.CELESTIGEM_FLUID.get(),
                                                zBlocks.ECLIPSE_ALLOY_FLUID.get());
        }

}