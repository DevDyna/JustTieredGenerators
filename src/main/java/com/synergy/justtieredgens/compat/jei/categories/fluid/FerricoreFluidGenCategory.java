package com.synergy.justtieredgens.compat.jei.categories.fluid;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.compat.jei.api.BaseFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;

import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FerricoreFluidGenCategory extends BaseFluidGenCategory {
    public static final IRecipeType<FuelRecords.Fluids> TYPE = IRecipeType.create(MODULE_ID,
            JDTRegistration.GeneratorFluidT1_ITEM.getId().getPath(), FuelRecords.Fluids.class);

    public FerricoreFluidGenCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Fluids> getRecipeType() {
        return TYPE;
    }

    @Override
    public ItemLike getGenerator() {
        return JDTRegistration.GeneratorFluidT1_ITEM.get();
    }

     @Override
    public String getType() {
        return Constants.FERRICORE.FLUID;
    }

}