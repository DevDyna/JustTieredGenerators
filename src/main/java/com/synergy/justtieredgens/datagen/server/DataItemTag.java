package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.direwolf20.justdirethings.setup.Registration;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;
import com.synergy.justtieredgens.init.types.zTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemTag extends ItemTagsProvider {

    public DataItemTag(PackOutput o, CompletableFuture<HolderLookup.Provider> p,
            CompletableFuture<TagLookup<Block>> b, ExistingFileHelper h) {
        super(o, p, b, MODULE_ID, h);
    }

       @Override
        protected void addTags(Provider p) {

                tag(zTags.Items.SOLID_GENERATORS)
                                .add(
                                                Registration.GeneratorT1.get().asItem(),
                                                zBlocks.BLAZEGOLD_COAL.get().asItem(),
                                                zBlocks.CELESTIGEM_COAL.get().asItem(),
                                                zBlocks.ECLIPSE_ALLOY_COAL.get().asItem());

                tag(zTags.Items.FLUID_GENERATORS)
                                .add(
                                                Registration.GeneratorFluidT1.get().asItem(),
                                                zBlocks.BLAZEGOLD_FLUID.get().asItem(),
                                                zBlocks.CELESTIGEM_FLUID.get().asItem(),
                                                zBlocks.ECLIPSE_ALLOY_FLUID.get().asItem());

                tag(zTags.Items.POCKET_GENERATORS)
                                .add(
                                                Registration.Pocket_Generator.get(),
                                                zItems.BLAZEGOLD_POCKET_GEN.get(),
                                                zItems.CELESTIGEM_POCKET_GEN.get(),
                                                zItems.ECLIPSE_ALLOY_POCKET_GEN.get());

        }

}
