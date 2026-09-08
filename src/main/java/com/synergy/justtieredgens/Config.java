package com.synergy.justtieredgens;

import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.cakesticklib.api.utils.StringUtil;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

@SuppressWarnings("unused")
public class Config {

        public static class SolidGen {

                public static class BlazeGold {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue FE_PER_FUEL_TICK;
                        public static IntValue BURN_SPEED_MULTIPLIER;
                }
                public static class Celestigem {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue FE_PER_FUEL_TICK;
                        public static IntValue BURN_SPEED_MULTIPLIER;
                }
                public static class EclipseAlloy {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue FE_PER_FUEL_TICK;
                        public static IntValue BURN_SPEED_MULTIPLIER;
                }

                
        }

        public static class FluidGen {

                public static class BlazeGold {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue MAX_MB;
                        public static IntValue FUEL_MULTIPLIER;
                }
                public static class Celestigem {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue MAX_MB;
                        public static IntValue FUEL_MULTIPLIER;
                }
                public static class EclipseAlloy {
                        public static IntValue MAX_FE;
                        public static IntValue FE_PER_TICK;
                        public static IntValue MAX_MB;
                        public static IntValue FUEL_MULTIPLIER;
                }
                


        }

        public static class PocketGen {
               
        }

        public static BooleanValue ENABLE_ALL_JEI_FUELS;

        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        public static void register(ModContainer c) {

                solidGen();
                fluidGen();
                pocketGen();
                misc();

                c.registerConfig(ModConfig.Type.SERVER, BUILDER.build());
        }

        private static void solidGen() {
                BUILDER.comment("BlazeGold Coal Generator").push(Constants.BLAZEGOLD.COAL);

                SolidGen.BlazeGold.MAX_FE = number("Max FE energy storage",
                                Constants.BLAZEGOLD.COAL + "_max_fe", 1_000_000 * 8);

                SolidGen.BlazeGold.FE_PER_TICK = number("FE transfer every tick",
                                Constants.BLAZEGOLD.COAL + "_fe_per_tick", 1000 * 2);

                SolidGen.BlazeGold.FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.BLAZEGOLD.COAL + "_fe_per_fuel_tick", 15 * 2);

                SolidGen.BlazeGold.BURN_SPEED_MULTIPLIER = number("Multiplier to increase generator speed value",
                                Constants.BLAZEGOLD.COAL + "_burn_speed_multiplier", 4 * 2);

                BUILDER.pop();

                BUILDER.comment("Celestigem Coal Generator").push(Constants.CELESTIGEM.COAL);

                SolidGen.Celestigem.MAX_FE = number("Max FE energy storage",
                                Constants.CELESTIGEM.COAL + "_max_fe", 1_000_000 * 32);

                SolidGen.Celestigem.FE_PER_TICK = number("FE transfer every tick",
                                Constants.CELESTIGEM.COAL + "_fe_per_tick", 1000 * 3);

