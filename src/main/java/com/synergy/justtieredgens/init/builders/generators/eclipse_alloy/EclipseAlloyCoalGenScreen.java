package com.synergy.justtieredgens.init.builders.generators.eclipse_alloy;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenGUI;
import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenScreen;

public class EclipseAlloyCoalGenScreen extends BaseCoalGenScreen {

    public EclipseAlloyCoalGenScreen(BaseCoalGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    public int getMultiplier() {
        return 4;
    }

}
