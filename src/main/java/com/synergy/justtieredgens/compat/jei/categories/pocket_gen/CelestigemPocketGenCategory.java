package com.synergy.justtieredgens.compat.jei.categories.pocket_gen;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class CelestigemPocketGenCategory extends BaseCoalGenCategory {
    public static final RecipeType<FuelRecords.Items> TYPE = RecipeType.create(MODULE_ID,
            Constants.CELESTIGEM.POCKET, FuelRecords.Items.class);

    public CelestigemPocketGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zItems.CELESTIGEM_POCKET_GEN.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.PocketGen.Celestigem.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.PocketGen.Celestigem.BURN_SPEED_MULTIPLIER.get();
    }

     @Override
    public String getType() {
        return Constants.CELESTIGEM.POCKET;
    }

}