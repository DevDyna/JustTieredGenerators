package com.synergy.justtieredgens.init.builders.fluid_gen.eclipse_alloy;

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
        return Config.FluidGen.EclipseAlloy.MAX_FE.get();
    }

    @Override
    public int getFEOutputPerTick() {
        return Config.FluidGen.EclipseAlloy.FE_PER_TICK.get();
    }

    @Override
    public int getMaxMB() {
        return Config.FluidGen.EclipseAlloy.MAX_MB.get();
    }

    @Override
    public int getFuelMultiplier() {
        return Config.FluidGen.EclipseAlloy.FUEL_MULTIPLIER.get();
    }

}
