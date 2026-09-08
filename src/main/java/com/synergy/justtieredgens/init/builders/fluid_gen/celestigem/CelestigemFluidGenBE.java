package com.synergy.justtieredgens.init.builders.fluid_gen.celestigem;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBE;
import com.synergy.justtieredgens.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CelestigemFluidGenBE extends BaseFluidGenBE {

    public CelestigemFluidGenBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.CELESTIGEM_FLUID.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.FluidGen.Celestigem.MAX_FE.get();
    }

    @Override
    public int getFEOutputPerTick() {
        return Config.FluidGen.Celestigem.FE_PER_TICK.get();
    }

    @Override
    public int getMaxMB() {
        return Config.FluidGen.Celestigem.MAX_MB.get();
    }

    @Override
    public int getFuelMultiplier() {
        return Config.FluidGen.Celestigem.FUEL_MULTIPLIER.get();
    }

}
