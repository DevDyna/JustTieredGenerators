package com.synergy.justtieredgens.compat.jei.categories.solid_gen;

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
public class EclipseAlloyCoalGenCategory extends BaseCoalGenCategory {
    public static final RecipeType<FuelRecords.Items> TYPE = RecipeType.create(MODULE_ID,
            Constants.ECLIPSE_ALLOY.COAL, FuelRecords.Items.class);

    public EclipseAlloyCoalGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zBlocks.ECLIPSE_ALLOY_COAL.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.SolidGen.EclipseAlloy.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.SolidGen.EclipseAlloy.BURN_SPEED_MULTIPLIER.get();
    }

     @Override
    public String getType() {
        return Constants.ECLIPSE_ALLOY.COAL;
    }

}