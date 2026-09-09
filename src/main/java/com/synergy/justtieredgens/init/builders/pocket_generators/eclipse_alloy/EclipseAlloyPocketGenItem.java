package com.synergy.justtieredgens.init.builders.pocket_generators.eclipse_alloy;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenItem;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class EclipseAlloyPocketGenItem extends BasePocketGenItem {

    public EclipseAlloyPocketGenItem(Properties p) {
        super();
    }

    @Override
    public <T extends BasePocketGenGUI> T getMenu(int id, Inventory inv, ItemStack item) {
        return (T) new EclipseAlloyPocketGenGUI(id, inv, item);
    }

    @Override
    public int getMaxEnergy() {
        return Config.PocketGen.EclipseAlloy.MAX_FE.get();
    }

    @Override
    public int getFEPerTick() {
        return Config.PocketGen.EclipseAlloy.FE_PER_TICK.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.PocketGen.EclipseAlloy.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.PocketGen.EclipseAlloy.BURN_SPEED_MULTIPLIER.get();
    }

}
