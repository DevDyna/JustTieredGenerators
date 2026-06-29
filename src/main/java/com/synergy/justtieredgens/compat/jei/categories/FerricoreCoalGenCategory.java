package com.synergy.justtieredgens.compat.jei.categories;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.compat.jei.api.BaseCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FerricoreCoalGenCategory extends BaseCoalGenCategory {
    public static final IRecipeType<FuelRecords.Items> TYPE = IRecipeType.create(MODULE_ID,
            JDTRegistration.GeneratorT1_ITEM.getId().getPath(), FuelRecords.Items.class);

    public FerricoreCoalGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return JDTRegistration.GeneratorT1_ITEM.get();
    }

    @Override
    public int getMultiplier() {
        return 1;
    }

    @Override
    public int getFePerFuelTick() {
        return Config.GENERATOR_T1_FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get();
    }

}