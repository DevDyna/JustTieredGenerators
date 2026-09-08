package com.synergy.justtieredgens.init.builders.fluid_gen.blazegold;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.fluid.BaseFluidGenBE;
import com.synergy.justtieredgens.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldFluidGenBE extends BaseFluidGenBE {

    public BlazeGoldFluidGenBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.BLAZEGOLD_FLUID.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.FluidGen.BlazeGold.MAX_FE.get();
    }

    @Override
    public int getFEOutputPerTick() {
        return Config.FluidGen.BlazeGold.FE_PER_TICK.get();
    }

    @Override
    public int getMaxMB() {
        return Config.FluidGen.BlazeGold.MAX_MB.get();
    }

    @Override
    public int getFuelMultiplier() {
        return Config.FluidGen.BlazeGold.FUEL_MULTIPLIER.get();
    }

}
