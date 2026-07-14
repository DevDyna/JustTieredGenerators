// package com.synergy.justtieredgens.datagen.client;

// import static com.devdyna.cakesticklib.api.datagen.LangUtils.*;
// import static com.synergy.justtieredgens.Main.MODULE_ID;

// import java.util.List;

// import com.devdyna.cakesticklib.api.datagen.LangUtils;
// import com.devdyna.cakesticklib.api.datagen.LangUtils.TipColors;
// import com.devdyna.cakesticklib.api.utils.StringUtil;
// import com.direwolf20.justdirethings.setup.JDTRegistration;
// import com.synergy.justtieredgens.Constants;
// import com.synergy.justtieredgens.init.types.zBlocks;

// import net.minecraft.data.PackOutput;
// import net.minecraft.world.level.block.Block;
// import net.neoforged.neoforge.common.data.LanguageProvider;
// import net.neoforged.neoforge.registries.DeferredHolder;

// @SuppressWarnings("unused")
// public class DataLang extends LanguageProvider {

//         public DataLang(PackOutput o) {
//                 super(o, MODULE_ID, "en_us");
//         }

//         @Override
//         protected void addTranslations() {

//                 zBlocks.zBlockItem.getEntries().forEach(b -> addBlock(b, LangUtils.named(b, MODULE_ID)));

//                 zBlocks.zBlockItem.getEntries().forEach(b -> {

//                         add(MODULE_ID + ".configuration." + b.getId().getPath(),
//                                         LangUtils.named(b, MODULE_ID));

//                         add(MODULE_ID + ".configuration." + b.getId().getPath() + "_max_fe",
//                                         "Max FE energy storage");

//                         add(MODULE_ID + ".configuration." + b.getId().getPath() + "_fe_per_tick",
//                                         "FE transfer every tick");

//                 });

//                 List.of(zBlocks.BLAZEGOLD_COAL, zBlocks.CELESTIGEM_COAL, zBlocks.ECLIPSE_ALLOY_COAL)
//                                 .forEach(b -> {
//                                         add(MODULE_ID + ".configuration." + b.getId().getPath() + "_fe_per_fuel_tick",
//                                                         "FE created per burn tick of fuel");

//                                         add(MODULE_ID + ".configuration." + b.getId().getPath()
//                                                         + "_burn_speed_multiplier",
//                                                         "Multiplier to increase generator speed value");
//                                 });

//                 List.of(zBlocks.BLAZEGOLD_FLUID, zBlocks.CELESTIGEM_FLUID, zBlocks.ECLIPSE_ALLOY_FLUID)
//                                 .forEach(b -> {
//                                         add(MODULE_ID + ".configuration." + b.getId().getPath() + "_max_mb",
//                                                         "Max Fluid storage");

//                                         add(MODULE_ID + ".configuration." + b.getId().getPath()
//                                                         + "_fuel_multiplier",
//                                                         "Multiplier to increase generator efficiency value");
//                                 });

//                 // add(MODULE_ID + ".jei.every", "every");

//                 add(MODULE_ID + ".jei.mb_usage", "MB usage");
//                 add(MODULE_ID + ".jei.time", "Duration");
//                 add(MODULE_ID + ".jei.rate", "FE production");
//                 add(MODULE_ID + ".jei.total", "Total FE produced");
//                 add(MODULE_ID + ".jei.total_bucket", "Total FE produced every bucket");

//                 add(MODULE_ID + ".configuration.misc", "Misc");
//                 add(MODULE_ID + ".configuration.show_only_coals",
//                                 "Show only JDT fuels as valid fuels on generators jei");

//                 List.of(

//                                 Constants.FERRICORE.COAL,
//                                 Constants.BLAZEGOLD.COAL,
//                                 Constants.CELESTIGEM.COAL,
//                                 Constants.ECLIPSE_ALLOY.COAL,

//                                 Constants.FERRICORE.FLUID,
//                                 Constants.BLAZEGOLD.FLUID,
//                                 Constants.CELESTIGEM.FLUID,
//                                 Constants.ECLIPSE_ALLOY.FLUID)
//                                 .forEach(s ->

//                                 add(MODULE_ID + ".jei.category." + s,
//                                                 StringUtil.formatToDisplay(s.replace(s.contains(Constants.Suffix.COAL)
//                                                                 ? Constants.Suffix.COAL
//                                                                 : Constants.Suffix.FLUID, ""))
//                                                                 +
//                                                                 (s.contains(Constants.Suffix.COAL)
//                                                                                 ? " Solid"
//                                                                                 : " Fluid")
//                                                                 +
//                                                                 " Generator Fuels")

//                                 );

//                 add(MODULE_ID + ".multiplier.ferricore", TipColors.ITEM_TOOLTIP + "Base fuel multiplier : §f1x");
//                 add(MODULE_ID + ".multiplier.blazegold", TipColors.ITEM_TOOLTIP + "Base fuel multiplier : §e2x");
//                 add(MODULE_ID + ".multiplier.celestigem", TipColors.ITEM_TOOLTIP + "Base fuel multiplier : §b3x");
//                 add(MODULE_ID + ".multiplier.eclipsealloy", TipColors.ITEM_TOOLTIP + "Base fuel multiplier : §d4x");

//         }

// }
