package com.synergy.justtieredgens.compat.jei;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.direwolf20.justdirethings.client.screens.GeneratorFluidT1Screen;
import com.direwolf20.justdirethings.client.screens.GeneratorT1Screen;
import com.direwolf20.justdirethings.client.screens.PocketGeneratorScreen;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Registration;
import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.api.x;
import com.synergy.justtieredgens.compat.jei.categories.fluid_gen.*;

import com.synergy.justtieredgens.compat.jei.categories.pocket_gen.*;

import com.synergy.justtieredgens.compat.jei.categories.solid_gen.*;

import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.compat.jei.utils.FuelUtils;
import com.synergy.justtieredgens.init.builders.fluid_gen.blazegold.BlazeGoldFluidGenScreen;
import com.synergy.justtieredgens.init.builders.fluid_gen.celestigem.CelestigemFluidGenScreen;
import com.synergy.justtieredgens.init.builders.fluid_gen.eclipse_alloy.EclipseAlloyFluidGenScreen;
import com.synergy.justtieredgens.init.builders.pocket_generators.blazegold.BlazeGoldPocketGenScreen;
import com.synergy.justtieredgens.init.builders.pocket_generators.celestigem.CelestigemPocketGenScreen;
import com.synergy.justtieredgens.init.builders.pocket_generators.eclipse_alloy.EclipseAlloyPocketGenScreen;
import com.synergy.justtieredgens.init.builders.solid_gen.blazegold.BlazeGoldCoalGenScreen;
import com.synergy.justtieredgens.init.builders.solid_gen.celestigem.CelestigemCoalGenScreen;
import com.synergy.justtieredgens.init.builders.solid_gen.eclipse_alloy.EclipseAlloyCoalGenScreen;
import com.synergy.justtieredgens.init.types.zBlocks;
import com.synergy.justtieredgens.init.types.zItems;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class PluginJEI implements IModPlugin {

        @Override
        public ResourceLocation getPluginUid() {
                return x.rl(MODULE_ID, "jei_plugin");
        }

        @Override
        public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {
                r.addRecipeCatalysts(FerricorePocketGenCategory.TYPE, Registration.Pocket_Generator.get());

                r.addRecipeCatalysts(BlazeGoldPocketGenCategory.TYPE, zItems.BLAZEGOLD_POCKET_GEN.get());
                r.addRecipeCatalysts(CelestigemPocketGenCategory.TYPE, zItems.CELESTIGEM_POCKET_GEN.get());
                r.addRecipeCatalysts(EclipseAlloyPocketGenCategory.TYPE, zItems.ECLIPSE_ALLOY_POCKET_GEN.get());

                r.addRecipeCatalysts(FerricoreCoalGenCategory.TYPE, Registration.GeneratorT1_ITEM.get());
                r.addRecipeCatalysts(BlazeGoldCoalGenCategory.TYPE, zBlocks.BLAZEGOLD_COAL.get());
                r.addRecipeCatalysts(CelestigemCoalGenCategory.TYPE, zBlocks.CELESTIGEM_COAL.get());
                r.addRecipeCatalysts(EclipseAlloyCoalGenCategory.TYPE, zBlocks.ECLIPSE_ALLOY_COAL.get());

                r.addRecipeCatalysts(FerricoreFluidGenCategory.TYPE, Registration.GeneratorFluidT1_ITEM.get());
                r.addRecipeCatalysts(BlazeGoldFluidGenCategory.TYPE, zBlocks.BLAZEGOLD_FLUID.get());
                r.addRecipeCatalysts(CelestigemFluidGenCategory.TYPE, zBlocks.CELESTIGEM_FLUID.get());
                r.addRecipeCatalysts(EclipseAlloyFluidGenCategory.TYPE, zBlocks.ECLIPSE_ALLOY_FLUID.get());

        }

        @Override
        public void registerCategories(IRecipeCategoryRegistration r) {

                IGuiHelper h = r.getJeiHelpers().getGuiHelper();

                r.addRecipeCategories(

                                new FerricoreCoalGenCategory(h),
                                new BlazeGoldCoalGenCategory(h),
                                new CelestigemCoalGenCategory(h),
                                new EclipseAlloyCoalGenCategory(h),

                                new FerricoreFluidGenCategory(h),
                                new BlazeGoldFluidGenCategory(h),
                                new CelestigemFluidGenCategory(h),
                                new EclipseAlloyFluidGenCategory(h),

                                new FerricorePocketGenCategory(h),
                                new BlazeGoldPocketGenCategory(h),
                                new CelestigemPocketGenCategory(h),
                                new EclipseAlloyPocketGenCategory(h)

                );

        }

        @Override
        public void registerRecipes(IRecipeRegistration r) {

                registerCoalFuels(r, FerricorePocketGenCategory.TYPE);
                registerCoalFuels(r, BlazeGoldPocketGenCategory.TYPE);
                registerCoalFuels(r, CelestigemPocketGenCategory.TYPE);
                registerCoalFuels(r, EclipseAlloyPocketGenCategory.TYPE);

                registerCoalFuels(r, FerricoreCoalGenCategory.TYPE);
                registerCoalFuels(r, BlazeGoldCoalGenCategory.TYPE);
                registerCoalFuels(r, CelestigemCoalGenCategory.TYPE);
                registerCoalFuels(r, EclipseAlloyCoalGenCategory.TYPE);

                registerFluidFuels(r, FerricoreFluidGenCategory.TYPE);
                registerFluidFuels(r, BlazeGoldFluidGenCategory.TYPE);
                registerFluidFuels(r, CelestigemFluidGenCategory.TYPE);
                registerFluidFuels(r, EclipseAlloyFluidGenCategory.TYPE);

        }

        @Override
        public void registerGuiHandlers(IGuiHandlerRegistration r) {

                // pocket
                r.addRecipeClickArea(PocketGeneratorScreen.class, 158, 4, 16, 16,
                                FerricorePocketGenCategory.TYPE);

                r.addRecipeClickArea(BlazeGoldPocketGenScreen.class, 158, 4, 16, 16,
                                BlazeGoldPocketGenCategory.TYPE);

                r.addRecipeClickArea(CelestigemPocketGenScreen.class, 158, 4, 16, 16,
                                CelestigemPocketGenCategory.TYPE);

                r.addRecipeClickArea(EclipseAlloyPocketGenScreen.class, 158, 4, 16, 16,
                                EclipseAlloyPocketGenCategory.TYPE);

                // solid
                r.addRecipeClickArea(GeneratorT1Screen.class, 158, -22, 16, 16,
                                FerricoreCoalGenCategory.TYPE);

                r.addRecipeClickArea(BlazeGoldCoalGenScreen.class, 158, -22, 16, 16,
                                BlazeGoldCoalGenCategory.TYPE);

                r.addRecipeClickArea(CelestigemCoalGenScreen.class, 158, -22, 16, 16,
                                CelestigemCoalGenCategory.TYPE);

                r.addRecipeClickArea(EclipseAlloyCoalGenScreen.class, 158, -22, 16, 16,
                                EclipseAlloyCoalGenCategory.TYPE);

                // fluid
                r.addRecipeClickArea(GeneratorFluidT1Screen.class, 158, -22, 16, 16,
                                FerricoreFluidGenCategory.TYPE);

                r.addRecipeClickArea(BlazeGoldFluidGenScreen.class, 158, -22, 16, 16,
                                BlazeGoldFluidGenCategory.TYPE);

                r.addRecipeClickArea(CelestigemFluidGenScreen.class, 158, -22, 16, 16,
                                CelestigemFluidGenCategory.TYPE);

                r.addRecipeClickArea(EclipseAlloyFluidGenScreen.class, 158, -22, 16, 16,
                                EclipseAlloyFluidGenCategory.TYPE);

        }

        private void registerCoalFuels(IRecipeRegistration r, RecipeType<FuelRecords.Items> cat_type) {
                Map<Integer, List<ItemStack>> fuels = new HashMap<>();

                for (ItemStack stack : FuelUtils.getAllSolidFuels()) {
                        int burnTime = stack.getBurnTime(null);

                        if (stack.getItem() instanceof Coal_T1 ||
                                        (stack.getItem() instanceof BlockItem bi
                                                        && bi.getBlock() instanceof CoalBlock_T1)) {
                                r.addRecipes(cat_type,
                                                List.of(new FuelRecords.Items(List.of(stack))));
                                continue;
                        }

                        if (burnTime > 0)
                                fuels.computeIfAbsent(burnTime, k -> new ArrayList<>()).add(stack);

                }

                if (!Config.ENABLE_ALL_JEI_FUELS.get()) {
                        fuels.entrySet().stream()
                                        .sorted(Map.Entry.<Integer, List<ItemStack>>comparingByKey().reversed())
                                        .forEach(entry -> r.addRecipes(cat_type,
                                                        List.of(new FuelRecords.Items(entry.getValue()))));
                }
        }

        private void registerFluidFuels(IRecipeRegistration r, RecipeType<FuelRecords.Fluids> cat_type) {
                FuelUtils.getAllRefinedFuels().stream()
                                .collect(Collectors.groupingBy(f -> ((RefinedFuel) f.getFluid()).fePerMb()))
                                .entrySet().stream()
                                .sorted(Map.Entry.comparingByKey())
                                .forEach(f -> r.addRecipes(cat_type, List.of(new FuelRecords.Fluids(f.getValue()))));

        }

}
