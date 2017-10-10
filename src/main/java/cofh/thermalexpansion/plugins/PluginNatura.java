package cofh.thermalexpansion.plugins;

import cofh.core.util.ModPlugin;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.ThermalExpansion;
import cofh.thermalexpansion.util.managers.TapperManager;
import cofh.thermalexpansion.util.managers.machine.InsolatorManager;
import cofh.thermalexpansion.util.managers.machine.InsolatorManager.Type;
import cofh.thermalexpansion.util.managers.machine.TransposerManager;
import cofh.thermalfoundation.init.TFFluids;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class PluginNatura extends ModPlugin {

	public static final String MOD_ID = "natura";
	public static final String MOD_NAME = "Natura";

	public PluginNatura() {

		super(MOD_ID, MOD_NAME);
	}

	/* IInitializer */
	@Override
	public boolean initialize() {

		String category = "Plugins";
		String comment = "If TRUE, support for " + MOD_NAME + " is enabled.";
		enable = Loader.isModLoaded(MOD_ID) && ThermalExpansion.CONFIG.getConfiguration().getBoolean(MOD_NAME, category, true, comment);

		if (!enable) {
			return false;
		}
		return !error;
	}

	@Override
	public boolean register() {

		if (!enable) {
			return false;
		}
		try {
			ItemStack seedBarley = getItemStack("overworld_seeds", 1, 0);
			ItemStack seedCotton = getItemStack("overworld_seeds", 1, 1);

			ItemStack cropRaspberry = getItemStack("edibles", 1, 2);
			ItemStack cropBlueberry = getItemStack("edibles", 1, 3);
			ItemStack cropBlackberry = getItemStack("edibles", 1, 4);
			ItemStack cropMaloberry = getItemStack("edibles", 1, 5);

			ItemStack cropBlightberry = getItemStack("edibles", 1, 6);
			ItemStack cropDuskberry = getItemStack("edibles", 1, 7);
			ItemStack cropSkyberry = getItemStack("edibles", 1, 8);
			ItemStack cropStingberry = getItemStack("edibles", 1, 9);

			ItemStack bushRaspberry = getItemStack("overworld_berrybush_raspberry", 1, 0);
			ItemStack bushBlueberry = getItemStack("overworld_berrybush_blueberry", 1, 0);
			ItemStack bushBlackberry = getItemStack("overworld_berrybush_blackberry", 1, 0);
			ItemStack bushMaloberry = getItemStack("overworld_berrybush_maloberry", 1, 0);

			ItemStack bushBlightberry = getItemStack("nether_berrybush_blightberry", 1, 0);
			ItemStack bushDuskberry = getItemStack("nether_berrybush_duskberry", 1, 0);
			ItemStack bushSkyberry = getItemStack("nether_berrybush_skyberry", 1, 0);
			ItemStack bushStingberry = getItemStack("nether_berrybush_stingberry", 1, 0);

			ItemStack saguaroFruit = getItemStack("saguaro_fruit_item");
			ItemStack saguaroCactus = getItemStack("saguaro", 1, 0);
			ItemStack saguaroCactusBaby = getItemStack("saguaro_baby", 1, 0);

			ItemStack glowshroomGreen = getItemStack("nether_glowshroom", 1, 0);
			ItemStack glowshroomBlue = getItemStack("nether_glowshroom", 1, 1);
			ItemStack glowshroomPurple = getItemStack("nether_glowshroom", 1, 2);

			ItemStack logMaple = getItemStack("overworld_logs", 1, 0);
			ItemStack logSilverbell = getItemStack("overworld_logs", 1, 1);
			ItemStack logAmaranth = getItemStack("overworld_logs", 1, 2);
			ItemStack logTigerwood = getItemStack("overworld_logs", 1, 3);

			ItemStack logWillow = getItemStack("overworld_logs2", 1, 0);
			ItemStack logEucalyptus = getItemStack("overworld_logs2", 1, 1);
			ItemStack logHopseed = getItemStack("overworld_logs2", 1, 2);
			ItemStack logSakura = getItemStack("overworld_logs2", 1, 3);

			ItemStack saplingMaple = getItemStack("overworld_sapling", 1, 0);
			ItemStack saplingSilverbell = getItemStack("overworld_sapling", 1, 1);
			ItemStack saplingAmaranth = getItemStack("overworld_sapling", 1, 2);
			ItemStack saplingTigerwood = getItemStack("overworld_sapling", 1, 3);

			ItemStack saplingWillow = getItemStack("overworld_sapling2", 1, 0);
			ItemStack saplingEucalyptus = getItemStack("overworld_sapling2", 1, 1);
			ItemStack saplingHopseed = getItemStack("overworld_sapling2", 1, 2);
			ItemStack saplingSakura = getItemStack("overworld_sapling2", 1, 3);

			ItemStack saplingGhostwood = getItemStack("nether_sapling", 1, 0);
			ItemStack saplingFusewood = getItemStack("nether_sapling", 1, 1);
			ItemStack saplingDarkwood = getItemStack("nether_sapling", 1, 2);
			ItemStack saplingBloodwood = getItemStack("nether_sapling2", 1, 0);

			ItemStack logGhostwood = getItemStack("nether_logs", 1, 0);
			ItemStack logFusewood = getItemStack("nether_logs", 1, 2);
			ItemStack logDarkwood = getItemStack("nether_logs", 1, 1);
			ItemStack logBloodwood = getItemStack("nether_logs2", 1, 0);

			Block log = getBlock("overworld_logs");
			Block log2 = getBlock("overworld_logs2");

			Block leaves = getBlock("overworld_leaves");
			Block leaves2 = getBlock("overworld_leaves2");

			Fluid seed_oil = FluidRegistry.getFluid("seed.oil");

			/* INSOLATOR */
			{
				InsolatorManager.addDefaultRecipe(bushRaspberry, ItemHelper.cloneStack(cropRaspberry, 2), bushRaspberry, 100);
				InsolatorManager.addDefaultRecipe(bushBlueberry, ItemHelper.cloneStack(cropBlueberry, 2), bushBlueberry, 100);
				InsolatorManager.addDefaultRecipe(bushBlackberry, ItemHelper.cloneStack(cropBlackberry, 2), bushBlackberry, 100);
				InsolatorManager.addDefaultRecipe(bushMaloberry, ItemHelper.cloneStack(cropMaloberry, 2), bushMaloberry, 100);

				InsolatorManager.addDefaultRecipe(bushBlightberry, ItemHelper.cloneStack(cropBlightberry, 2), bushBlightberry, 100, Type.NETHER);
				InsolatorManager.addDefaultRecipe(bushDuskberry, ItemHelper.cloneStack(cropDuskberry, 2), bushDuskberry, 100, Type.NETHER);
				InsolatorManager.addDefaultRecipe(bushSkyberry, ItemHelper.cloneStack(cropSkyberry, 2), bushSkyberry, 100, Type.NETHER);
				InsolatorManager.addDefaultRecipe(bushStingberry, ItemHelper.cloneStack(cropStingberry, 2), bushStingberry, 100, Type.NETHER);

				InsolatorManager.addDefaultRecipe(saguaroFruit, saguaroCactusBaby, ItemStack.EMPTY, 0);
				InsolatorManager.addDefaultRecipe(saguaroCactusBaby, ItemHelper.cloneStack(saguaroFruit, 2), saguaroCactus, 0);

				InsolatorManager.addDefaultRecipe(glowshroomGreen, ItemHelper.cloneStack(glowshroomGreen, 2), ItemStack.EMPTY, 0, Type.NETHER);
				InsolatorManager.addDefaultRecipe(glowshroomBlue, ItemHelper.cloneStack(glowshroomBlue, 2), ItemStack.EMPTY, 0, Type.NETHER);
				InsolatorManager.addDefaultRecipe(glowshroomPurple, ItemHelper.cloneStack(glowshroomPurple, 2), ItemStack.EMPTY, 0, Type.NETHER);

				InsolatorManager.addDefaultTreeRecipe(saplingMaple, ItemHelper.cloneStack(logMaple, 4), saplingMaple, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingSilverbell, ItemHelper.cloneStack(logSilverbell, 4), saplingSilverbell, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingAmaranth, ItemHelper.cloneStack(logAmaranth, 4), saplingAmaranth, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingTigerwood, ItemHelper.cloneStack(logTigerwood, 4), saplingTigerwood, 50, Type.TREE);

				InsolatorManager.addDefaultTreeRecipe(saplingWillow, ItemHelper.cloneStack(logWillow, 4), saplingWillow, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingEucalyptus, ItemHelper.cloneStack(logEucalyptus, 4), saplingEucalyptus, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingHopseed, ItemHelper.cloneStack(logHopseed, 4), saplingHopseed, 50, Type.TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingSakura, ItemHelper.cloneStack(logSakura, 4), saplingSakura, 50, Type.TREE);

				InsolatorManager.addDefaultTreeRecipe(saplingGhostwood, ItemHelper.cloneStack(logGhostwood, 4), saplingGhostwood, 50, Type.NETHER_TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingFusewood, ItemHelper.cloneStack(logFusewood, 4), saplingFusewood, 50, Type.NETHER_TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingDarkwood, ItemHelper.cloneStack(logDarkwood, 4), saplingDarkwood, 50, Type.NETHER_TREE);
				InsolatorManager.addDefaultTreeRecipe(saplingBloodwood, ItemHelper.cloneStack(logBloodwood, 4), saplingBloodwood, 50, Type.NETHER_TREE);
			}

			/* TRANSPOSER */
			{
				if (seed_oil != null) {
					TransposerManager.addExtractRecipe(2400, seedBarley, ItemStack.EMPTY, new FluidStack(seed_oil, 10), 0, false);
					TransposerManager.addExtractRecipe(2400, seedCotton, ItemStack.EMPTY, new FluidStack(seed_oil, 10), 0, false);
				}
			}

			/* TAPPER */
			{
				TapperManager.addMapping(logMaple, new FluidStack(TFFluids.fluidSap, 100));
				TapperManager.addMapping(logSilverbell, new FluidStack(TFFluids.fluidResin, 50));
				TapperManager.addMapping(logAmaranth, new FluidStack(TFFluids.fluidResin, 50));
				TapperManager.addMapping(logTigerwood, new FluidStack(TFFluids.fluidResin, 50));

				TapperManager.addMapping(logWillow, new FluidStack(TFFluids.fluidResin, 50));
				TapperManager.addMapping(logEucalyptus, new FluidStack(TFFluids.fluidResin, 50));
				TapperManager.addMapping(logHopseed, new FluidStack(TFFluids.fluidResin, 50));
				TapperManager.addMapping(logSakura, new FluidStack(TFFluids.fluidSap, 50));

				addLeafMapping(log, leaves, 0);
				addLeafMapping(log, leaves, 1);
				addLeafMapping(log, leaves, 2);
				addLeafMapping(log, leaves, 3);

				addLeafMapping(log2, leaves2, 0);
				addLeafMapping(log2, leaves2, 1);
				addLeafMapping(log2, leaves2, 2);
				addLeafMapping(log2, leaves2, 3);
			}
		} catch (Throwable t) {
			ThermalExpansion.LOG.error("Thermal Expansion: " + MOD_NAME + " Plugin encountered an error:", t);
			error = true;
		}
		if (!error) {
			ThermalExpansion.LOG.info("Thermal Expansion: " + MOD_NAME + " Plugin Enabled.");
		}
		return !error;
	}

	/* HELPERS */
	private void addLeafMapping(Block logBlock, Block leafBlock, int metadata) {

		IBlockState logState = logBlock.getStateFromMeta(metadata);

		for (Boolean check_decay : BlockLeaves.CHECK_DECAY.getAllowedValues()) {
			IBlockState leafState = leafBlock.getStateFromMeta(metadata).withProperty(BlockLeaves.DECAYABLE, Boolean.TRUE).withProperty(BlockLeaves.CHECK_DECAY, check_decay);
			TapperManager.addLeafMappingDirect(logState, leafState);
		}
	}

}
