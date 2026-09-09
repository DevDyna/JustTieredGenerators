package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;
import com.synergy.justtieredgens.init.types.zTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

public class DataItemTag extends ItemTagsProvider {

        public DataItemTag(PackOutput o, CompletableFuture<HolderLookup.Provider> p,
                        CompletableFuture<TagLookup<Block>> b) {
                super(o, p, MODULE_ID);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zTags.Items.SOLID_GENERATORS)
                                .add(
                                                JDTRegistration.GeneratorT1.get().asItem(),
                                                zBlocks.BLAZEGOLD_COAL.get().asItem(),
                                                zBlocks.CELESTIGEM_COAL.get().asItem(),
                                                zBlocks.ECLIPSE_ALLOY_COAL.get().asItem());

                tag(zTags.Items.FLUID_GENERATORS)
                                .add(
                                                JDTRegistration.GeneratorFluidT1.get().asItem(),
                                                zBlocks.BLAZEGOLD_FLUID.get().asItem(),
                                                zBlocks.CELESTIGEM_FLUID.get().asItem(),
                                                zBlocks.ECLIPSE_ALLOY_FLUID.get().asItem());

                tag(zTags.Items.POCKET_GENERATORS)
                                .add(
                                                JDTRegistration.Pocket_Generator.get(),
                                                zItems.BLAZEGOLD_POCKET_GEN.get(),
                                                zItems.CELESTIGEM_POCKET_GEN.get(),
                                                zItems.ECLIPSE_ALLOY_POCKET_GEN.get());

        }

}