package com.synergy.justtieredgens.init.builders.fluid.blazegold;

import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldFluidGenBlock extends BaseFluidGenBlock<BlazeGoldFluidGenGUI> {

    public BlazeGoldFluidGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlazeGoldFluidGenBE(pos, state);
    }

    @Override
    public BlazeGoldFluidGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new BlazeGoldFluidGenGUI(id, inv, pos);
    }

}
