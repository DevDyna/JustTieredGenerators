package com.synergy.justtieredgens.api.factory.pocket;

import com.direwolf20.justdirethings.common.containers.PocketGeneratorContainer;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseContainer;
import com.direwolf20.justdirethings.common.containers.slots.FuelSlot;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.items.IItemHandler;

public abstract class BasePocketGenGUI extends BaseContainer {
   public static final int SLOTS = PocketGeneratorContainer.SLOTS;
   protected ComponentItemHandler handler;
   private ItemStack item;

   public BasePocketGenGUI(MenuType<?> menu, int id, Inventory inv, Player p, RegistryFriendlyByteBuf data) {
      this(menu, id, inv, p, ItemStack.OPTIONAL_STREAM_CODEC.decode(data));
   }

   public BasePocketGenGUI(MenuType<?> menu, int id, Inventory inv, Player p, ItemStack item) {
      super(menu, id);
      this.item = item;
      this.handler = new ComponentItemHandler(item, JustDireDataComponents.ITEMSTACK_HANDLER.get(), 1);

      this.addGeneratorSlots(handler, 0, 80, 35, 1, 18);
      this.addPlayerSlots(inv, 8, 84);
   }

   public ItemStack getPocketGenerator() {
      return item;
   }

   protected int addGeneratorSlots(IItemHandler handler, int index, int x, int y, int amount, int dx) {
      for (int i = 0; i < amount; ++i) {
         this.addSlot(new FuelSlot(handler, index, x, y));
         x += dx;
         ++index;
      }

      return index;
   }

   @Override
   public ItemStack quickMoveStack(Player playerIn, int index) {
      var itemstack = ItemStack.EMPTY;
      var slot = this.slots.get(index);
      if (slot.hasItem()) {

         var currentStack = slot.getItem();

         if (index < 1 && !this.moveItemStackTo(currentStack, 1, 37, true))
            return ItemStack.EMPTY;

         if (index >= 1 && !this.moveItemStackTo(currentStack, 0, 1, false))
            return ItemStack.EMPTY;

         if (currentStack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
         } else {
            slot.set(currentStack);
            slot.setChanged();
         }

         if (currentStack.getCount() == itemstack.getCount())
            return ItemStack.EMPTY;

         slot.onTake(playerIn, currentStack);
      }

      return itemstack;
   }

   @Override
   public void removed(Player playerIn) {
      super.removed(playerIn);
   }

   @Override
   public boolean stillValid(Player p) {
      return p.getMainHandItem().is(item.getItem());
   }
}