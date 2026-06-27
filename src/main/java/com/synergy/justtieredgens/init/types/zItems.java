package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zItems {

    public static void register(IEventBus bus) {
        zBlockItem.register(bus);
    }

    public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(MODULE_ID);

  
}
