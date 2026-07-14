package com.synergy.justtieredgens.compat.jei.categories.coal;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class CelestigemCoalGenCategory extends BaseCoalGenCategory {
    public static final RecipeType<FuelRecords.Items> TYPE = RecipeType.create(MODULE_ID,
            Constants.CELESTIGEM.COAL, FuelRecords.Items.class);

    public CelestigemCoalGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zBlocks.CELESTIGEM_COAL.get();
    }

    // @Override
    // public int getMultiplier() {
    //     return 3;
    // }

    @Override
    public int getFePerFuelTick() {
        return Config.CELESTIGEM_COAL_FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.CELESTIGEM_COAL_BURN_SPEED_MULTIPLIER.get();
    }

     @Override
    public String getType() {
        return Constants.CELESTIGEM.COAL;
    }

}