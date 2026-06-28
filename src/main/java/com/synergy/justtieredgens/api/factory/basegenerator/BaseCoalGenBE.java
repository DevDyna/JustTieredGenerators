package com.synergy.justtieredgens.api.factory.basegenerator;

import com.direwolf20.justdirethings.common.blockentities.GeneratorT1BE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseCoalGenBE extends GeneratorT1BE {

    public BaseCoalGenBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public abstract int getMaxEnergy();

    public abstract int getFEPerTick();

    public abstract int getFePerFuelTick();

    public abstract int getBurnSpeed();

    @Override
    public int getBurnSpeedMultiplier() {
        return getBurnSpeed() *
                (super.getBurnSpeedMultiplier()
                        / com.direwolf20.justdirethings.setup.Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get());
    }

}
