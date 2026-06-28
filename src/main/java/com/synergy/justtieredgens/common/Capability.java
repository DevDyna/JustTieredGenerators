package com.synergy.justtieredgens.common;

import com.direwolf20.justdirethings.common.blockentities.GeneratorT1BE;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capability {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {

        var generators = new Block[]{zBlocks.BLAZEGOLD_COAL.get(),zBlocks.CELESTIGEM_COAL.get(),zBlocks.ECLIPSE_ALLOY_COAL.get()};

        event.registerBlock(
                Capabilities.Item.BLOCK, (level, pos, state, be,
                        side) -> be instanceof GeneratorT1BE
                                ? be.getData(JDTRegistration.GENERATOR_ITEM_HANDLER)
                                : null,
                generators);

        event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                side) -> be instanceof GeneratorT1BE
                        ? be.getData(JDTRegistration.ENERGYSTORAGE_GENERATORS)
                        : null,
                generators);

    }
}
