package com.synergy.justtieredgens.init;

import com.synergy.justtieredgens.init.types.*;

import net.neoforged.bus.api.IEventBus;

public class Material {
        public static void register(IEventBus bus) {
                zItems.register(bus);
                zBlocks.register(bus);
                zBlockEntities.register(bus);
                zContainers.register(bus);
        }


}
