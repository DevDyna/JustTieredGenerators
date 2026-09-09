package com.synergy.justtieredgens.mixin;

import com.devdyna.cakesticklib.api.gui.ImageGui;
import com.direwolf20.justdirethings.client.screens.PocketGeneratorScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PocketGeneratorScreen.class)
public class PocketGeneratorJEIScreenMixin {

        @Inject(method = "extractBackground", at = @At("TAIL"))
        private void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks,
                        CallbackInfo ci) {

                var gui = (PocketGeneratorScreen) (Object) this;

                var screen = gui;

                int x = screen.getLeftPos();
                int y = screen.getTopPos();

                ImageGui.of()
                                .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                                .size(16, 16)
                                .offset(x + 158, y +4)
                                .sizeTexture(16, 16)
                                .render(graphics);

        }
}
