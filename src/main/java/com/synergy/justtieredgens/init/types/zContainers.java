package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.builders.fluid_gen.blazegold.BlazeGoldFluidGenGUI;
import com.synergy.justtieredgens.init.builders.fluid_gen.celestigem.CelestigemFluidGenGUI;
import com.synergy.justtieredgens.init.builders.fluid_gen.eclipse_alloy.EclipseAlloyFluidGenGUI;
import com.synergy.justtieredgens.init.builders.solid_gen.blazegold.BlazeGoldCoalGenGUI;
import com.synergy.justtieredgens.init.builders.solid_gen.celestigem.CelestigemCoalGenGUI;
import com.synergy.justtieredgens.init.builders.solid_gen.eclipse_alloy.EclipseAlloyCoalGenGUI;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zContainers {
        public static void register(IEventBus bus) {
                zCTNR.register(bus);
        }

        public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, MODULE_ID);

        public static final DeferredHolder<MenuType<?>, MenuType<BlazeGoldCoalGenGUI>> BLAZEGOLD_COAL = zCTNR
                        .register(Constants.BLAZEGOLD.COAL, () -> IMenuTypeExtension.create(BlazeGoldCoalGenGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<CelestigemCoalGenGUI>> CELESTIGEM_COAL = zCTNR
                        .register(Constants.CELESTIGEM.COAL,
                                        () -> IMenuTypeExtension.create(CelestigemCoalGenGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<EclipseAlloyCoalGenGUI>> ECLIPSE_ALLOY_COAL = zCTNR
                        .register(Constants.ECLIPSE_ALLOY.COAL,
                                        () -> IMenuTypeExtension.create(EclipseAlloyCoalGenGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlazeGoldFluidGenGUI>> BLAZEGOLD_FLUID = zCTNR
                        .register(Constants.BLAZEGOLD.FLUID,
                                        () -> IMenuTypeExtension.create(BlazeGoldFluidGenGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<CelestigemFluidGenGUI>> CELESTIGEM_FLUID = zCTNR
                        .register(Constants.CELESTIGEM.FLUID,
                                        () -> IMenuTypeExtension.create(CelestigemFluidGenGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<EclipseAlloyFluidGenGUI>> ECLIPSE_ALLOY_FLUID = zCTNR
                        .register(Constants.ECLIPSE_ALLOY.FLUID,
                                        () -> IMenuTypeExtension.create(EclipseAlloyFluidGenGUI::new));

}
