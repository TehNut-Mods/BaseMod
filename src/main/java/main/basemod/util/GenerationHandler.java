package main.basemod.util;

import cpw.mods.fml.common.IWorldGenerator;
import main.basemod.ConfigHandler;
import main.basemod.blocks.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				break;
		}
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for (int k = 0; k < 10; k++) {
			int firstBlockXCoord = chunkX + rand.nextInt(16);
			int firstBlockZCoord = chunkZ + rand.nextInt(16);
			int quisqueY = rand.nextInt(20);

			if(ConfigHandler.enableGeneration)
				(new WorldGenMinable(BlockRegistry.quisqueLapisOre, 0, 4, Blocks.stone)).generate(world, rand, firstBlockXCoord, quisqueY, firstBlockZCoord);
		}
	}
}
