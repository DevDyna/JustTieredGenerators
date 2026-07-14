package com.synergy.justtieredgens.api.factory.fluid;

import com.direwolf20.justdirethings.common.blockentities.GeneratorFluidT1BE;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;

public abstract class BaseFluidGenBE extends GeneratorFluidT1BE {

    public BaseFluidGenBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public abstract int getMaxEnergy();

    /**
     * fe rate that the BE can provide to other blocks
     */
    public abstract int getFEOutputPerTick();

    public abstract int getMaxMB();

    public abstract int getFuelMultiplier();

    @Override
    public void doGenerate() {

        if (!isActiveRedstone() || getFluidStack().isEmpty())
            return;

        int fePerFuelTick = this.getFePerFuelTick();

        if (fePerFuelTick == 0 || !(insertEnergy(fePerFuelTick, true) == fePerFuelTick))
            return;

        var fluid = getFluidTank().getFluidInTank(0);

        if (fluid.isEmpty())
            return;

        var extracted = getFluidTank().drain(1, FluidAction.SIMULATE);

        if (!extracted.isEmpty())
            getFluidTank().drain(1, FluidAction.EXECUTE);

        insertEnergy(fePerFuelTick, false);

        setChanged();
    }

    public int getFePerFuelTick() {
        return super.getFePerFuelTick() * getFuelMultiplier();
    }

}
