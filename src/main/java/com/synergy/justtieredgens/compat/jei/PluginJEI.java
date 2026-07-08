package com.synergy.justtieredgens.compat.jei;

import static com.synergy.justtieredgens.Main.MODULE_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.synergy.justtieredgens.Config;
import com.synergy.justtieredgens.compat.jei.categories.coal.BlazeGoldCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.coal.CelestigemCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.coal.EclipseAlloyCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.coal.FerricoreCoalGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.fluid.BlazeGoldFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.fluid.CelestigemFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.fluid.EclipseAlloyFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.categories.fluid.FerricoreFluidGenCategory;
import com.synergy.justtieredgens.compat.jei.utils.FuelRecords;
import com.synergy.justtieredgens.compat.jei.utils.FuelUtils;
import com.synergy.justtieredgens.init.types.zBlocks;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class PluginJEI implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return x.rl(MODULE_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {
        r.addCraftingStation(FerricoreCoalGenCategory.TYPE, JDTRegistration.GeneratorT1_ITEM.get());
        r.addCraftingStation(BlazeGoldCoalGenCategory.TYPE, zBlocks.BLAZEGOLD_COAL.get());
        r.addCraftingStation(CelestigemCoalGenCategory.TYPE, zBlocks.CELESTIGEM_COAL.get());
        r.addCraftingStation(EclipseAlloyCoalGenCategory.TYPE, zBlocks.ECLIPSE_ALLOY_COAL.get());

        r.addCraftingStation(FerricoreFluidGenCategory.TYPE, JDTRegistration.GeneratorFluidT1_ITEM.get());
        r.addCraftingStation(BlazeGoldFluidGenCategory.TYPE, zBlocks.BLAZEGOLD_FLUID.get());
        r.addCraftingStation(CelestigemFluidGenCategory.TYPE, zBlocks.CELESTIGEM_FLUID.get());
        r.addCraftingStation(EclipseAlloyFluidGenCategory.TYPE, zBlocks.ECLIPSE_ALLOY_FLUID.get());

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
                new EclipseAlloyFluidGenCategory(h)

        );

    }

    @Override
    public void registerRecipes(IRecipeRegistration r) {

        registerCoalFuels(r, FerricoreCoalGenCategory.TYPE);
        registerCoalFuels(r, BlazeGoldCoalGenCategory.TYPE);
        registerCoalFuels(r, CelestigemCoalGenCategory.TYPE);
        registerCoalFuels(r, EclipseAlloyCoalGenCategory.TYPE);

        registerFluidFuels(r, FerricoreFluidGenCategory.TYPE);
        registerFluidFuels(r, BlazeGoldFluidGenCategory.TYPE);
        registerFluidFuels(r, CelestigemFluidGenCategory.TYPE);
        registerFluidFuels(r, EclipseAlloyFluidGenCategory.TYPE);

    }

    private void registerCoalFuels(IRecipeRegistration r, IRecipeType<FuelRecords.Items> cat_type) {
        Map<Integer, List<ItemStack>> fuels = new HashMap<>();

        for (ItemStack stack : FuelUtils.getAllSolidFuels()) {
            int burnTime = stack.getBurnTime(null, Minecraft.getInstance().level.fuelValues());

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

    private void registerFluidFuels(IRecipeRegistration r, IRecipeType<FuelRecords.Fluids> cat_type) {
        FuelUtils.getAllRefinedFuels().stream()
                .collect(Collectors.groupingBy(f -> ((RefinedFuel) f.getFluid()).fePerMb()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(f -> r.addRecipes(cat_type, List.of(new FuelRecords.Fluids(f.getValue()))));

    }

}
