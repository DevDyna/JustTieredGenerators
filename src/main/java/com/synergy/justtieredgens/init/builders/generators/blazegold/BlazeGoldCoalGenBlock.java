package com.synergy.justtieredgens.init.builders.generators.blazegold;

import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldCoalGenBlock extends BaseCoalGenBlock {

    public BlazeGoldCoalGenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlazeGoldCoalGenBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider((index, inv, p) -> new BlazeGoldCoalGenGUI(index, inv, blockPos),
                Component.translatable("")), (b) -> b.writeBlockPos(blockPos));
    }

}
