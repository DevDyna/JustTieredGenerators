package com.synergy.justtieredgens.init.builders.pocket_generators.celestigem;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CelestigemPocketGenScreen extends BasePocketGenScreen {

    public CelestigemPocketGenScreen(BasePocketGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public int getMultiplier() {
        return Config.PocketGen.Celestigem.SCREEN_MULTIPLIER.get();
    }

}
