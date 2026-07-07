package com.synergy.justtieredgens;

import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.cakesticklib.api.utils.StringUtil;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

@SuppressWarnings("unused")
public class Config {

        public static IntValue BLAZEGOLD_COAL_MAX_FE;
        public static IntValue BLAZEGOLD_COAL_FE_PER_TICK;
        public static IntValue BLAZEGOLD_COAL_FE_PER_FUEL_TICK;
        public static IntValue BLAZEGOLD_COAL_BURN_SPEED_MULTIPLIER;

        public static IntValue CELESTIGEM_COAL_MAX_FE;
        public static IntValue CELESTIGEM_COAL_FE_PER_TICK;
        public static IntValue CELESTIGEM_COAL_FE_PER_FUEL_TICK;
        public static IntValue CELESTIGEM_COAL_BURN_SPEED_MULTIPLIER;

        public static IntValue ECLIPSE_ALLOY_COAL_MAX_FE;
        public static IntValue ECLIPSE_ALLOY_COAL_FE_PER_TICK;
        public static IntValue ECLIPSE_ALLOY_COAL_FE_PER_FUEL_TICK;
        public static IntValue ECLIPSE_ALLOY_COAL_BURN_SPEED_MULTIPLIER;

        public static IntValue BLAZEGOLD_FLUID_MAX_FE;
        public static IntValue BLAZEGOLD_FLUID_MAX_MB;
        public static IntValue BLAZEGOLD_FLUID_FE_PER_TICK;
        public static IntValue BLAZEGOLD_FLUID_FUEL_MULTIPLIER;

        public static IntValue CELESTIGEM_FLUID_MAX_FE;
        public static IntValue CELESTIGEM_FLUID_MAX_MB;
        public static IntValue CELESTIGEM_FLUID_FE_PER_TICK;
        public static IntValue CELESTIGEM_FLUID_FUEL_MULTIPLIER;

        public static IntValue ECLIPSE_ALLOY_FLUID_MAX_FE;
        public static IntValue ECLIPSE_ALLOY_FLUID_MAX_MB;
        public static IntValue ECLIPSE_ALLOY_FLUID_FE_PER_TICK;
        public static IntValue ECLIPSE_ALLOY_FLUID_FUEL_MULTIPLIER;

        public static BooleanValue ENABLE_ALL_JEI_FUELS;

        private static final ModConfigSpec.Builder qCOMMON = new ModConfigSpec.Builder();

        public static void register(ModContainer c) {

                qCOMMON.comment("BlazeGold Coal Generator").push(Constants.BLAZEGOLD.COAL);

                BLAZEGOLD_COAL_MAX_FE = number("Max FE energy storage",
                                Constants.BLAZEGOLD.COAL + "_max_fe", 1_000_000 * 8);

                BLAZEGOLD_COAL_FE_PER_TICK = number("FE transfer every tick",
                                Constants.BLAZEGOLD.COAL + "_fe_per_tick", 1000 * 2);

                BLAZEGOLD_COAL_FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.BLAZEGOLD.COAL + "_fe_per_fuel_tick", 15 * 2);

                BLAZEGOLD_COAL_BURN_SPEED_MULTIPLIER = number("Multiplier to increase generator speed value",
                                Constants.BLAZEGOLD.COAL + "_burn_speed_multiplier", 4 * 2);

                qCOMMON.pop();

                qCOMMON.comment("Celestigem Coal Generator").push(Constants.CELESTIGEM.COAL);

                CELESTIGEM_COAL_MAX_FE = number("Max FE energy storage",
                                Constants.CELESTIGEM.COAL + "_max_fe", 1_000_000 * 32);

                CELESTIGEM_COAL_FE_PER_TICK = number("FE transfer every tick",
                                Constants.CELESTIGEM.COAL + "_fe_per_tick", 1000 * 3);

