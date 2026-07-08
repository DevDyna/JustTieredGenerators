package com.synergy.justtieredgens.init.builders.coal.blazegold;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenGUI;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;

public class BlazeGoldCoalGenGUI extends BaseCoalGenGUI {

    public BlazeGoldCoalGenGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public BlazeGoldCoalGenGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.BLAZEGOLD_COAL.get(), windowId, playerInventory, blockPos);
    }

    public Block stillValid() {
        return zBlocks.BLAZEGOLD_COAL.get();
    }

}
