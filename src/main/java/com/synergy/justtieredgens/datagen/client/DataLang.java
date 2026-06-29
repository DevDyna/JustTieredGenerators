package com.synergy.justtieredgens.datagen.client;

import static com.devdyna.cakesticklib.api.datagen.LangUtils.*;
import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.List;

import com.devdyna.cakesticklib.api.datagen.LangUtils;
import com.devdyna.cakesticklib.api.utils.StringUtil;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.Constants;
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

                        add("justtieredgens.configuration." + b.getId().getPath() + "_max_fe",
                                        "Max FE energy storage");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_fe_per_tick",
                                        "FE transfer every tick");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_fe_per_fuel_tick",
                                        "FE created per burn tick of fuel");

                        add("justtieredgens.configuration." + b.getId().getPath() + "_burn_speed_multiplier",
                                        "Multiplier to increase generator speed value");

                });

                add(MODULE_ID + ".jei.time", "Duration");
                add(MODULE_ID + ".jei.rate", "FE production");
                add(MODULE_ID + ".jei.total", "Total FE produced");

                List.of(
                                JDTRegistration.GeneratorT1_ITEM.getId().getPath(),
                                Constants.BLAZEGOLD.COAL,
                                Constants.CELESTIGEM.COAL,
                                Constants.ECLIPSE_ALLOY.COAL)
                                .forEach(s -> {

                                        add(MODULE_ID + ".jei.category." + s,
                                                        ((s == JDTRegistration.GeneratorT1_ITEM.getId().getPath()
                                                                        ? "Ferricore"
                                                                        : idToDisplayName(s.replace("_coal_generator",
                                                                                        ""))))
                                                                        + "Solid Generator Fuels");
                                });

        }

        // TODO API : move to api (StringUtils)
        public static String idToDisplayName(String input) {
                var words = input.split("_");
                var sb = new StringBuilder();

                for (int i = 0; i < words.length; i++) {
                        if (!words[i].isEmpty())
                                sb.append(Character.toUpperCase(words[i].charAt(0)))
                                                .append(words[i].substring(1));

                        if (i < words.length - 1)
                                sb.append(" ");
                }

                return sb.toString();
        }

}
