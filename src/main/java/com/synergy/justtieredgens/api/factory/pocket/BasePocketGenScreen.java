package com.synergy.justtieredgens.api.factory.pocket;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.FuelCanister;
import com.direwolf20.justdirethings.common.items.PocketGenerator;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.direwolf20.justdirethings.util.MiscTools;
import com.mojang.blaze3d.platform.InputConstants;
import com.synergy.justtieredgens.api.Image;
import com.synergy.justtieredgens.api.x;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

public abstract class BasePocketGenScreen extends AbstractContainerScreen<BasePocketGenGUI> {

    public static final ResourceLocation GUI_POCKET_GENERATOR = x.rl(JustDireThings.MODID,
            "textures/gui/pocketgenerator.png");

    protected final BasePocketGenGUI container;
    private ItemStack item;
    private IEnergyStorage energyStorage;

    private Player player;

    public BasePocketGenScreen(BasePocketGenGUI gui, Inventory inv, Component name) {
        super(gui, inv, name);
        this.container = gui;
        this.item = gui.getPocketGenerator();// cannot be replaced or will not update!
        this.player = inv.player;
        this.energyStorage = item.getCapability(Capabilities.EnergyStorage.ITEM);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.render(graphics, mouseX, mouseY, partialTicks);
        renderTooltip(graphics, mouseX, mouseY);
        // require player or will not update!
        this.item = player.getMainHandItem();

        if (energyStorage != null && MiscTools.inBounds(leftPos + 7, topPos + 7, 18, 73, mouseX, mouseY)) {

            int counter = item.getOrDefault(JustDireDataComponents.POCKETGEN_COUNTER, 0);

            var feBurnPerTick = (item.getItem() instanceof PocketGenerator p)
                    ? p.getFePerFuelTick() * p.getBurnSpeedMultiplier(item)
                    : 0;

            List<Component> lines = new ArrayList<>();

            lines.add(
                    (hasShiftDown()
                            ? Component.translatable("justdirethings.screen.energy",
                                    MagicHelpers.formatted(energyStorage.getEnergyStored()),
                                    MagicHelpers.withSuffix(energyStorage.getMaxEnergyStored()))
                            : Component.translatable("justdirethings.screen.energy",
                                    MagicHelpers.withSuffix(energyStorage.getEnergyStored()),
                                    MagicHelpers.withSuffix(energyStorage.getMaxEnergyStored())))

            );

            lines.add(counter <= 0
                    ? Component.translatable("justdirethings.screen.no_fuel")
                    : Component.translatable("justdirethings.screen.burn_time", MagicHelpers.ticksInSeconds(counter)));

            lines.add(counter > 0
                    ? Component.translatable("justdirethings.screen.fepertick", MagicHelpers.formatted(feBurnPerTick))
                    : Component.translatable("justdirethings.screen.fepertick", MagicHelpers.formatted(0)));

            graphics.renderTooltip(font, lines, Optional.empty(), mouseX, mouseY);
        }
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {

    }

    @Override
    public void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {

        graphics.blit(
                GUI_POCKET_GENERATOR,
                (this.width - this.imageWidth) / 2,
                (this.height - this.imageHeight) / 2,
                0.0F, 0.0F,
                this.imageWidth, this.imageHeight,
                256, 256);

        // see above :p
        this.item = player.getMainHandItem();

        if (item.isEmpty() || !(item.getItem() instanceof PocketGenerator))
            return;

        this.energyStorage = item.getCapability(Capabilities.EnergyStorage.ITEM);

        if (energyStorage == null)
            return;

        int maxBurn = item.getOrDefault(JustDireDataComponents.POCKETGEN_MAXBURN, 0);
        int counter = item.getOrDefault(JustDireDataComponents.POCKETGEN_COUNTER, 0);

        if (maxBurn > 0) {
            int remaining = (counter * 13) / maxBurn;

            graphics.blit(
                    GUI_POCKET_GENERATOR,
                    leftPos + 80, topPos + 30 - remaining,
                    176, 13 - remaining,
                    14, remaining + 1,
                    256, 256);
        }

        int maxEnergy = energyStorage.getMaxEnergyStored();

        if (maxEnergy > 0) {

            int remaining = (energyStorage.getEnergyStored() * 70) / maxEnergy;
            graphics.blit(
                    GUI_POCKET_GENERATOR,
                    leftPos + 8, topPos + 78 - remaining,
                    176, 84 - remaining,
                    16, remaining + 1,
                    256, 256);
        }

        Image.of()
                .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                .size(16, 16)
                .offset(getGuiLeft() + 158, getGuiTop() + 4)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        super.onClose();
    }



    @Override
    protected void renderTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {

            var fuelStack = this.hoveredSlot.getItem();

                if (fuelStack.getBurnTime(RecipeType.SMELTING) > 0) {

                    var fuelBurnMultiplier = getFuelValueFromItem(fuelStack);

                    List<Component> tip = new ArrayList<>(this.getTooltipFromContainerItem(fuelStack));

                    tip.add(Component
                            .translatable(JustDireThings.MODID + ".screen.burnspeedmultiplier", fuelBurnMultiplier)
                            .withStyle(ChatFormatting.RED));

                    graphics.renderTooltip(this.font, tip, fuelStack.getTooltipImage(), fuelStack, mouseX,
                            mouseY);
                    return;
                }
        }
        super.renderTooltip(graphics, mouseX, mouseY);
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

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        InputConstants.Key mouseKey = InputConstants.getKey(keyCode, scanCode);
        if (keyCode == 256 || minecraft.options.keyInventory.isActiveAndMatches(mouseKey)) {
            onClose();

            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseClicked(double x, double y, int btn) {
        return super.mouseClicked(x, y, btn);
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double pScrollX, double pScrollY) {
        return super.mouseScrolled(mouseX, mouseY, pScrollX, pScrollY);
    }

}