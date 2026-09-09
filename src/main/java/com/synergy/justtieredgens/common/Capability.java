package com.synergy.justtieredgens.common;

import com.direwolf20.justdirethings.common.blockentities.GeneratorFluidT1BE;
import com.direwolf20.justdirethings.common.blockentities.GeneratorT1BE;
import com.direwolf20.justdirethings.common.capabilities.EnergyStorageItemStackNoReceive;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemAccessItemHandler;

public class Capability {

        @SubscribeEvent
        public static void register(RegisterCapabilitiesEvent event) {

                var coal_gens = new Block[] {
                                zBlocks.BLAZEGOLD_COAL.get(),
                                zBlocks.CELESTIGEM_COAL.get(),
                                zBlocks.ECLIPSE_ALLOY_COAL.get() };

                var fluid_gens = new Block[] {
                                zBlocks.BLAZEGOLD_FLUID.get(),
                                zBlocks.CELESTIGEM_FLUID.get(),
                                zBlocks.ECLIPSE_ALLOY_FLUID.get() };

                event.registerBlock(
                                Capabilities.Item.BLOCK, (level, pos, state, be,
                                                side) -> be instanceof GeneratorT1BE
                                                                ? be.getData(JDTRegistration.GENERATOR_ITEM_HANDLER)
                                                                : null,
                                coal_gens);

                event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                                side) -> be instanceof GeneratorT1BE
                                                ? be.getData(JDTRegistration.ENERGYSTORAGE_GENERATORS)
                                                : null,
                                coal_gens);

                event.registerBlock(
                                Capabilities.Item.BLOCK, (level, pos, state, be,
                                                side) -> be instanceof GeneratorFluidT1BE
                                                                ? be.getData(JDTRegistration.GENERATOR_FLUID_ITEM_HANDLER)
                                                                : null,
                                fluid_gens);

                event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                                side) -> be instanceof GeneratorFluidT1BE
                                                ? be.getData(JDTRegistration.ENERGYSTORAGE_GENERATORS)
                                                : null,
                                fluid_gens);

                event.registerBlock(Capabilities.Fluid.BLOCK, (level, pos, state, be,
                                side) -> be instanceof GeneratorFluidT1BE
                                                ? be.getData(JDTRegistration.GENERATOR_FLUID_HANDLER)
                                                : null,
                                fluid_gens);

                event.registerItem(Capabilities.Item.ITEM, (item, ctx) -> new ItemAccessItemHandler(
                                ctx != null ? ctx : ItemAccess.forStack(item),
                                JustDireDataComponents.ITEMSTACK_HANDLER.get(), 1),
                                zItems.BLAZEGOLD_POCKET_GEN.get(),
                                zItems.CELESTIGEM_POCKET_GEN.get(),
                                zItems.ECLIPSE_ALLOY_POCKET_GEN.get()

                );

                event.registerItem(Capabilities.Energy.ITEM, (item, acc) -> new EnergyStorageItemStackNoReceive(
                                acc != null ? acc : ItemAccess.forStack(item),
                                (item.getItem() instanceof PoweredItem p) ? p.getMaxEnergy()
                                                : 1000000),
                                zItems.BLAZEGOLD_POCKET_GEN.get(),
                                zItems.CELESTIGEM_POCKET_GEN.get(),
                                zItems.ECLIPSE_ALLOY_POCKET_GEN.get());

        }
}
