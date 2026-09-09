package com.synergy.justtieredgens.api.factory.pocket;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devdyna.cakesticklib.api.gui.ImageGui;
import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.FuelCanister;
import com.direwolf20.justdirethings.common.items.PocketGenerator;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.direwolf20.justdirethings.util.MiscTools;
import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;

public abstract class BasePocketGenScreen extends AbstractContainerScreen<BasePocketGenGUI> {

    public static final Identifier GUI_POCKET_GENERATOR = x.rl(JustDireThings.MODID,
            "textures/gui/pocketgenerator.png");

    protected final BasePocketGenGUI container;
    private ItemStack item;
    private EnergyHandler energyStorage;

    private Player player;

    public BasePocketGenScreen(BasePocketGenGUI gui, Inventory inv, Component name) {
        super(gui, inv, name);
        this.container = gui;
        this.item = gui.getPocketGenerator();// cannot be replaced or will not update!
        this.player = inv.player;
        this.energyStorage = item.getCapability(Capabilities.Energy.ITEM, ItemAccess.forStack(item));
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        super.extractContents(graphics, mouseX, mouseY, partialTicks);

        // require player or will not update!
        this.item = player.getActiveItem();

        if (energyStorage != null && MiscTools.inBounds(leftPos + 7, topPos + 7, 18, 73, mouseX, mouseY)) {

            int counter = item.getOrDefault(JustDireDataComponents.POCKETGEN_COUNTER, 0);

            var feBurnPerTick = (item.getItem() instanceof PocketGenerator p)
                    ? p.getFePerFuelTick() * p.getBurnSpeedMultiplier(item)
                    : 0;

            List<Component> lines = new ArrayList<>();

            lines.add(
                    (Minecraft.getInstance().hasShiftDown()
                            ? Component.translatable("justdirethings.screen.energy",
                                    MagicHelpers.formatted(energyStorage.getAmountAsInt()),
                                    MagicHelpers.withSuffix(energyStorage.getCapacityAsInt()))
                            : Component.translatable("justdirethings.screen.energy",
                                    MagicHelpers.withSuffix(energyStorage.getAmountAsInt()),
                                    MagicHelpers.withSuffix(energyStorage.getCapacityAsInt())))

            );

            lines.add(counter <= 0
                    ? Component.translatable("justdirethings.screen.no_fuel")
                    : Component.translatable("justdirethings.screen.burn_time", MagicHelpers.ticksInSeconds(counter)));

            lines.add(counter > 0
                    ? Component.translatable("justdirethings.screen.fepertick", MagicHelpers.formatted(feBurnPerTick))
                    : Component.translatable("justdirethings.screen.fepertick", MagicHelpers.formatted(0)));

            graphics.setTooltipForNextFrame(font, lines, Optional.empty(), mouseX, mouseY);
        }
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        super.extractBackground(graphics, mouseX, mouseY, partialTicks);

        graphics.blit(RenderPipelines.GUI_TEXTURED,
                GUI_POCKET_GENERATOR,
                (this.width - this.imageWidth) / 2,
                (this.height - this.imageHeight) / 2,
                0.0F, 0.0F,
                this.imageWidth, this.imageHeight,
                256, 256);

        // see above :p
        this.item = player.getActiveItem();

        if (item.isEmpty() || !(item.getItem() instanceof PocketGenerator))
            return;

        this.energyStorage = item.getCapability(Capabilities.Energy.ITEM, ItemAccess.forStack(item));

        if (energyStorage == null)
            return;

        int maxBurn = item.getOrDefault(JustDireDataComponents.POCKETGEN_MAXBURN, 0);
        int counter = item.getOrDefault(JustDireDataComponents.POCKETGEN_COUNTER, 0);

        if (maxBurn > 0) {
            int remaining = (counter * 13) / maxBurn;

            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    GUI_POCKET_GENERATOR,
                    leftPos + 80, topPos + 30 - remaining,
                    176, 13 - remaining,
                    14, remaining + 1,
                    256, 256);
        }

        int maxEnergy = energyStorage.getCapacityAsInt();

        if (maxEnergy > 0) {

            int remaining = (energyStorage.getAmountAsInt() * 70) / maxEnergy;
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    GUI_POCKET_GENERATOR,
                    leftPos + 8, topPos + 78 - remaining,
                    176, 84 - remaining,
                    16, remaining + 1,
                    256, 256);
        }

        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                .size(16, 16)
                .offset(getLeftPos() + 158, getTopPos() + 4)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(KeyEvent event) {
        if (event.key() == 256 || minecraft.options.keyInventory.isActiveAndMatches(InputConstants.getKey(event))) {
            onClose();
            return true;
        }
        return super.keyPressed(event);
    }

    @Override
    protected void extractTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {

            var fuelStack = this.hoveredSlot.getItem();
            var fuelValues = minecraft != null && minecraft.level != null ? minecraft.level.fuelValues() : null;

            if (fuelValues != null)
                if (fuelStack.getBurnTime(RecipeType.SMELTING, fuelValues) > 0) {

                    var fuelBurnMultiplier = getFuelValueFromItem(fuelStack);

                    List<Component> tip = new ArrayList<>(this.getTooltipFromContainerItem(fuelStack));

                    tip.add(Component
                            .translatable(JustDireThings.MODID + ".screen.burnspeedmultiplier", fuelBurnMultiplier)
                            .withStyle(ChatFormatting.RED));

                    graphics.setTooltipForNextFrame(this.font, tip, fuelStack.getTooltipImage(), fuelStack, mouseX,
                            mouseY);
                    return;
                }
        }
        super.extractTooltip(graphics, mouseX, mouseY);
    }

    public int getFuelValueFromItem(ItemStack i) {

        if (i.getItem() instanceof Coal_T1 coal)
            return getMultiplier() * coal.getBurnSpeedMultiplier();

        if (i.getItem() instanceof BlockItem bi
                && bi.getBlock() instanceof CoalBlock_T1 coalBlock)
            return getMultiplier() * coalBlock.getBurnSpeedMultiplier();

        if (i.getItem() instanceof FuelCanister)
            return getMultiplier() * FuelCanister.getBurnSpeedMultiplier(i);

        return getMultiplier();
    }

    public abstract int getMultiplier();

}
