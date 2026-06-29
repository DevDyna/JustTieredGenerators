package com.synergy.justtieredgens.api.factory.basegenerator;

import com.direwolf20.justdirethings.common.blocks.GeneratorT1;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BaseCoalGenBlock extends GeneratorT1 {

    public BaseCoalGenBlock(Properties properties) {
        super(properties.sound(SoundType.METAL).strength(2.0F).isRedstoneConductor(BaseMachineBlock::never));
    }

    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof BaseCoalGenBE;
    }

}
