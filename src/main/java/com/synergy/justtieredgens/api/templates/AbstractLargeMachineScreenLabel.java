package com.synergy.justtieredgens.api.templates;

import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractLargeMachineScreenLabel<T extends BaseMachineContainer> extends BaseMachineScreen<T> {

    public AbstractLargeMachineScreenLabel(T arg0, Inventory arg1, Component arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setTopSection() {
        extraWidth = 0;
        extraHeight = 0;
    }

    @Override
    public void addTickSpeedButton() {
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        super.extractBackground(graphics, mouseX, mouseY, partialTicks);

        extractMachineTitle(graphics, mouseX, mouseY, partialTicks);

        extractGeneratorSprites(graphics, mouseX, mouseY, partialTicks);
    }

    public void extractGeneratorSprites(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
    }

    /**
     * TODO PR : JDT#516
     * <br/>
     * <br/>
     * https://github.com/Direwolf20-MC/JustDireThings/pull/516
     * <br/>
     * <br/>
     * <strong>Brute force override</strong> of the title sprite
     * <br/>
     * <br/>
     * It will render another title sprite over the default
     */
    public void extractMachineTitle(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SOCIALBACKGROUND,
                topSectionLeft + 20 - 10, topSectionTop - 20,
                topSectionWidth - 40 + 20, 20);

    }

    @Override
    public void addRedstoneButtons() {
        addRenderableWidget(
                ToggleButtonFactory.REDSTONEBUTTON(leftPos + 104, topSectionTop + 38, redstoneMode.ordinal(), b -> {
                    redstoneMode = MiscHelpers.RedstoneMode.values()[((ToggleButton) b).getTexturePosition()];
                    saveSettings();
                }));
    }

}
