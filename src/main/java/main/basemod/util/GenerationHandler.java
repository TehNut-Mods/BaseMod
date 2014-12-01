package main.basemod.util;

//This class handles all generation the mod contains.

import main.basemod.ConfigHandler;
import main.basemod.blocks.BlockRegistry;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator {

	// Which dimension to generate in by dimension ID (Nether -1, Overworld 0, End 1, etc)
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
			case -1:
				break;
			case 0:
				generateSurface(world, random);
				break;
			case 1:
				break;
		}
	}

	//The actual generation method.
	private void generateSurface(World world, Random rand) {
		if (ConfigHandler.enableGeneration)
			(new WorldGenMinable(BlockRegistry.quisqueLapisOre.getDefaultState(), 0)).generate(world, rand, BlockPos.ORIGIN);
	}
}
