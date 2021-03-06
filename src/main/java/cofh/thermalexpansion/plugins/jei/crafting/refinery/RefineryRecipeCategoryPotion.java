package cofh.thermalexpansion.plugins.jei.crafting.refinery;

import cofh.core.util.helpers.StringHelper;
import cofh.thermalexpansion.block.machine.BlockMachine;
import cofh.thermalexpansion.item.ItemAugment;
import cofh.thermalexpansion.plugins.jei.RecipeUidsTE;
import cofh.thermalexpansion.util.managers.machine.RefineryManager;
import cofh.thermalexpansion.util.managers.machine.RefineryManager.RefineryRecipe;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RefineryRecipeCategoryPotion extends RefineryRecipeCategory {

	public static void initialize(IModRegistry registry) {

		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

		registry.addRecipes(getRecipes(guiHelper), RecipeUidsTE.REFINERY_POTION);
		registry.addRecipeCatalyst(ItemAugment.machineRefineryPotion, RecipeUidsTE.REFINERY_POTION);
		registry.addRecipeCatalyst(BlockMachine.machineRefinery, RecipeUidsTE.REFINERY_POTION);
	}

	public static List<RefineryRecipeWrapper> getRecipes(IGuiHelper guiHelper) {

		List<RefineryRecipeWrapper> recipes = new ArrayList<>();

		for (RefineryRecipe recipe : RefineryManager.getRecipeListPotion()) {
			recipes.add(new RefineryRecipeWrapper(guiHelper, recipe, RecipeUidsTE.REFINERY_POTION));
		}
		return recipes;
	}

	public RefineryRecipeCategoryPotion(IGuiHelper guiHelper) {

		super(guiHelper);

		localizedName = StringHelper.localize("item.thermalexpansion.augment.machineRefineryPotion.name");
	}

	@Nonnull
	@Override
	public String getUid() {

		return RecipeUidsTE.REFINERY_POTION;
	}

}
