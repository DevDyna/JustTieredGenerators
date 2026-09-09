package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.devdyna.cakesticklib.api.RegistryUtils;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

public class zTags {

    public static void register(IEventBus bus) {
        zTags.Blocks.register(bus);
        zTags.Items.register(bus);
        zTags.Entities.register(bus);
        zTags.Biomes.register(bus);
    }

    public class Blocks {

        public static void register(IEventBus bus) {
        }

        public static final TagKey<Block> SOLID_GENERATORS = RegistryUtils.tagBlock(MODULE_ID, "tiered/solid");
        public static final TagKey<Block> FLUID_GENERATORS = RegistryUtils.tagBlock(MODULE_ID, "tiered/fluid");

    }

    public class Items {

        public static void register(IEventBus bus) {

        }

        public static final TagKey<Item> SOLID_GENERATORS = RegistryUtils.tagItem(MODULE_ID, "tiered/solid");
        public static final TagKey<Item> FLUID_GENERATORS = RegistryUtils.tagItem(MODULE_ID, "tiered/fluid");
        public static final TagKey<Item> POCKET_GENERATORS = RegistryUtils.tagItem(MODULE_ID, "tiered/pocket");

    }

    public class Biomes {

        public static void register(IEventBus bus) {
        }

    }

    public class Entities {

        public static void register(IEventBus bus) {

        }

    }
}