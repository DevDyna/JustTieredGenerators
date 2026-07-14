package com.synergy.justtieredgens.datagen;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.synergy.justtieredgens.datagen.server.*;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.*;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MODULE_ID)
public class Controller {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
        CompletableFuture<HolderLookup.Provider> provider = e.getLookupProvider();
        var output = gen.getPackOutput();
        ExistingFileHelper f = e.getExistingFileHelper();

        // e.createDatapackRegistryObjects(new RegistrySetBuilder(),
        // Set.of("minecraft", MODULE_ID, CakeStickLib.MODULE_ID));

        // client

        // providerGen(e, g, new DataBlockModelState(po, f));
        // e.addProvider(new DataModel(output));
        // e.addProvider(new DataLang(output));

        // server

        // e.addProvider(new DataFluidTag(output, provider));

        e.createBlockAndItemTags((a, b) -> new DataBlockTag(a, b, f), (a, b, c) -> new DataItemTag(a, b, c, f));

        e.addProvider(new LootTableProvider(output, Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(DataLootBlock::new, LootContextParamSets.BLOCK)),
                provider));

        e.addProvider(new DataRecipe(output, provider));

    }

}