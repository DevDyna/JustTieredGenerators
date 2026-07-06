package com.synergy.justtieredgens.api.factory.basegenerator;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.slots.FuelSlot;
import com.synergy.justtieredgens.api.templates.AbstractMachineGUI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

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
    public ResourceHandlerSlot getFuelSlot(ResourceHandler<ItemResource> handler, IndexModifier<ItemResource> modifier,
            int index, int x, int y) {
        return new FuelSlot(handler, modifier, index, x, y);
    }

}
