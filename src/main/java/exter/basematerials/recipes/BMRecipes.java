package exter.basematerials.recipes;

import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import exter.basematerials.block.BMBlocks;
import exter.basematerials.config.BMConfig;
import exter.basematerials.item.BMItems;
import exter.basematerials.material.EnumMaterial;
import exter.basematerials.material.EnumMaterialItem;


public class BMRecipes
{
  static public void preInit()
  {

  }

  static public void init()
  {
    if(BMConfig.recipe_bronze_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.BRONZE,4),
          "dustCopper", 
          "dustCopper", 
          "dustCopper", 
          "dustTin"));
    }

    if(BMConfig.recipe_brass_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.BRASS,4),
          "dustCopper", 
          "dustCopper", 
          "dustCopper", 
          "dustZinc"));
    }

    if(BMConfig.recipe_cupronickel_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.CUPRONICKEL,2),
          "dustCopper",
          "dustNickel"));
    }

    if(BMConfig.recipe_invar_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.INVAR,3),
          "dustIron", 
          "dustIron", 
          "dustNickel"));
    }

    if(BMConfig.recipe_electrum_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.ELECTRUM,2),
          "dustGold", 
          "dustSilver"));
    }
    
    if(BMConfig.recipe_coaldust_enable)
    {
      GameRegistry.addRecipe(new ShapedOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.COAL,1),
          "FCF",
          'F', new ItemStack(Items.flint), 
          'C', new ItemStack(Items.coal,1,0)));
    }

    if(BMConfig.recipe_enderpearldust_enable)
    {
      GameRegistry.addRecipe(new ShapedOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.ENDERPEARL,1),
          "FEF",
          'F', new ItemStack(Items.flint), 
          'E', new ItemStack(Items.ender_pearl)));
    }

    if(BMConfig.recipe_signalum_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.SIGNALUM,4),
          "dustCopper", 
          "dustCopper", 
          "dustCopper", 
          "dustSilver",
          "blockRedstone", 
          "dustRedstone"));
    }

    if(BMConfig.recipe_lumium_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.LUMIUM,4),
          "dustTin", 
          "dustTin", 
          "dustTin", 
          "dustSilver",
          "dustGlowstone",
          "dustGlowstone",
          "dustGlowstone",
          "dustGlowstone" ));
    }

    if(BMConfig.recipe_enderium_enable)
    {
      GameRegistry.addRecipe(new ShapelessOreRecipe(
          BMItems.getStack(EnumMaterialItem.DUST,EnumMaterial.ENDERIUM,2),
          "dustTin", 
          "dustTin", 
          "dustTin", 
          "dustPlatinum",
          "dustEnderpearl",
          "dustEnderpearl",
          "dustEnderpearl",
          "dustEnderpearl" ));
    }


    //Dust -> Ingot smelting recipes.
    for(EnumMaterial mat:EnumMaterialItem.INGOT.materials)
    {
      GameRegistry.addSmelting(
          BMItems.getStack(EnumMaterialItem.DUST, mat),
          BMItems.getStack(EnumMaterialItem.INGOT, mat),
          0);
    }

    //Nugget <-> Ingot crafting recipes.
    for(EnumMaterial mat:EnumMaterialItem.INGOT.materials)
    {
      ItemStack ingot = BMItems.getStack(EnumMaterialItem.INGOT, mat);
      GameRegistry.addShapelessRecipe(
          BMItems.getStack(EnumMaterialItem.INGOT, mat, 9),
          ingot);
      GameRegistry.addRecipe(
          ingot,
          "NNN",
          "NNN",
          "NNN",
          'N', BMItems.getStack(EnumMaterialItem.INGOT, mat)); 
    }

    //Ore -> ingot furnace recipes
    for(Map.Entry<EnumMaterial, ItemStack> metal:BMBlocks.ore_stacks.entrySet())
    {
      GameRegistry.addSmelting(
          metal.getValue(),
          BMItems.getStack(EnumMaterialItem.INGOT, metal.getKey()),
          0);
    }    
  }

  static public void postInit()
  {
  }
}
