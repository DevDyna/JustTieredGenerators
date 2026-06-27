package com.synergy.justtieredgens.datagen.client;

import static com.devdyna.cakesticklib.api.datagen.LangUtils.*;
import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.devdyna.cakesticklib.api.datagen.LangUtils;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

@SuppressWarnings("unused")
public class DataLang extends LanguageProvider {

        public DataLang(PackOutput o) {
                super(o, MODULE_ID, "en_us");
        }

        @Override
        protected void addTranslations() {

                zBlocks.zBlockItem.getEntries().forEach(b -> addBlock(b, LangUtils.named(b, MODULE_ID)));

                zBlocks.zBlockItem.getEntries().forEach(b -> {

                        add("justtieredgens.configuration." + b.getId().getPath(), LangUtils.named(b, MODULE_ID));

                        add("justtieredgens.configuration." + b.getId().getPath() + "_max_fe", "Max FE energy storage");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_fe_per_tick",
                                        "FE transfer every tick");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_fe_per_fuel_tick",
                                        "FE created per burn tick of fuel");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_burn_speed_multiplier",
                                        "Multiplier to increase generator speed value");

                });

        }

}
