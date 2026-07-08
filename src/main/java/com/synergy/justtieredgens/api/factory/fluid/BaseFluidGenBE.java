package com.synergy.justtieredgens.api.factory.fluid;

import com.direwolf20.justdirethings.common.blockentities.GeneratorFluidT1BE;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.transaction.Transaction;

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

        FluidResource fluid = getFluidTank().getResource(0);

        if (fluid.isEmpty())
            return;

        int extracted = 0;
        try (Transaction tx = Transaction.openRoot()) {
            extracted = getFluidTank().extract(0, fluid, 1, tx);

            if (extracted == 0)
                return;

            tx.commit();
        }

        insertEnergy(fePerFuelTick, false);

        setChanged();
    }

    public int getFePerFuelTick() {
        return super.getFePerFuelTick() * getFuelMultiplier();
    }

}
