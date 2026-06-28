package com.synergy.justtieredgens.init.builders.generators.eclipse_alloy;

import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenGUI;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zContainers;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;

public class EclipseAlloyCoalGenGUI extends BaseCoalGenGUI {

    public EclipseAlloyCoalGenGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public EclipseAlloyCoalGenGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.ECLIPSE_ALLOY_COAL.get(), windowId, playerInventory, blockPos);
    }

    public Block stillValid() {
        return zBlocks.ECLIPSE_ALLOY_COAL.get();
    }

}
