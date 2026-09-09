package com.synergy.justtieredgens.mixin;

import com.direwolf20.justdirethings.client.screens.GeneratorFluidT1Screen;
import com.direwolf20.justdirethings.client.screens.GeneratorT1Screen;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.synergy.justtieredgens.api.Image;

import net.minecraft.client.gui.GuiGraphics;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BaseMachineScreen.class)
public class GeneratorsJEIScreenMixin {

        @Inject(method = "renderBg", at = @At("TAIL"))
        private void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY, CallbackInfo ci) {

                @SuppressWarnings("rawtypes")
                var gui = (BaseMachineScreen) (Object) this;

                if (gui instanceof GeneratorT1Screen || gui instanceof GeneratorFluidT1Screen) {

                        var screen = gui;

                        int x = screen.getGuiLeft();
                        int y = screen.getGuiTop();

                        Image.of()
                                        .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                                        .size(16, 16)
                                        .offset(x + 158, y - 22)
                                        .sizeTexture(16, 16)
                                        .render(guiGraphics);
                }

        }
}
