package com.synergy.justtieredgens.init.builders.generators.eclipse_alloy;

import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyCoalGenBlock extends BaseCoalGenBlock {

    public EclipseAlloyCoalGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EclipseAlloyCoalGenBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider((index, inv, p) -> new EclipseAlloyCoalGenGUI(index, inv, blockPos),
                Component.translatable("")), (b) -> b.writeBlockPos(blockPos));
    }

}
