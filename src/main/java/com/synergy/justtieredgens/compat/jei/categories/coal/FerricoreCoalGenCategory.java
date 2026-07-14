package com.synergy.justtieredgens.compat.jei.categories.coal;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.Registration;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FerricoreCoalGenCategory extends BaseCoalGenCategory {
    public static final RecipeType<FuelRecords.Items> TYPE = RecipeType.create(MODULE_ID,
            Registration.GeneratorT1_ITEM.getId().getPath(), FuelRecords.Items.class);

    public FerricoreCoalGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return Registration.GeneratorT1_ITEM.get();
    }

     @Override
    public String getType() {
        return Constants.FERRICORE.COAL;
    }

    // @Override
    // public int getMultiplier() {
    //     return 1;
    // }

    @Override
    public int getFePerFuelTick() {
        return Config.GENERATOR_T1_FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get();
    }

}