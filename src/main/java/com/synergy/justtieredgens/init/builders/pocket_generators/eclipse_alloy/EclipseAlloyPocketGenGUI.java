package com.synergy.justtieredgens.init.builders.pocket_generators.eclipse_alloy;

import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class EclipseAlloyPocketGenGUI extends BasePocketGenGUI {

    public EclipseAlloyPocketGenGUI(int windowId, Inventory inv, ItemStack item) {
        super(zContainers.ECLIPSE_ALLOY_POCKET_GEN.get(), windowId, inv, inv.player, item);
    }

    public EclipseAlloyPocketGenGUI(int windowId, Inventory inv, RegistryFriendlyByteBuf extraData) {
        super(zContainers.ECLIPSE_ALLOY_POCKET_GEN.get(), windowId, inv, inv.player, extraData);
    }

}
