package com.synergy.justtieredgens.init.builders.coal.eclipse_alloy;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyCoalGenBlock extends BaseCoalGenBlock<EclipseAlloyCoalGenGUI> {

    public EclipseAlloyCoalGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EclipseAlloyCoalGenBE(pos, state);
    }

    @Override
    public EclipseAlloyCoalGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new EclipseAlloyCoalGenGUI(id, inv, pos);
    }

}
