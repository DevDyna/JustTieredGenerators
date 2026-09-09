package com.synergy.justtieredgens.datagen.client;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.Optional;
import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.client.itemcustomrenders.ToolEnabledProperty;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
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

                fluidGenModel(blockModels, itemModels, zBlocks.BLAZEGOLD_FLUID);
                fluidGenModel(blockModels, itemModels, zBlocks.CELESTIGEM_FLUID);
                fluidGenModel(blockModels, itemModels, zBlocks.ECLIPSE_ALLOY_FLUID);

                pocketGenModel(itemModels, zItems.BLAZEGOLD_POCKET_GEN.get());
                pocketGenModel(itemModels, zItems.CELESTIGEM_POCKET_GEN.get());
                pocketGenModel(itemModels, zItems.ECLIPSE_ALLOY_POCKET_GEN.get());

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
                                                                                                "block/coal/" + type
                                                                                                                + "/side")))

                                                                .put(TextureSlot.TOP,

                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/coal/" + type
                                                                                                                + "/top")))
                                                                .put(TextureSlot.BOTTOM,
                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/coal/" + type
                                                                                                                + "/bottom"))),
                                                                blockmodels.modelOutput))));

                itemModels.itemModelOutput.accept(b.get().asItem(),
                                ItemModelUtils.plainModel(x.rl(MODULE_ID, "block/" + b.getId().getPath())));

        }

        public void fluidGenModel(BlockModelGenerators blockmodels, ItemModelGenerators itemModels,
                        DeferredHolder<Block, Block> b) {

                var type = b.getId().getPath().replace(Constants.Suffix.FLUID, "");

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
                                                                                                "block/fluid/" + type
                                                                                                                + "/side")))

                                                                .put(TextureSlot.TOP,

                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/fluid/" + type
                                                                                                                + "/top")))
                                                                .put(TextureSlot.BOTTOM,
                                                                                new Material(x.rl(
                                                                                                MODULE_ID,
                                                                                                "block/fluid/" + type
                                                                                                                + "/bottom"))),
                                                                blockmodels.modelOutput))));

                itemModels.itemModelOutput.accept(b.get().asItem(),
                                ItemModelUtils.plainModel(x.rl(MODULE_ID, "block/" + b.getId().getPath())));

        }

        private static void pocketGenModel(ItemModelGenerators itemmodels, Item item) {

                var name = x.name(item).replace(Constants.Prefix.POCKET, "").replace(Constants.Suffix.GENERATOR, "");

                var pocket = x.name(JDTRegistration.Pocket_Generator.get()) + "_t"
                                + switch (name) {
                                        case Constants.MaterialType.BLAZEGOLD -> "2";
                                        case Constants.MaterialType.CELESTIGEM -> "3";
                                        case Constants.MaterialType.ECLIPSE_ALLOY -> "4";
                                        default -> "";
                                };


                itemmodels.itemModelOutput.accept(item,
                                ItemModelUtils.conditional(new ToolEnabledProperty(),
                                                ItemModelUtils.plainModel(ModelTemplates.FLAT_HANDHELD_ITEM.create(
                                                                x.rl(MODULE_ID,"item/" + pocket + "_active"),
                                                                TextureMapping.layer0(x.material(JustDireThings.MODID, "item/" + pocket + "_active")),
                                                                itemmodels.modelOutput)),
                                                ItemModelUtils.plainModel(ModelTemplates.FLAT_HANDHELD_ITEM.create(
                                                                x.rl(MODULE_ID,"item/" + pocket), 
                                                                TextureMapping.layer0(x.material(JustDireThings.MODID, "item/" + pocket)),
                                                                itemmodels.modelOutput))));
        }

}