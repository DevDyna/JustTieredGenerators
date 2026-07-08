package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.function.Function;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.builders.coal.blazegold.BlazeGoldCoalGenBlock;
import com.synergy.justtieredgens.init.builders.coal.celestigem.CelestigemCoalGenBlock;
import com.synergy.justtieredgens.init.builders.coal.eclipse_alloy.EclipseAlloyCoalGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.blazegold.BlazeGoldFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.celestigem.CelestigemFluidGenBlock;
import com.synergy.justtieredgens.init.builders.fluid.eclipse_alloy.EclipseAlloyFluidGenBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlocks {

    public static void register(IEventBus bus) {
        zBlockItem.register(bus);
    }

    public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(MODULE_ID);

    public static final DeferredHolder<Block, Block> BLAZEGOLD_COAL = registerItemBlock(Constants.BLAZEGOLD.COAL,  p -> new BlazeGoldCoalGenBlock(p));
   
    public static final DeferredHolder<Block, Block> CELESTIGEM_COAL = registerItemBlock(Constants.CELESTIGEM.COAL,  p -> new CelestigemCoalGenBlock(p));
   
    public static final DeferredHolder<Block, Block> ECLIPSE_ALLOY_COAL = registerItemBlock(Constants.ECLIPSE_ALLOY.COAL,  p -> new EclipseAlloyCoalGenBlock(p));
  
    public static final DeferredHolder<Block, Block> BLAZEGOLD_FLUID = registerItemBlock(Constants.BLAZEGOLD.FLUID,  p -> new BlazeGoldFluidGenBlock(p));
   
    public static final DeferredHolder<Block, Block> CELESTIGEM_FLUID = registerItemBlock(Constants.CELESTIGEM.FLUID,  p -> new CelestigemFluidGenBlock(p));
   
    public static final DeferredHolder<Block, Block> ECLIPSE_ALLOY_FLUID = registerItemBlock(Constants.ECLIPSE_ALLOY.FLUID,  p -> new EclipseAlloyFluidGenBlock(p));

    public static DeferredHolder<Block, Block> registerItemBlock(String blockname,
            Function<BlockBehaviour.Properties, ? extends Block> sup) {
        DeferredHolder<Block, Block> block = zBlockItem.registerBlock(blockname, sup);
        zItems.zBlockItem.registerSimpleBlockItem(block);
        return block;
    }

}
