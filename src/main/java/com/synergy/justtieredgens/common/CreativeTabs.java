package com.synergy.justtieredgens.common;

import com.direwolf20.justdirethings.setup.ModSetup;
import com.synergy.justtieredgens.init.types.zItems;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTabs {

    @SubscribeEvent
    public static void register(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == ModSetup.TAB_JUSTDIRETHINGS.getKey())
            zItems.zBlockItem.getEntries().forEach(i->event.accept(i.get()));
    }
}
