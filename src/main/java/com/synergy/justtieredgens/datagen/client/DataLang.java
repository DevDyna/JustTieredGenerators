package com.synergy.justtieredgens.datagen.client;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.List;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataLang extends LanguageProvider {

        public DataLang(PackOutput o) {
                super(o, MODULE_ID, "en_us");
        }

        @Override
        protected void addTranslations() {

                zBlocks.zBlockItem.getEntries().forEach(b -> addBlock(b, named(b, MODULE_ID)));
                zItems.zItem.getEntries().forEach(b -> addItem(b, named(b, MODULE_ID)));

                List.of(zItems.zItem.getEntries(), zBlocks.zBlockItem.getEntries()).forEach(r -> r.forEach(b -> {

                        add(MODULE_ID + ".configuration." + b.getId().getPath(),
                                        named(b, MODULE_ID));
                        add(MODULE_ID + ".configuration." + b.getId().getPath() + "_max_fe",
                                        "Max FE energy storage");

                        add(MODULE_ID + ".configuration." + b.getId().getPath() + "_fe_per_tick",
                                        "FE transfer every tick");

                        add(MODULE_ID + ".configuration." + b.getId().getPath() + "_screen_multiplier",
                                        "Multiplier value on item tooltip");

                }));

                List.of(zBlocks.BLAZEGOLD_COAL, zBlocks.CELESTIGEM_COAL, zBlocks.ECLIPSE_ALLOY_COAL)
                                .forEach(b -> {
                                        add(MODULE_ID + ".configuration." + b.getId().getPath() + "_fe_per_fuel_tick",
                                                        "FE created per burn tick of fuel");

                                        add(MODULE_ID + ".configuration." + b.getId().getPath()
                                                        + "_burn_speed_multiplier",
                                                        "Multiplier to increase generator speed value");
                                });

                List.of(zBlocks.BLAZEGOLD_FLUID, zBlocks.CELESTIGEM_FLUID, zBlocks.ECLIPSE_ALLOY_FLUID)
                                .forEach(b -> {
                                        add(MODULE_ID + ".configuration." + b.getId().getPath() + "_max_mb",
                                                        "Max Fluid storage");

                                        add(MODULE_ID + ".configuration." + b.getId().getPath()
                                                        + "_fuel_multiplier",
                                                        "Multiplier to increase generator efficiency value");
                                });

                // add(MODULE_ID + ".jei.every", "every");

                add(MODULE_ID + ".jei.mb_usage", "MB usage");
                add(MODULE_ID + ".jei.time", "Duration");
                add(MODULE_ID + ".jei.rate", "FE production");
                add(MODULE_ID + ".jei.total", "Total FE produced");
                add(MODULE_ID + ".jei.total_bucket", "Total FE produced every bucket");

                add(MODULE_ID + ".configuration.misc", "Misc");
                add(MODULE_ID + ".configuration.show_only_coals",
                                "Show only JDT fuels as valid fuels on generators jei");

                List.of(
                                Constants.FERRICORE.POCKET,
                                Constants.BLAZEGOLD.POCKET,
                                Constants.CELESTIGEM.POCKET,
                                Constants.ECLIPSE_ALLOY.POCKET,

                                Constants.FERRICORE.COAL,
                                Constants.BLAZEGOLD.COAL,
                                Constants.CELESTIGEM.COAL,
                                Constants.ECLIPSE_ALLOY.COAL,

                                Constants.FERRICORE.FLUID,
                                Constants.BLAZEGOLD.FLUID,
                                Constants.CELESTIGEM.FLUID,
                                Constants.ECLIPSE_ALLOY.FLUID

                ).forEach(s -> {

                        var type = s.contains(Constants.Prefix.POCKET)
                                        ? Constants.Prefix.POCKET
                                        : s.contains(Constants.Suffix.COAL)
                                                        ? Constants.Suffix.COAL
                                                        : Constants.Suffix.FLUID;

                        add(MODULE_ID + ".jei.category." + s,
                                        formatToDisplay((type.equals(Constants.Prefix.POCKET)
                                                        ? s
                                                        : s.replace(type, ""))
                                                        .replace(Constants.Suffix.GENERATOR, "")) +
                                                        (type.equals(Constants.Prefix.POCKET)
                                                                        ? ""
                                                                        : type.equals(Constants.Suffix.COAL)
                                                                                        ? " Solid"
                                                                                        : " Fluid")
                                                        + " Fuels");
                });

                add(MODULE_ID + ".multiplier.ferricore", "§7" + "Base fuel multiplier : §f1x");
                add(MODULE_ID + ".multiplier.blazegold", "§7" + "Base fuel multiplier : §e2x");
                add(MODULE_ID + ".multiplier.celestigem", "§7" + "Base fuel multiplier : §b3x");
                add(MODULE_ID + ".multiplier.eclipsealloy", "§7" + "Base fuel multiplier : §d4x");

        }

        private String named(DeferredHolder<?, ?> b, String modid) {

        StringBuilder result = new StringBuilder();
        for (String word : b.getRegisteredName()
                .replace(modid + ":", "")
                .replaceAll("_", " ")
                .split(" "))
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
        return result.toString().trim();
    }

        private String formatToDisplay(String input) {
        StringBuilder sb = new StringBuilder();

        for (String word : input.split("_")) {
            if (word.isEmpty()) {
                continue;
            }

            if (!sb.isEmpty()) {
                sb.append(' ');
            }

            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }

        return sb.toString();
    }

}