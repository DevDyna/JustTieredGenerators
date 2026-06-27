package com.synergy.justtieredgens.datagen.server;

import java.util.*;

import com.devdyna.cakesticklib.api.utils.LootTableHelper;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class DataLootBlock extends BlockLootSubProvider {

        public DataLootBlock(HolderLookup.Provider l) {
                super(Set.of(), FeatureFlags.DEFAULT_FLAGS, l);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
                return LootTableHelper.getValidBlocks(zBlocks.zBlockItem);
        }

        @Override
        protected void generate() {
                zBlocks.zBlockItem.getEntries().forEach(b->dropSelf(b.get()));
        }

}
