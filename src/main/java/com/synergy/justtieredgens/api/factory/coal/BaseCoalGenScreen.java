package com.synergy.justtieredgens.api.factory.coal;

import java.util.ArrayList;
import java.util.List;

import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.FuelCanister;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.direwolf20.justdirethings.util.MiscTools;
import com.synergy.justtieredgens.api.templates.AbstractLargeMachineScreenLabel;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

public abstract class BaseCoalGenScreen extends AbstractLargeMachineScreenLabel<BaseCoalGenGUI> {
   protected BaseCoalGenGUI container;
   protected BaseCoalGenBE generatorBE;

   public BaseCoalGenScreen(BaseCoalGenGUI container, Inventory inv, Component name) {
      super(container, inv, name);
      this.container = container;
      if (container.baseMachineBE instanceof BaseCoalGenBE gen)
         this.generatorBE = gen;

   }

   public void extractGeneratorSprites(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {

      graphics.blit(JUSTSLOT, leftPos + 79, topPos + 30, 0.0F, 18.0F, 18, 18, 256, 256);

      if (container.getMaxBurn() > 0) {
         int remaining = (container.getBurnRemaining() * 18) / container.getMaxBurn();
         graphics.blit(JUSTSLOT,
               leftPos + 79, topPos + 30 + 18 - remaining,
               18.0F, 36.0F - remaining, 18,
               remaining + 3, 256, 256);
      }

   }

   @Override
   public void powerBarTooltip(GuiGraphics graphics, int pX, int pY) {
      if (baseMachineBE instanceof PoweredMachineBE powered) {
         if (MiscTools.inBounds(topSectionLeft + 5, topSectionTop + 5, 18, 72, pX,
               pY)) {
            var remain = this.container.getBurnRemaining();
            List<Component> lines = new ArrayList<>();

            lines.add(Component.translatable("justdirethings.screen.energy",
                  (Screen.hasShiftDown()
                        ? MagicHelpers.formatted(this.container.getEnergy())
                        : MagicHelpers.withSuffix(this.container.getEnergy())),
                  (Screen.hasShiftDown()
                        ? MagicHelpers.formatted(powered.getMaxEnergy())
                        : MagicHelpers.withSuffix(powered.getMaxEnergy()))));

            lines.add(Component.translatable("justdirethings.screen.fepertick", (remain > 0
                  ? MagicHelpers.formatted(generatorBE.fePerTick())
                  : MagicHelpers.formatted(0))));

            lines.add(remain <= 0
                  ? Component.translatable("justdirethings.screen.no_fuel")
                  : Component.translatable("justdirethings.screen.burn_time",
                        MagicHelpers.ticksInSeconds(remain)));

            graphics.renderComponentTooltip(font, lines, pX,
                  pY);
         }
      }
   }

   @Override
   protected void renderTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
      if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {

         var stack = this.hoveredSlot.getItem();

         if (baseMachineBE.getLevel() == null
               || stack.getBurnTime(RecipeType.SMELTING) <= 0) {
            super.renderTooltip(graphics, mouseX, mouseY);
            return;
         }

         List<Component> tooltip = new ArrayList<>(this.getTooltipFromContainerItem(stack));

         tooltip.add(Component.translatable("justdirethings.screen.burnspeedmultiplier", getFuelValueFromItem(stack))
               .withStyle(ChatFormatting.RED));

         graphics.renderTooltip(this.font, tooltip, stack.getTooltipImage(), stack, mouseX, mouseY);
      } else
         super.renderTooltip(graphics, mouseX, mouseY);
   }

   public int getFuelValueFromItem(ItemStack i) {

      if (i.getItem() instanceof Coal_T1 coal)
         return getMultiplier() * coal.getBurnSpeedMultiplier();

      if (i.getItem() instanceof BlockItem bi
            && bi.getBlock() instanceof CoalBlock_T1 coalBlock)
         return getMultiplier() * coalBlock.getBurnSpeedMultiplier();

      if (i.getItem() instanceof FuelCanister)
         return getMultiplier() * FuelCanister.getBurnSpeedMultiplier(i);

      return getMultiplier();
   }

}
