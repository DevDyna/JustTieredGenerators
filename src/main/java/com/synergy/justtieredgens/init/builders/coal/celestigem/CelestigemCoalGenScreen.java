package com.synergy.justtieredgens.init.builders.coal.celestigem;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenGUI;
import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CelestigemCoalGenScreen extends BaseCoalGenScreen {

    public CelestigemCoalGenScreen(BaseCoalGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    public int getMultiplier() {
        return 3;
    }

}
