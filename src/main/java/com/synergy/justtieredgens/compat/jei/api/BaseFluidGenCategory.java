package com.synergy.justtieredgens.compat.jei.api;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;

import com.synergy.justtieredgens.api.JEIFluidTankHelper;
import com.synergy.justtieredgens.api.x;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

@SuppressWarnings("null")
public abstract class BaseFluidGenCategory extends BaseGenCategory<FuelRecords.Fluids> {

    public BaseFluidGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Fluids recipe, IFocusGroup focuses) {
        JEIFluidTankHelper.of()
                .fluid(recipe.getFuels().stream().map(f->x.fluid(f.getFluid(),1)).toList())
                .offset(1, 8)
                .build((x, y) -> builder.addInputSlot(x, y));
    }

    public int getGenMultiplier() {
        return 1;
    }

    @Override
    public int getRate(FuelRecords.Fluids recipe) {
        return recipe.getMultiplier() * getGenMultiplier();
    }

    @Override
    public boolean isFluid() {
        return true;
    }

}