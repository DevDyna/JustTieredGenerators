package com.synergy.justtieredgens.api.factory.basegenerator;

import com.direwolf20.justdirethings.common.blocks.GeneratorT1;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BaseCoalGenBlock extends GeneratorT1 {

    public BaseCoalGenBlock(Properties properties) {
        super(properties);
    }

    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof BaseCoalGenBE;
    }

}
