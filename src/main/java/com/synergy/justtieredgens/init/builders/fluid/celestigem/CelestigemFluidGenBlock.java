package com.synergy.justtieredgens.init.builders.fluid.celestigem;

import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CelestigemFluidGenBlock extends BaseFluidGenBlock<CelestigemFluidGenGUI> {

    public CelestigemFluidGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CelestigemFluidGenBE(pos, state);
    }

    @Override
    public CelestigemFluidGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new CelestigemFluidGenGUI(id, inv, pos);
    }

}
