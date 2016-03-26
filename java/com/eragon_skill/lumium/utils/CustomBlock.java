package com.eragon_skill.lumium.utils;

import java.util.Random;

import com.eragon_skill.lumium.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CustomBlock extends Block
{
	private Item dropsOnHarvest;
	private int dropamountmax;
	private int maxharvestExp = 2;
	
	public CustomBlock(Material material, String name, float hardness, float resistance, HarvestToolEnum harvesttool, HarvestLevelEnum harvestlevel, CreativeTabs creativetab, int dropamountmax, int minVeinSize, int maxVeinSize, int genChance, int minGenY, int maxGenY, Block[] generateIn, Block[] generateNear, int generateDistance, boolean generateInOverworld, boolean generateInNether, boolean generateInEnder) 
	{ 
		super(material); 			
		
		this.dropamountmax = dropamountmax;
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(harvesttool, harvestlevel);
		this.setCreativeTab(creativetab);
		System.out.println("INITIALIZING BLOCK: " + name);
		
		GameRegistry.registerBlock(this, name);    	
 		GameRegistry.registerWorldGenerator(new CustomBlockGen(this, minVeinSize, maxVeinSize, genChance, minGenY, maxGenY, generateIn, generateNear, generateDistance, generateInOverworld, generateInNether, generateInEnder), 1);		
	
		this.dropsOnHarvest = Item.getItemFromBlock(this);
	}	
	public CustomBlock(Material material, String name, float hardness, float resistance, HarvestToolEnum harvesttool, HarvestLevelEnum harvestlevel, CreativeTabs creativetab, int dropamountmax)
	{
		super(material);
		
		this.dropamountmax = dropamountmax;
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(harvesttool, harvestlevel);
		this.setCreativeTab(creativetab);
		
		GameRegistry.registerBlock(this, name);
		
		this.dropsOnHarvest = Item.getItemFromBlock(this);
	}
	
	public void setHarvestLevel(HarvestToolEnum harvestTool, HarvestLevelEnum harvestLevel)
	{
		int level;
		String tool;
		
		switch(harvestTool)
		{
		case PICKAXE:
			tool = "pickaxe";
			break;
		case SHOVEL:
			tool = "shovel";
			break;
		case AXE:
			tool = "axe";
			break;
		default:
			tool = "pickaxe";
		}
		switch(harvestLevel)
		{
		case WOOD:
			level = 0;
			break;
		case STONE:
			level = 1;
			break;
		case IRON:
			level = 2;
			break;
		case DIAMOND:
			level = 3;
			break;
		case GOLD:
			level = 0;
			break;
		case LUMIUM:
			level=4;
			break;
		default:
			level = 0;
		}
		super.setHarvestLevel(tool, level);
	}
	
	public static enum HarvestToolEnum
	{
		PICKAXE,
		SHOVEL,
		AXE;	
	}
	public static enum HarvestLevelEnum
	{
		WOOD,
		STONE,
		IRON,
		DIAMOND,
		GOLD,
		LUMIUM;
	}
	public void setMaxHarvestEXP(int expAmount)
	{
		maxharvestExp = expAmount;
	}
	
	public void setDrops(Item drops)
	{
		this.dropsOnHarvest = drops;
	}
	public void setDrops(Block drops)
	{
		this.dropsOnHarvest = Item.getItemFromBlock(drops);
	}
	
	public void setDropMaxAmount(int dropamount)
	{
		this.dropamountmax = dropamount;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		 return this.dropsOnHarvest;
    }
	
	public int quantityDropped(Random random)
    {		
		int amount = random.nextInt(this.dropamountmax)+1;
        return amount;
    }
	
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
        	return MathHelper.getRandomIntegerInRange(rand, 0, maxharvestExp);
        }
        return 0;
    }
}
