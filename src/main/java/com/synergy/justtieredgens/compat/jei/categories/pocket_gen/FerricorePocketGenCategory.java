package com.synergy.justtieredgens.compat.jei.categories.pocket_gen;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FerricorePocketGenCategory extends BaseCoalGenCategory {
    public static final IRecipeType<FuelRecords.Items> TYPE = IRecipeType.create(MODULE_ID,
            JDTRegistration.Pocket_Generator.getId().getPath(), FuelRecords.Items.class);

    public FerricorePocketGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return JDTRegistration.Pocket_Generator.get();
    }

     @Override
    public String getType() {
        return Constants.FERRICORE.POCKET;
    }

    @Override
    public int getFePerFuelTick() {
        return Config.POCKET_GENERATOR_FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.POCKET_GENERATOR_BURN_SPEED_MULTIPLIER.get();
    }

}