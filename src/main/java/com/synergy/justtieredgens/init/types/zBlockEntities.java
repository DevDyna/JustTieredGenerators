package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.api.RegistryUtils;
import com.synergy.justtieredgens.init.builders.fluid_gen.blazegold.BlazeGoldFluidGenBE;
import com.synergy.justtieredgens.init.builders.fluid_gen.celestigem.CelestigemFluidGenBE;
import com.synergy.justtieredgens.init.builders.fluid_gen.eclipse_alloy.EclipseAlloyFluidGenBE;
import com.synergy.justtieredgens.init.builders.solid_gen.blazegold.BlazeGoldCoalGenBE;
import com.synergy.justtieredgens.init.builders.solid_gen.celestigem.CelestigemCoalGenBE;
import com.synergy.justtieredgens.init.builders.solid_gen.eclipse_alloy.EclipseAlloyCoalGenBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlockEntities {

    public static void register(IEventBus bus) {
        zTiles.register(bus);
    }

    public static final DeferredRegister<BlockEntityType<?>> zTiles = DeferredRegister
            .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODULE_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldCoalGenBE>> BLAZEGOLD_COAL = RegistryUtils
            .createBlockEntity(Constants.BLAZEGOLD.COAL, zTiles, BlazeGoldCoalGenBE::new, zBlocks.BLAZEGOLD_COAL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestigemCoalGenBE>> CELESTIGEM_COAL = RegistryUtils
            .createBlockEntity(Constants.CELESTIGEM.COAL, zTiles, CelestigemCoalGenBE::new, zBlocks.CELESTIGEM_COAL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloyCoalGenBE>> ECLIPSE_ALLOY_COAL = RegistryUtils
            .createBlockEntity(Constants.ECLIPSE_ALLOY.COAL, zTiles, EclipseAlloyCoalGenBE::new,
                    zBlocks.ECLIPSE_ALLOY_COAL);


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldFluidGenBE>> BLAZEGOLD_FLUID = RegistryUtils
            .createBlockEntity(Constants.BLAZEGOLD.FLUID, zTiles, BlazeGoldFluidGenBE::new, zBlocks.BLAZEGOLD_FLUID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestigemFluidGenBE>> CELESTIGEM_FLUID = RegistryUtils
            .createBlockEntity(Constants.CELESTIGEM.FLUID, zTiles, CelestigemFluidGenBE::new, zBlocks.CELESTIGEM_FLUID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloyFluidGenBE>> ECLIPSE_ALLOY_FLUID = RegistryUtils
            .createBlockEntity(Constants.ECLIPSE_ALLOY.FLUID, zTiles, EclipseAlloyFluidGenBE::new,
                    zBlocks.ECLIPSE_ALLOY_FLUID);

}
