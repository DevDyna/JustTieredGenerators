package com.synergy.justtieredgens.datagen.server;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.concurrent.CompletableFuture;

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
    }

}