                CELESTIGEM_COAL_FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.CELESTIGEM.COAL + "_fe_per_fuel_tick", 15 * 3);

                CELESTIGEM_COAL_BURN_SPEED_MULTIPLIER = number("Multiplier to increase generator speed value",
                                Constants.CELESTIGEM.COAL + "_burn_speed_multiplier", 4 * 3);

                qCOMMON.pop();

                qCOMMON.comment("Eclipse Alloy Coal Generator").push(Constants.ECLIPSE_ALLOY.COAL);

                ECLIPSE_ALLOY_COAL_MAX_FE = number("Max FE energy storage",
                                Constants.ECLIPSE_ALLOY.COAL + "_max_fe", 1_000_000 * 128);

                ECLIPSE_ALLOY_COAL_FE_PER_TICK = number("FE transfer every tick",
                                Constants.ECLIPSE_ALLOY.COAL + "_fe_per_tick", 1000 * 4);

                ECLIPSE_ALLOY_COAL_FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.ECLIPSE_ALLOY.COAL + "_fe_per_fuel_tick", 15 * 4);

                ECLIPSE_ALLOY_COAL_BURN_SPEED_MULTIPLIER = number("Multiplier to increase generator speed value",
                                Constants.ECLIPSE_ALLOY.COAL + "_burn_speed_multiplier", 4 * 4);

                qCOMMON.pop();

                qCOMMON.comment("BlazeGold Fluid Generator").push(Constants.BLAZEGOLD.FLUID);

                BLAZEGOLD_FLUID_MAX_FE = number("Max FE energy storage",
                                Constants.BLAZEGOLD.FLUID + "_max_fe", 1_000_000 * 8);

                BLAZEGOLD_FLUID_MAX_MB = number("Max Fluid storage",
                                Constants.BLAZEGOLD.FLUID + "_max_mb", 4_000 * 4);

                BLAZEGOLD_FLUID_FE_PER_TICK = number("FE transfer every tick",
                                Constants.BLAZEGOLD.FLUID + "_fe_per_tick", 1000 * 2);

                BLAZEGOLD_FLUID_FUEL_MULTIPLIER = number("Multiplier to increase FE generated from the fuel",
                                Constants.BLAZEGOLD.FLUID + "_fuel_multiplier", 2);

                qCOMMON.pop();

                qCOMMON.comment("Celestigem Fluid Generator").push(Constants.CELESTIGEM.FLUID);

                CELESTIGEM_FLUID_MAX_FE = number("Max FE energy storage",
                                Constants.CELESTIGEM.FLUID + "_max_fe", 1_000_000 * 32);

                CELESTIGEM_FLUID_MAX_MB = number("Max Fluid storage",
                                Constants.CELESTIGEM.FLUID + "_max_mb", 4_000 * 16);

                CELESTIGEM_FLUID_FE_PER_TICK = number("FE transfer every tick",
                                Constants.CELESTIGEM.FLUID + "_fe_per_tick", 1000 * 3);

                CELESTIGEM_FLUID_FUEL_MULTIPLIER = number("Multiplier to increase FE generated from the fuel",
                                Constants.CELESTIGEM.FLUID + "_fuel_multiplier", 3);

                qCOMMON.pop();

                qCOMMON.comment("Eclipse Alloy Fluid Generator").push(Constants.ECLIPSE_ALLOY.FLUID);

                ECLIPSE_ALLOY_FLUID_MAX_FE = number("Max FE energy storage",
                                Constants.ECLIPSE_ALLOY.FLUID + "_max_fe", 1_000_000 * 128);

                ECLIPSE_ALLOY_FLUID_MAX_MB = number("Max Fluid storage",
                                Constants.ECLIPSE_ALLOY.FLUID + "_max_mb", 4_000 * 64);

                ECLIPSE_ALLOY_FLUID_FE_PER_TICK = number("FE transfer every tick",
                                Constants.ECLIPSE_ALLOY.FLUID + "_fe_per_tick", 1000 * 4);

                ECLIPSE_ALLOY_FLUID_FUEL_MULTIPLIER = number("Multiplier to increase FE generated from the fuel",
                                Constants.ECLIPSE_ALLOY.FLUID + "_fuel_multiplier", 4);

                qCOMMON.pop();

                qCOMMON.comment("Misc").push("misc");

                ENABLE_ALL_JEI_FUELS = bool("Show only JDT fuels as valid fuels on generators jei", "show_only_coals");

                qCOMMON.pop();

                c.registerConfig(ModConfig.Type.COMMON, qCOMMON.build());
        }

        private static BooleanValue bool(String c, String k, boolean b) {
                return qCOMMON
                                .comment(c)
                                .define(k, b);
        }

        /**
         * default = false
         */
        private static BooleanValue bool(String c, String k) {
                return bool(c, k, false);
        }

        private static IntValue number(String c, String k, int d, int min, int max) {
                return qCOMMON
                                .comment(c)
                                .defineInRange(k, d, (d < min ? d : min), (d > max ? d : max));
        }

        private static DoubleValue numberFloat(String c, String k, double d, double min, double max) {
                return qCOMMON
                                .comment(c)
                                .defineInRange(k, d, (d < min ? d : min), (d > max ? d : max));
        }

        /**
         * min = 0<br/>
         * <br/>
         * max = Double.MAX_VALUE
         */

        private static DoubleValue numberFloat(String c, String k, double d) {
                return numberFloat(c, k, d, 0, Integer.MAX_VALUE);
        }

        /**
         * max = Double.MAX_VALUE
         */
        private static DoubleValue numberFloat(String c, String k, double d, double min) {
                return numberFloat(c, k, d, min, Integer.MAX_VALUE);
        }

        /**
         * min = 1<br/>
         * <br/>
         * max = Integer.MAX_VALUE
         */
        private static IntValue number(String c, String k, int d) {
                return number(c, k, d, 1, Integer.MAX_VALUE);
        }

        /**
         * max = Integer.MAX_VALUE
         */
        private static IntValue number(String c, String k, int d, int min) {
                return number(c, k, d, min, Integer.MAX_VALUE);
        }

        protected class decor {
                protected static void complex(String s) {
                        qCOMMON.comment(StringUtil.nameCapitalized(s));
                }

                protected static void simple(String s) {
                        qCOMMON.comment(s);
                }
        }

}
