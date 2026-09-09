package com.synergy.justtieredgens.common;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.common.blocks.GeneratorFluidT1;
import com.direwolf20.justdirethings.common.blocks.GeneratorT1;
import com.direwolf20.justdirethings.common.items.PocketGenerator;
import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBlock;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBlock;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenItem;
import com.synergy.justtieredgens.init.builders.fluid_gen.blazegold.BlazeGoldFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid_gen.celestigem.CelestigemFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid_gen.eclipse_alloy.EclipseAlloyFluidGenBlock;
import com.synergy.justtieredgens.init.builders.pocket_generators.blazegold.BlazeGoldPocketGenItem;
import com.synergy.justtieredgens.init.builders.pocket_generators.celestigem.CelestigemPocketGenItem;
import com.synergy.justtieredgens.init.builders.pocket_generators.eclipse_alloy.EclipseAlloyPocketGenItem;
import com.synergy.justtieredgens.init.builders.solid_gen.blazegold.BlazeGoldCoalGenBlock;
import com.synergy.justtieredgens.init.builders.solid_gen.celestigem.CelestigemCoalGenBlock;
import com.synergy.justtieredgens.init.builders.solid_gen.eclipse_alloy.EclipseAlloyCoalGenBlock;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class ItemToolTipped {
        private static final int OVER_THE_REGISTRY_ID = 1;

//TODO separate tooltips

        @SubscribeEvent
        public static void main(ItemTooltipEvent event) {

                var stack = event.getItemStack();
                var item = stack.getItem();
                var tip = event.getToolTip();
                var block = ((item instanceof BlockItem bi) ? bi.getBlock() : null);

                if ((block instanceof GeneratorT1 && !(block instanceof BaseCoalGenBlock))
                                || (block instanceof GeneratorFluidT1 && !(block instanceof BaseFluidGenBlock))
                                || (item instanceof PocketGenerator && !(item instanceof BasePocketGenItem)))
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.ferricore"));

                if (block instanceof BlazeGoldCoalGenBlock || block instanceof BlazeGoldFluidGenBlock
                                || item instanceof BlazeGoldPocketGenItem)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.blazegold"));

                if (block instanceof CelestigemCoalGenBlock || block instanceof CelestigemFluidGenBlock
                                || item instanceof CelestigemPocketGenItem)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.celestigem"));

                if (block instanceof EclipseAlloyCoalGenBlock || block instanceof EclipseAlloyFluidGenBlock
                                || item instanceof EclipseAlloyPocketGenItem)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.eclipsealloy"));

        }
}