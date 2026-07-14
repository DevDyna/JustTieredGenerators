package com.synergy.justtieredgens.api.templates;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.items.ItemStackHandler;


public abstract class AbstractMachineGUI extends BaseMachineContainer {

    public AbstractMachineGUI(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
        addPlayerSlots(player.getInventory());
    }

    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
        addSlot(getFuelSlot(machineHandler, 0, 80, 13));
    }

    public abstract Block stillValid();

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, stillValid());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        return super.quickMoveStack(playerIn, index);
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
    }

    public abstract Slot getFuelSlot(ItemStackHandler  handler,
             int index, int x, int y);
}
