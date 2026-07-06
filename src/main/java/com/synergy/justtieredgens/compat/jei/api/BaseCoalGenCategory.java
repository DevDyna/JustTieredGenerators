package com.synergy.justtieredgens.compat.jei.api;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.devdyna.cakesticklib.api.compat.jei.BaseCategory;
import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.cakesticklib.api.utils.x;

import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public abstract class BaseCoalGenCategory extends BaseCategory<FuelRecords.Items> {

    public BaseCoalGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Items recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 8)
                .addItemStacks(recipe.getFuels());
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
        return MODULE_ID + ".jei.category." + x.name(getGenerator());
    }

    @Override
    public Identifier setBackGround() {
        return x.rl(MODULE_ID, "textures/gui/fuel_icons.png");
    }

    // public abstract int getMultiplier();

    @Override
    public void draw(FuelRecords.Items recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        int multiplier = 1;

        if (recipe.getFuels().getFirst().getItem() instanceof Coal_T1 c)
            multiplier = c.getBurnSpeedMultiplier();
        else if (recipe.getFuels().getFirst().getItem() instanceof BlockItem bi
                && bi.getBlock() instanceof CoalBlock_T1 c)
            multiplier = c.getBurnSpeedMultiplier();

        var rate = getFePerFuelTick() * getBurnSpeed() * multiplier;

        var total = recipe.getBurnTime() * getFePerFuelTick();

        var maxburn = total / rate;

        var stack = guiGraphics.pose();
        stack.pushMatrix();
        stack.scale(0.75F, 0.75F);
        guiGraphics.text(Minecraft.getInstance().font,
                hasShiftDown()
                        ? MagicHelpers.ticksInSeconds(maxburn).replaceAll("\\.0$", "")
                                + " sec"
                        : maxburn + " ticks",
                46, 4,
                0xFFFFFFFF);
        guiGraphics.text(Minecraft.getInstance().font,
                (hasShiftDown() ? MagicHelpers.withSuffix(rate) : rate) + " FE/tick", 46, 18, 0xFFFFFFFF);
        guiGraphics.text(Minecraft.getInstance().font,
                (hasShiftDown() ? MagicHelpers.withSuffix(total) : total) + " FE", 46,
                32,
                0xFFFFFFFF);
        stack.popMatrix();

    }

    public abstract int getFePerFuelTick();

    public abstract int getBurnSpeed();

    @Override
    public void getTooltip(ITooltipBuilder tooltip, FuelRecords.Items recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.total"));

    }

}