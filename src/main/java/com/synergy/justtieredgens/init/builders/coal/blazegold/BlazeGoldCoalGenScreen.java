package com.synergy.justtieredgens.init.builders.coal.blazegold;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenGUI;
import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BlazeGoldCoalGenScreen extends BaseCoalGenScreen {

    public BlazeGoldCoalGenScreen(BaseCoalGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    public int getMultiplier() {
        return 2;
    }

}
