package com.synergy.justtieredgens.api.factory.fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.direwolf20.justdirethings.util.MiscTools;
import com.synergy.justtieredgens.api.templates.AbstractLargeMachineScreenLabel;

import net.minecraft.client.Minecraft;

public abstract class BaseFluidGenScreen extends AbstractLargeMachineScreenLabel<BaseFluidGenGUI> {
    protected BaseFluidGenGUI container;
    protected BaseFluidGenBE generatorBE;

    public BaseFluidGenScreen(BaseFluidGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
        this.container = container;
        if (container.baseMachineBE instanceof BaseFluidGenBE gen)
            this.generatorBE = gen;
    }

    @Override
    public void powerBarTooltip(GuiGraphicsExtractor graphics, int pX, int pY) {
        if (baseMachineBE instanceof PoweredMachineBE powered) {
            if (MiscTools.inBounds(topSectionLeft + 5, topSectionTop + 5, 18, 72, pX, pY)) {
                List<Component> lines = new ArrayList<>();

                lines.add(Component.translatable("justdirethings.screen.energy",
                        (Minecraft.getInstance().hasShiftDown()
                                ? MagicHelpers.formatted(this.container.getEnergy())
                                : MagicHelpers.withSuffix(this.container.getEnergy())),
                        (Minecraft.getInstance().hasShiftDown()
                                ? MagicHelpers.formatted(powered.getMaxEnergy())
                                : MagicHelpers.withSuffix(powered.getMaxEnergy()))));

                lines.add(Component.translatable("justdirethings.screen.fepertick",
                        MagicHelpers.formatted(generatorBE.getFePerFuelTick())));

                graphics.setTooltipForNextFrame(font, lines, Optional.empty(), pX, pY);

            }
        }
    }

}
