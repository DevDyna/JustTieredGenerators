package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataBlockTag extends BlockTagsProvider {

    public DataBlockTag(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODULE_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider p) {
        zBlocks.zBlockItem.getEntries().forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(b.get()));

    }

}
