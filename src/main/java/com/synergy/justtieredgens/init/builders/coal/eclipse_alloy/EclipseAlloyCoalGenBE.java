package com.synergy.justtieredgens.init.builders.coal.eclipse_alloy;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.coal.BaseCoalGenBE;
import com.synergy.justtieredgens.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyCoalGenBE extends BaseCoalGenBE {

    public EclipseAlloyCoalGenBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.ECLIPSE_ALLOY_COAL.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.ECLIPSE_ALLOY_COAL_MAX_FE.get();
    }

    @Override
    public int getFEPerTick() {
        return Config.ECLIPSE_ALLOY_COAL_FE_PER_TICK.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.ECLIPSE_ALLOY_COAL_FE_PER_FUEL_TICK.get();
    }

    public int getBurnSpeed() {
        return Config.ECLIPSE_ALLOY_COAL_BURN_SPEED_MULTIPLIER.get();
    }

}
