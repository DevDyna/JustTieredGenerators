package com.synergy.justtieredgens.init.builders.pocket_generators.blazegold;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BlazeGoldPocketGenScreen extends BasePocketGenScreen {

    public BlazeGoldPocketGenScreen(BasePocketGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public int getMultiplier() {
        return Config.PocketGen.BlazeGold.SCREEN_MULTIPLIER.get();
    }

}
