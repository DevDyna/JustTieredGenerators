package com.synergy.justtieredgens.api.factory.coal;

import com.direwolf20.justdirethings.common.blocks.GeneratorT1;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class BaseCoalGenBlock<GUI extends BaseCoalGenGUI> extends GeneratorT1 {

    public BaseCoalGenBlock(Properties properties) {
        super();
    }

    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof BaseCoalGenBE;
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider((index, inv, p) -> getGui(index, inv, blockPos),
                Component.translatable("")), (b) -> b.writeBlockPos(blockPos));
    }

    public abstract GUI getGui(int id, Inventory inv, BlockPos pos);

}
