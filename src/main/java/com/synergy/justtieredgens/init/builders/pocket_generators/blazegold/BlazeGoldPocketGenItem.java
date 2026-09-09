package com.synergy.justtieredgens.init.builders.pocket_generators.blazegold;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenItem;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class BlazeGoldPocketGenItem extends BasePocketGenItem {

    public BlazeGoldPocketGenItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public <T extends BasePocketGenGUI> T getMenu(int id, Inventory inv, ItemStack item) {
        return (T) new BlazeGoldPocketGenGUI(id, inv, item);
    }

    @Override
    public int getMaxEnergy() {
        return Config.PocketGen.BlazeGold.MAX_FE.get();
    }

    @Override
    public int getFEPerTick() {
        return Config.PocketGen.BlazeGold.FE_PER_TICK.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.PocketGen.BlazeGold.FE_PER_FUEL_TICK.get();
    }

    @Override
    public int getBurnSpeed() {
        return Config.PocketGen.BlazeGold.BURN_SPEED_MULTIPLIER.get();
    }

}
