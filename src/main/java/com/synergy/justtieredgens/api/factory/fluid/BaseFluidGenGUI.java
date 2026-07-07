package com.synergy.justtieredgens.api.factory.fluid;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.slots.RefinedFuelSlot;
import com.synergy.justtieredgens.api.templates.AbstractMachineGUI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

public abstract class BaseFluidGenGUI extends AbstractMachineGUI {

    public BaseFluidGenGUI(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    @Override
    public ResourceHandlerSlot getFuelSlot(ResourceHandler<ItemResource> handler, IndexModifier<ItemResource> modifier,
            int index, int x, int y) {
        return new RefinedFuelSlot(handler, modifier, index, x, y);
    }

}
