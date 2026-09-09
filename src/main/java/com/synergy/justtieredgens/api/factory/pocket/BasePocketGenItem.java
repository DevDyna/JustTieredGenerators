package com.synergy.justtieredgens.api.factory.pocket;

import com.direwolf20.justdirethings.common.items.PocketGenerator;
import com.direwolf20.justdirethings.setup.Config;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class BasePocketGenItem extends PocketGenerator {

    public BasePocketGenItem(Properties p) {
        super(p.stacksTo(1));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        var item = player.getItemInHand(hand);

        if (level.isClientSide())
            return InteractionResult.SUCCESS.heldItemTransformedTo(item);

        if (!player.isShiftKeyDown())
            player.openMenu(new SimpleMenuProvider((id, inv, p) -> getMenu(id, inv, item), Component.empty()),
                    (buf -> ItemStack.OPTIONAL_STREAM_CODEC.encode(buf, item)));

        return InteractionResult.SUCCESS.heldItemTransformedTo(item);
    }

    public abstract <T extends BasePocketGenGUI> T getMenu(int id,Inventory inv,ItemStack item);

    public abstract int getMaxEnergy();

    public abstract int getBurnSpeed();

    public abstract int getFEPerTick();

    public abstract int getFePerFuelTick();

    @Override
    public int getBurnSpeedMultiplier(ItemStack i) {
        return getBurnSpeed() * (super.getBurnSpeedMultiplier(i) / Config.POCKET_GENERATOR_BURN_SPEED_MULTIPLIER.get());
    }
}
