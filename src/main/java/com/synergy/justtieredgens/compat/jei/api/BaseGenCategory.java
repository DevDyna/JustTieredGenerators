package com.synergy.justtieredgens.compat.jei.api;

import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import static com.synergy.justtieredgens.Main.MODULE_ID;


import com.direwolf20.justdirethings.util.MagicHelpers;
import com.synergy.justtieredgens.api.BaseCategory;
import com.synergy.justtieredgens.api.ImageJei;
import com.synergy.justtieredgens.api.Pos;
import com.synergy.justtieredgens.api.Size;
import com.synergy.justtieredgens.api.x;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public abstract class BaseGenCategory<T> extends BaseCategory<T> {

    public BaseGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public ItemLike getIconItem() {
        return getGenerator();
    }

    public abstract ItemLike getGenerator();

    @Override
    public Size setXY() {
        return Size.of(96, 32);
    }

    @Override
    public String getTraslationKey() {
        return MODULE_ID + ".jei.category." + getType();
    }

    public abstract String getType();

    @Override
    public ResourceLocation setBackGround() {
        return x.rl(MODULE_ID, "textures/gui/labels.png");
    }

    @Override
    public void background(GuiGraphics graphics) {
        super.background(graphics);

        ImageJei.of().rl(x.rl(MODULE_ID, "textures/gui/sprites/" + (isFluid() ? "bucket" : "time") + ".png"))
                .size(10, 10)
                .offset(21, 0)
                .render(helper, graphics);

        ImageJei.of().rl(x.rl(MODULE_ID, "textures/gui/sprites/rate.png"))
                .size(10, 10)
                .offset(21, 11)
                .render(helper, graphics);

                //TODO sprite rework
        ImageJei.of().rl(x.rl(MODULE_ID, "textures/gui/sprites/" + (isFluid() ? "chest" : "chest") + ".png"))
                .size(10, 10)
                .offset(21, 22)
                .render(helper, graphics);

    }

    public boolean isFluid() {
        return false;
    }

    public int getTime(T recipe) {
        return 1;
    }

    public abstract int getRate(T recipe);

    public int getTotal(T recipe) {
        return getTime(recipe) * getRate(recipe) * (isFluid() ? 1000 : 1);
    }

    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        informations(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
    }

    public void informations(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {

        var stack = guiGraphics.pose();
        stack.pushPose();
        stack.scale(0.75F, 0.75F,1f);

        guiGraphics.drawString(font,
                isFluid() ? "1 mb every tick"
                        : (Screen.hasShiftDown()
                                ? MagicHelpers.ticksInSeconds(getTime(recipe))
                                        + " sec"
                                : getTime(recipe) + " tick" + (getTime(recipe) > 1 ? "s" : "")),
                46, 4,
                0xFFFFFF);

        guiGraphics.drawString(font,
                (Screen.hasShiftDown()
                        ? MagicHelpers.withSuffix(getRate(recipe))
                        : getRate(recipe)) + " FE/tick",
                46, 18, 0xFFFFFF);

        guiGraphics.drawString(font,
                (Screen.hasShiftDown()
                        ? MagicHelpers.withSuffix(getTotal(recipe))
                        : getTotal(recipe)) + " FE",
                46,
                32,
                0xFFFFFF);
        stack.popPose();
    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, T recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei." + (isFluid() ? "mb_usage" : "time")));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei." + (isFluid() ? "total_bucket" : "total")));

    }

}