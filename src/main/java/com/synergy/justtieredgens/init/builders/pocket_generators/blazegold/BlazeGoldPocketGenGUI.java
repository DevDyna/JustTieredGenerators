package com.synergy.justtieredgens.init.builders.pocket_generators.blazegold;

import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class BlazeGoldPocketGenGUI extends BasePocketGenGUI {

    public BlazeGoldPocketGenGUI(int windowId, Inventory inv, ItemStack item) {
        super(zContainers.BLAZEGOLD_POCKET_GEN.get(), windowId, inv, inv.player, item);
    }

    public BlazeGoldPocketGenGUI(int windowId, Inventory inv, RegistryFriendlyByteBuf extraData) {
        super(zContainers.BLAZEGOLD_POCKET_GEN.get(), windowId, inv, inv.player, extraData);
    }

}
