package com.synergy.justtieredgens.compat.jei.categories.fluid;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class CelestigemFluidGenCategory extends BaseFluidGenCategory {
    public static final RecipeType<FuelRecords.Fluids> TYPE = RecipeType.create(MODULE_ID,
            Constants.CELESTIGEM.FLUID, FuelRecords.Fluids.class);

    public CelestigemFluidGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Fluids> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zBlocks.CELESTIGEM_FLUID.get();
    }

    @Override
    public int getGenMultiplier() {
        return Config.CELESTIGEM_FLUID_FUEL_MULTIPLIER.get();
    }

     @Override
    public String getType() {
        return Constants.CELESTIGEM.FLUID;
    }

}