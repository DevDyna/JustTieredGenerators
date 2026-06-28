package com.synergy.justtieredgens.init.builders.generators.celestigem;

import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.factory.basegenerator.BaseCoalGenBE;
import com.synergy.justtieredgens.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CelestigemCoalGenBE extends BaseCoalGenBE {

    public CelestigemCoalGenBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.CELESTIGEM_COAL.get(), pPos, pBlockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.CELESTIGEM_COAL_MAX_FE.get();
    }

    @Override
    public int getFEPerTick() {
        return Config.CELESTIGEM_COAL_FE_PER_TICK.get();
    }

    @Override
    public int getFePerFuelTick() {
        return Config.CELESTIGEM_COAL_FE_PER_FUEL_TICK.get();
    }

    public int getBurnSpeed() {
        return Config.CELESTIGEM_COAL_BURN_SPEED_MULTIPLIER.get();
    }

}
