package com.synergy.justtieredgens.compat.jei.categories.pocket_gen;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class EclipseAlloyPocketGenCategory extends BaseCoalGenCategory {
    public static final IRecipeType<FuelRecords.Items> TYPE = IRecipeType.create(MODULE_ID,
            Constants.ECLIPSE_ALLOY.POCKET, FuelRecords.Items.class);

    public EclipseAlloyPocketGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return zItems.ECLIPSE_ALLOY_POCKET_GEN.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.PocketGen.EclipseAlloy.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.PocketGen.EclipseAlloy.BURN_SPEED_MULTIPLIER.get();
    }

     @Override
    public String getType() {
        return Constants.ECLIPSE_ALLOY.POCKET;
    }

}