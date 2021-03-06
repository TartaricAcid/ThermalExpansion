package cofh.thermalexpansion.plugins.jei.crafting.furnace;

import cofh.core.util.helpers.ItemHelper;
import cofh.core.util.helpers.StringHelper;
import cofh.thermalexpansion.block.machine.BlockMachine;
import cofh.thermalexpansion.item.ItemAugment;
import cofh.thermalexpansion.plugins.jei.RecipeUidsTE;
import cofh.thermalexpansion.util.managers.machine.FurnaceManager;
import cofh.thermalexpansion.util.managers.machine.FurnaceManager.FurnaceRecipe;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class FurnaceRecipeCategoryOre extends FurnaceRecipeCategory {

	public static void initialize(IModRegistry registry) {

		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

		registry.addRecipes(getRecipes(guiHelper), RecipeUidsTE.FURNACE_ORE);
		registry.addRecipeCatalyst(ItemAugment.machineFurnaceOre, RecipeUidsTE.FURNACE_ORE);
		registry.addRecipeCatalyst(BlockMachine.machineFurnace, RecipeUidsTE.FURNACE_ORE);
	}

	public static List<FurnaceRecipeWrapper> getRecipes(IGuiHelper guiHelper) {

		List<FurnaceRecipeWrapper> recipes = new ArrayList<>();

		for (FurnaceRecipe recipe : FurnaceManager.getRecipeList()) {
			if (ItemHelper.isOre(recipe.getInput())) {
				recipes.add(new FurnaceRecipeWrapper(guiHelper, recipe, RecipeUidsTE.FURNACE_ORE));
			}
		}
		return recipes;
	}

	public FurnaceRecipeCategoryOre(IGuiHelper guiHelper) {

		super(guiHelper);

		localizedName = StringHelper.localize("item.thermalexpansion.augment.machineFurnaceOre.name");
	}

	@Nonnull
	@Override
	public String getUid() {

		return RecipeUidsTE.FURNACE_ORE;
	}

}
