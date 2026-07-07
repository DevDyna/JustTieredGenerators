package com.synergy.justtieredgens.init.builders.fluid.celestigem;

import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenGUI;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CelestigemFluidGenScreen extends BaseFluidGenScreen {

    public CelestigemFluidGenScreen(BaseFluidGenGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public int getMultiplier() {
        return 3;
    }

}