                SolidGen.Celestigem.FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.CELESTIGEM.COAL + "_fe_per_fuel_tick", 15 * 3);

                SolidGen.Celestigem.BURN_SPEED_MULTIPLIER = number("Multiplier to increase generator speed value",
                                Constants.CELESTIGEM.COAL + "_burn_speed_multiplier", 4 * 3);

                BUILDER.pop();

                BUILDER.comment("Eclipse Alloy Coal Generator").push(Constants.ECLIPSE_ALLOY.COAL);

                SolidGen.EclipseAlloy.MAX_FE = number("Max FE energy storage",
                                Constants.ECLIPSE_ALLOY.COAL + "_max_fe", 1_000_000 * 128);

                SolidGen.EclipseAlloy.FE_PER_TICK = number("FE transfer every tick",
                                Constants.ECLIPSE_ALLOY.COAL + "_fe_per_tick", 1000 * 4);

                SolidGen.EclipseAlloy.FE_PER_FUEL_TICK = number("FE created per burn tick of fuel",
                                Constants.ECLIPSE_ALLOY.COAL + "_fe_per_fuel_tick", 15 * 4);

                SolidGen.EclipseAlloy.BURN_SPEED_MULTIPLIER = number(
                                "Multiplier to increase generator speed value",
                                Constants.ECLIPSE_ALLOY.COAL + "_burn_speed_multiplier", 4 * 4);

                BUILDER.pop();
        }

        private static void fluidGen() {
                BUILDER.comment("BlazeGold Fluid Generator").push(Constants.BLAZEGOLD.FLUID);

                FluidGen.BlazeGold.MAX_FE = number("Max FE energy storage",
                                Constants.BLAZEGOLD.FLUID + "_max_fe", 1_000_000 * 8);

                FluidGen.BlazeGold.MAX_MB = number("Max Fluid storage",
                                Constants.BLAZEGOLD.FLUID + "_max_mb", 4_000 * 4);

                FluidGen.BlazeGold.FE_PER_TICK = number("FE transfer every tick",
                                Constants.BLAZEGOLD.FLUID + "_fe_per_tick", 1000 * 2);

                FluidGen.BlazeGold.FUEL_MULTIPLIER = number("Multiplier to increase generator efficiency value",
                                Constants.BLAZEGOLD.FLUID + "_fuel_multiplier", 2);

                BUILDER.pop();

                BUILDER.comment("Celestigem Fluid Generator").push(Constants.CELESTIGEM.FLUID);

                FluidGen.Celestigem.MAX_FE = number("Max FE energy storage",
                                Constants.CELESTIGEM.FLUID + "_max_fe", 1_000_000 * 32);

                FluidGen.Celestigem.MAX_MB = number("Max Fluid storage",
                                Constants.CELESTIGEM.FLUID + "_max_mb", 4_000 * 16);

                FluidGen.Celestigem.FE_PER_TICK = number("FE transfer every tick",
                                Constants.CELESTIGEM.FLUID + "_fe_per_tick", 1000 * 3);

                FluidGen.Celestigem.FUEL_MULTIPLIER = number("Multiplier to increase generator efficiency value",
                                Constants.CELESTIGEM.FLUID + "_fuel_multiplier", 3);

                BUILDER.pop();

                BUILDER.comment("Eclipse Alloy Fluid Generator").push(Constants.ECLIPSE_ALLOY.FLUID);

                FluidGen.EclipseAlloy.MAX_FE = number("Max FE energy storage",
                                Constants.ECLIPSE_ALLOY.FLUID + "_max_fe", 1_000_000 * 128);

                FluidGen.EclipseAlloy.MAX_MB = number("Max Fluid storage",
                                Constants.ECLIPSE_ALLOY.FLUID + "_max_mb", 4_000 * 64);

                FluidGen.EclipseAlloy.FE_PER_TICK = number("FE transfer every tick",
                                Constants.ECLIPSE_ALLOY.FLUID + "_fe_per_tick", 1000 * 4);

                FluidGen.EclipseAlloy.FUEL_MULTIPLIER = number(
                                "Multiplier to increase generator efficiency value",
                                Constants.ECLIPSE_ALLOY.FLUID + "_fuel_multiplier", 4);

                BUILDER.pop();
        }

        private static void pocketGen() {

        }

        private static void misc() {
                BUILDER.comment("Misc").push("misc");

                ENABLE_ALL_JEI_FUELS = bool("Show only JDT fuels as valid fuels on generators jei", "show_only_coals");

                BUILDER.pop();
        }

        private static BooleanValue bool(String c, String k, boolean b) {
                return BUILDER
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
                return BUILDER
                                .comment(c)
                                .defineInRange(k, d, (d < min ? d : min), (d > max ? d : max));
        }

        private static DoubleValue numberFloat(String c, String k, double d, double min, double max) {
                return BUILDER
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
                        BUILDER.comment(StringUtil.nameCapitalized(s));
                }

                protected static void simple(String s) {
                        BUILDER.comment(s);
                }
        }

}
