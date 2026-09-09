package com.synergy.justtieredgens.mixin;

import com.direwolf20.justdirethings.client.screens.PocketGeneratorScreen;
import com.synergy.justtieredgens.api.Image;

import net.minecraft.client.gui.GuiGraphics;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PocketGeneratorScreen.class)
public class PocketGeneratorJEIScreenMixin {

        @Inject(method = "renderBg", at = @At("TAIL"))
        private void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY,
                        CallbackInfo ci) {

                var gui = (PocketGeneratorScreen) (Object) this;

                var screen = gui;

                int x = screen.getGuiLeft();
                int y = screen.getGuiTop();

                Image.of()
                                .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                                .size(16, 16)
                                .offset(x + 158, y + 4)
                                .sizeTexture(16, 16)
                                .render(graphics);

        }
}