package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.function.Function;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.builders.generators.blazegold.SolidBlazeGoldGenBlock;

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

    public static final DeferredHolder<Block, Block> BLAZEGOLD_COAL = registerItemBlock(Constants.BLAZEGOLD.COAL,
            p -> new SolidBlazeGoldGenBlock(p));

    public static DeferredHolder<Block, Block> registerItemBlock(String blockname,
            Function<BlockBehaviour.Properties, ? extends Block> sup) {
        DeferredHolder<Block, Block> block = zBlockItem.registerBlock(blockname, sup);
        zItems.zBlockItem.registerSimpleBlockItem(block);
        return block;
    }

}
