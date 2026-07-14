package com.synergy.justtieredgens.api.factory.fluid;

import com.direwolf20.justdirethings.common.blocks.GeneratorFluidT1;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class BaseFluidGenBlock<GUI extends BaseFluidGenGUI> extends GeneratorFluidT1 {

    public BaseFluidGenBlock(Properties properties) {
        super();
    }

    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof BaseFluidGenBE;
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider((index, inv, p) -> getGui(index, inv, blockPos),
                Component.translatable("")), (b) -> b.writeBlockPos(blockPos));
    }

    public abstract GUI getGui(int id, Inventory inv, BlockPos pos);

}
