package com.synergy.justtieredgens.init.builders.fluid.eclipse_alloy;

import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyFluidGenBlock extends BaseFluidGenBlock<EclipseAlloyFluidGenGUI> {

    public EclipseAlloyFluidGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EclipseAlloyFluidGenBE(pos, state);
    }

    @Override
    public EclipseAlloyFluidGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new EclipseAlloyFluidGenGUI(id, inv, pos);
    }

}
