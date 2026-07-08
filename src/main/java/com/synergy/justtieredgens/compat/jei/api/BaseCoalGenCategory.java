package com.synergy.justtieredgens.compat.jei.api;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords.Items;

import net.minecraft.world.item.BlockItem;

@SuppressWarnings("null")
public abstract class BaseCoalGenCategory extends BaseGenCategory<FuelRecords.Items> {

        public BaseCoalGenCategory(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Items recipe, IFocusGroup focuses) {
                builder.addSlot(RecipeIngredientRole.INPUT, 1, 8)
                                .addItemStacks(recipe.getFuels());
        }

        @Override
        public int getTime(Items recipe) {
                return recipe.getBurnTime() * getFePerFuelTick() / getRate(recipe);
        }

        @Override
        public int getRate(Items recipe) {
                
                int multiplier = 1;

                if (recipe.getFuels().getFirst().getItem() instanceof Coal_T1 c)
                        multiplier = c.getBurnSpeedMultiplier();
                else if (recipe.getFuels().getFirst().getItem() instanceof BlockItem bi
                                && bi.getBlock() instanceof CoalBlock_T1 c)
                        multiplier = c.getBurnSpeedMultiplier();

                return getFePerFuelTick() * getBurnSpeed() * multiplier;
        }

        public abstract int getFePerFuelTick();

        public abstract int getBurnSpeed();

}