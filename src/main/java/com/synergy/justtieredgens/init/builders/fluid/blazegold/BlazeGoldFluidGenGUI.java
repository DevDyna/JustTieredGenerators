package com.synergy.justtieredgens.init.builders.fluid.blazegold;

import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenGUI;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;

public class BlazeGoldFluidGenGUI extends BaseFluidGenGUI {

    public BlazeGoldFluidGenGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public BlazeGoldFluidGenGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.BLAZEGOLD_FLUID.get(), windowId, playerInventory, blockPos);
    }

    public Block stillValid() {
        return zBlocks.BLAZEGOLD_FLUID.get();
    }

}
