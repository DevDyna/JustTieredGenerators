package com.synergy.justtieredgens.init.builders.coal.celestigem;

import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CelestigemCoalGenBlock extends BaseCoalGenBlock<CelestigemCoalGenGUI> {

    public CelestigemCoalGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CelestigemCoalGenBE(pos, state);
    }

    @Override
    public CelestigemCoalGenGUI getGui(int id, Inventory inv, BlockPos pos) {
        return new CelestigemCoalGenGUI(id, inv, pos);
    }

}
