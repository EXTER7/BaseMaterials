package exter.substratum.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BMWorldGenerator implements IWorldGenerator
{
  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
    WorldGenOre.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
  }
}