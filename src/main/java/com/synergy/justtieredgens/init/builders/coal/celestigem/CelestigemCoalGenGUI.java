package com.synergy.justtieredgens.init.builders.coal.celestigem;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenGUI;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;

public class CelestigemCoalGenGUI extends BaseCoalGenGUI {

    public CelestigemCoalGenGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public CelestigemCoalGenGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.CELESTIGEM_COAL.get(), windowId, playerInventory, blockPos);
    }

    public Block stillValid() {
        return zBlocks.CELESTIGEM_COAL.get();
    }

}
