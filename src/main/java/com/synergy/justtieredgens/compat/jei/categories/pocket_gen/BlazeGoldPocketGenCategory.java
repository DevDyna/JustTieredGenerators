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
public class BlazeGoldPocketGenCategory extends BaseCoalGenCategory {
    public static final RecipeType<FuelRecords.Items> TYPE = RecipeType.create(MODULE_ID,
            Constants.BLAZEGOLD.POCKET, FuelRecords.Items.class);

    public BlazeGoldPocketGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zItems.BLAZEGOLD_POCKET_GEN.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.PocketGen.BlazeGold.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.PocketGen.BlazeGold.BURN_SPEED_MULTIPLIER.get();
    }

    @Override
    public String getType() {
        return Constants.BLAZEGOLD.POCKET;
    }

}