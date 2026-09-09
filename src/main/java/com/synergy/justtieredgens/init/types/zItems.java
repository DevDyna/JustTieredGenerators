package com.synergy.justtieredgens.init.types;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import com.synergy.justtieredgens.Constants;
import com.synergy.justtieredgens.init.builders.pocket_generators.blazegold.BlazeGoldPocketGenItem;
import com.synergy.justtieredgens.init.builders.pocket_generators.celestigem.CelestigemPocketGenItem;
import com.synergy.justtieredgens.init.builders.pocket_generators.eclipse_alloy.EclipseAlloyPocketGenItem;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zItems {

  public static void register(IEventBus bus) {
    zBlockItem.register(bus);
    zItem.register(bus);
  }

  public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(MODULE_ID);
  public static final DeferredRegister.Items zItem = DeferredRegister.createItems(MODULE_ID);

  public static final DeferredHolder<Item, BlazeGoldPocketGenItem> BLAZEGOLD_POCKET_GEN = zItem
      .registerItem(Constants.BLAZEGOLD.POCKET, BlazeGoldPocketGenItem::new);

  public static final DeferredHolder<Item, CelestigemPocketGenItem> CELESTIGEM_POCKET_GEN = zItem
      .registerItem(Constants.CELESTIGEM.POCKET, CelestigemPocketGenItem::new);

  public static final DeferredHolder<Item, EclipseAlloyPocketGenItem> ECLIPSE_ALLOY_POCKET_GEN = zItem
      .registerItem(Constants.ECLIPSE_ALLOY.POCKET, EclipseAlloyPocketGenItem::new);

}
