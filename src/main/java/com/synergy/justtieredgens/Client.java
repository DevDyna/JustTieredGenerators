package com.synergy.justtieredgens;

import com.synergy.justtieredgens.init.builders.coal.blazegold.BlazeGoldCoalGenScreen;
import com.synergy.justtieredgens.init.builders.coal.celestigem.CelestigemCoalGenScreen;
import com.synergy.justtieredgens.init.builders.coal.eclipse_alloy.EclipseAlloyCoalGenScreen;
import com.synergy.justtieredgens.init.builders.fluid.blazegold.BlazeGoldFluidGenScreen;
import com.synergy.justtieredgens.init.builders.fluid.celestigem.CelestigemFluidGenScreen;
import com.synergy.justtieredgens.init.builders.fluid.eclipse_alloy.EclipseAlloyFluidGenScreen;
import com.synergy.justtieredgens.init.types.zContainers;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Main.MODULE_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Main.MODULE_ID, value = Dist.CLIENT)
public class Client {

    public Client(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void render(EntityRenderersEvent.RegisterRenderers event) {

    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(zContainers.BLAZEGOLD_COAL.get(), BlazeGoldCoalGenScreen::new);
        event.register(zContainers.CELESTIGEM_COAL.get(), CelestigemCoalGenScreen::new);
        event.register(zContainers.ECLIPSE_ALLOY_COAL.get(), EclipseAlloyCoalGenScreen::new);

        event.register(zContainers.BLAZEGOLD_FLUID.get(), BlazeGoldFluidGenScreen::new);
        event.register(zContainers.CELESTIGEM_FLUID.get(), CelestigemFluidGenScreen::new);
        event.register(zContainers.ECLIPSE_ALLOY_FLUID.get(), EclipseAlloyFluidGenScreen::new);

    }

}
