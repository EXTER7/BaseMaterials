package exter.basematerials.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exter.basematerials.config.BMConfig.WorldgenConfig;
import net.minecraft.block.state.IBlockState;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;

public class WorldGenOre
{
  static private List<WorldGenOre> ores = new ArrayList<WorldGenOre>();
  
  public final int min_y;
  public final int max_y;

  public final int frequency;

  public final IBlockState block;
  
  
  private WorldGenMinable wgm;
  
  private WorldGenOre(int min,int max,int freq,IBlockState state)
  {
    if(min < max)
    {
      min_y = min;
      max_y = max;
    } else
    {
      min_y = max;
      max_y = min;
    }

    frequency = freq;

    block = state;
    wgm = new WorldGenMinable(state, 7);
  }

  private void generateOre(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
    int i;
    for(i = 0; i < frequency; i++)
    {
      int x = chunkX * 16 + random.nextInt(16);
      int y = min_y + random.nextInt(max_y - min_y);
      int z = chunkZ * 16 + random.nextInt(16);
      BlockPos pos = new BlockPos(x,y,z);
      BiomeGenBase biome = world.getBiomeGenForCoords(pos);
      for(BiomeGenBase bio : BiomeDictionary.getBiomesForType(BiomeDictionary.Type.END))
      {
        if(bio == biome)
        {
          continue;
        }
      }
      for(BiomeGenBase bio : BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER))
      {
        if(bio == biome)
        {
          continue;
        }
      }
      wgm.generate(world, random, pos);
    }
  }
  
  static public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
  {
    for(WorldGenOre wgo:ores)
    {
      wgo.generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }
  }
    
  static public void registerOre(WorldgenConfig config,IBlockState state)
  {
    if(config.enabled)
    {
      ores.add(new WorldGenOre(config.min_y,config.max_y,config.frequency,state));
    }
  }
}
