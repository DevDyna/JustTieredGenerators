package com.synergy.justtieredgens.api.templates;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import com.direwolf20.justdirethings.util.MiscHelpers;
import com.synergy.justtieredgens.api.Image;

import net.minecraft.client.gui.GuiGraphics;
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
    protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        super.renderBg(graphics, partialTicks, mouseX, mouseY);
        extractMachineTitle(graphics, mouseX, mouseY, partialTicks);

        Image.of()
                .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                .size(16, 16)
                .offset(getGuiLeft() + 158, getGuiTop() - 22)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    /**
     * <strong>Brute force override</strong> of the title sprite
     * <br/>
     * <br/>
     * It will render another title sprite over the default
     */
    public void extractMachineTitle(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {

        graphics.blitSprite(SOCIALBACKGROUND,
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

    /**
     * client side multiplier
     */
    public abstract int getMultiplier();

}
