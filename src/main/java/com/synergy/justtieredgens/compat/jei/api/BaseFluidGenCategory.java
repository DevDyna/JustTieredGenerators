package com.synergy.justtieredgens.compat.jei.api;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import com.devdyna.cakesticklib.api.compat.jei.JEIFluidTankHelper;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

@SuppressWarnings("null")
public abstract class BaseFluidGenCategory extends BaseGenCategory<FuelRecords.Fluids> {

    public BaseFluidGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Fluids recipe, IFocusGroup focuses) {
        JEIFluidTankHelper.of()
                .fluid(new SizedFluidIngredient(FluidIngredient.of(recipe.getFuels().toArray(FluidStack[]::new)), 1))
                .offset(1, 8 + 16)
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