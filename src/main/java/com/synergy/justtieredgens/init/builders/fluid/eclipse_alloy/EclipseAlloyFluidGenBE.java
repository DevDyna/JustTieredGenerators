package com.synergy.justtieredgens.init.builders.fluid.eclipse_alloy;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBE;
import com.synergy.justtieredgens.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyFluidGenBE extends BaseFluidGenBE {

    public EclipseAlloyFluidGenBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.ECLIPSE_ALLOY_FLUID.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.ECLIPSE_ALLOY_FLUID_MAX_FE.get();
    }

    @Override
    public int getFEOutputPerTick() {
        return Config.ECLIPSE_ALLOY_FLUID_FE_PER_TICK.get();
    }

    @Override
    public int getMaxMB() {
        return Config.ECLIPSE_ALLOY_FLUID_MAX_MB.get();
    }

    @Override
    public int getFuelMultiplier() {
        return Config.ECLIPSE_ALLOY_FLUID_FUEL_MULTIPLIER.get();
    }

}
