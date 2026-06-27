package com.synergy.justtieredgens.api.factory.basegenerator;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import com.direwolf20.justdirethings.common.containers.slots.FuelSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;

public abstract class BaseCoalGenGUI extends BaseMachineContainer {

    public BaseCoalGenGUI(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
        addPlayerSlots(player.getInventory());
    }

    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
        addFuelSlotRange(machineHandler, machineHandler::set, 0, 80, 13, 1, 18);
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

    protected int addFuelSlotRange(ResourceHandler<ItemResource> handler, IndexModifier<ItemResource> slotModifier,
            int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new FuelSlot(handler, slotModifier, index, x, y));
            x += dx;
            index++;
        }
        return index;
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
}
