package com.synergy.justtieredgens.common;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.common.blocks.GeneratorFluidT1;
import com.direwolf20.justdirethings.common.blocks.GeneratorT1;
import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBlock;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBlock;
import com.synergy.justtieredgens.init.builders.coal.blazegold.BlazeGoldCoalGenBlock;
import com.synergy.justtieredgens.init.builders.coal.celestigem.CelestigemCoalGenBlock;
import com.synergy.justtieredgens.init.builders.coal.eclipse_alloy.EclipseAlloyCoalGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.blazegold.BlazeGoldFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.celestigem.CelestigemFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.eclipse_alloy.EclipseAlloyFluidGenBlock;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class ItemToolTipped {
        private static final int OVER_THE_REGISTRY_ID = 1;

        @SubscribeEvent
        public static void main(ItemTooltipEvent event) {

                var item = event.getItemStack();
                var stack = item.getItem();
                var tip = event.getToolTip();
                // var isBlock = stack instanceof BlockItem;
                var block = ((stack instanceof BlockItem bi) ? bi.getBlock() : null);

                if ((block instanceof GeneratorT1 && !(block instanceof BaseCoalGenBlock))
                                || block instanceof GeneratorFluidT1 && !(block instanceof BaseFluidGenBlock))
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.ferricore"));

                if (block instanceof BlazeGoldCoalGenBlock || block instanceof BlazeGoldFluidGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.blazegold"));

                if (block instanceof CelestigemCoalGenBlock || block instanceof CelestigemFluidGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.celestigem"));

                if (block instanceof EclipseAlloyCoalGenBlock || block instanceof EclipseAlloyFluidGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.eclipsealloy"));

        }
}