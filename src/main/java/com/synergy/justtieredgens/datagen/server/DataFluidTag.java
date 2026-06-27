package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;

public class DataFluidTag extends FluidTagsProvider {

        public DataFluidTag(PackOutput o, CompletableFuture<Provider> l) {
                super(o, l, MODULE_ID);
        }

        @Override
        protected void addTags(Provider p) {

        }

}