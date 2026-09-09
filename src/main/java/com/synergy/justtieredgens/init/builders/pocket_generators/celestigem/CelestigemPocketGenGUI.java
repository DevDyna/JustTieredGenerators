package com.synergy.justtieredgens.init.builders.pocket_generators.celestigem;

import com.synergy.justtieredgens.api.factory.pocket.BasePocketGenGUI;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class CelestigemPocketGenGUI extends BasePocketGenGUI {

    public CelestigemPocketGenGUI(int windowId, Inventory inv, ItemStack item) {
        super(zContainers.CELESTIGEM_POCKET_GEN.get(), windowId, inv, inv.player, item);
    }

    public CelestigemPocketGenGUI(int windowId, Inventory inv, RegistryFriendlyByteBuf extraData) {
        super(zContainers.CELESTIGEM_POCKET_GEN.get(), windowId, inv, inv.player, extraData);
    }

}
