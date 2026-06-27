package com.synergy.justtieredgens.compat.jei;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.devdyna.cakesticklib.api.utils.x;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class PluginJEI implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return x.rl(MODULE_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration r) {

    }

    @Override
    public void registerRecipes(IRecipeRegistration r) {

    }

}
