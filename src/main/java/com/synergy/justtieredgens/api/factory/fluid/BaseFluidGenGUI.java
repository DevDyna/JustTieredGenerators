package com.synergy.justtieredgens.api.factory.fluid;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.slots.RefinedFuelSlot;
import com.synergy.justtieredgens.api.templates.AbstractMachineGUI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.neoforged.neoforge.items.ItemStackHandler;


public abstract class BaseFluidGenGUI extends AbstractMachineGUI {

    public BaseFluidGenGUI(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    @Override
    public Slot getFuelSlot(ItemStackHandler handler, 
            int index, int x, int y) {
        return new RefinedFuelSlot(handler, index, x, y);
    }

}
