package com.synergy.justtieredgens.api.factory.coal;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.slots.FuelSlot;
import com.synergy.justtieredgens.api.templates.AbstractMachineGUI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.neoforged.neoforge.items.ItemStackHandler;

public abstract class BaseCoalGenGUI extends AbstractMachineGUI {

    public BaseCoalGenGUI(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public int getBurnRemaining() {
        return this.data == null
                ? 0
                : this.data.get(2);
    }

    public int getMaxBurn() {
        return this.data == null
                ? 0
                : this.data.get(3);
    }

    @Override
    public Slot getFuelSlot(ItemStackHandler  handler, 
            int index, int x, int y) {
        return new FuelSlot(handler,index, x, y);
    }

}
