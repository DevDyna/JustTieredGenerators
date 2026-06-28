package com.synergy.justtieredgens.datagen.client;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.Optional;
import com.devdyna.cakesticklib.api.utils.x;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataModel extends ModelProvider {

        public DataModel(PackOutput output) {
                super(output, MODULE_ID);
        }

        @Override
        protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

                coalGenModel(blockModels, itemModels, zBlocks.BLAZEGOLD_COAL);
                coalGenModel(blockModels, itemModels, zBlocks.CELESTIGEM_COAL);
                coalGenModel(blockModels, itemModels, zBlocks.ECLIPSE_ALLOY_COAL);

        }

        public void coalGenModel(BlockModelGenerators blockmodels, ItemModelGenerators itemModels,
                        DeferredHolder<Block, Block> b) {

                var type = b.getId().getPath().replace(Constants.Suffix.COAL, "");

                blockmodels.blockStateOutput.accept(MultiVariantGenerator.dispatch(b.get(),
                                BlockModelGenerators.plainVariant(new ModelTemplate(
                                                Optional.of(x.rl(MODULE_ID, "block/template_generator")),
                                                Optional.empty(),
                                                TextureSlot.SIDE,
                                                TextureSlot.TOP,
                                                TextureSlot.BOTTOM)
                                                .create(b.get(), new TextureMapping()

                                                                .put(TextureSlot.SIDE,
                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/" + type + "/side")))

                                                                .put(TextureSlot.TOP,

                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/" + type + "/top")))
                                                                .put(TextureSlot.BOTTOM,
                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/" + type + "/bottom"))),
                                                                blockmodels.modelOutput))));

                itemModels.itemModelOutput.accept(b.get().asItem(),
                                ItemModelUtils.plainModel(x.rl(MODULE_ID,"block/"+b.getId().getPath())));

        }
}