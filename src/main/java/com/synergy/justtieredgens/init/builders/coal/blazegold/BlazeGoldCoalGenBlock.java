package com.synergy.justtieredgens.init.builders.coal.blazegold;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldCoalGenBlock extends BaseCoalGenBlock<BlazeGoldCoalGenGUI> {

    public BlazeGoldCoalGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlazeGoldCoalGenBE(pos, state);
    }

    @Override
    public BlazeGoldCoalGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new BlazeGoldCoalGenGUI(id, inv, pos);
    }

}
