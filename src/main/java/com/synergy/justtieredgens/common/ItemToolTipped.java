package com.synergy.justtieredgens.common;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.common.blocks.GeneratorT1;
import com.synergy.justtieredgens.init.builders.generators.blazegold.BlazeGoldCoalGenBlock;
import com.synergy.justtieredgens.init.builders.generators.celestigem.CelestigemCoalGenBlock;
import com.synergy.justtieredgens.init.builders.generators.eclipse_alloy.EclipseAlloyCoalGenBlock;

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

                if (block instanceof GeneratorT1)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.ferricore"));

                if (block instanceof BlazeGoldCoalGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.blazegold"));

                if (block instanceof CelestigemCoalGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.celestigem"));

                if (block instanceof EclipseAlloyCoalGenBlock)
                        tip.add(OVER_THE_REGISTRY_ID, Component.translatable(MODULE_ID + ".multiplier.eclipsealloy"));

        }
}