package com.synergy.justtieredgens.common;

import com.direwolf20.justdirethings.common.blockentities.GeneratorT1BE;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.init.types.zBlocks;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capability {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {

        event.registerBlock(
                Capabilities.Item.BLOCK, (level, pos, state, be,
                        side) -> be instanceof GeneratorT1BE
                                ? be.getData(JDTRegistration.GENERATOR_ITEM_HANDLER)
                                : null,
                zBlocks.BLAZEGOLD_COAL.get());

        event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                side) -> be instanceof GeneratorT1BE
                        ? be.getData(JDTRegistration.ENERGYSTORAGE_GENERATORS)
                        : null,
                zBlocks.BLAZEGOLD_COAL.get());

    }
}
