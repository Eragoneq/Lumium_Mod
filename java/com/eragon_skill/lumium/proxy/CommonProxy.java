package com.eragon_skill.lumium.proxy;

import com.eragon_skill.lumium.LumiumMod;
import com.eragon_skill.lumium.blocks.ModBlocks;
import com.eragon_skill.lumium.entities.ModEntities;
import com.eragon_skill.lumium.handlers.CraftingHandler;
import com.eragon_skill.lumium.items.ModItems;
import com.eragon_skill.lumium.utils.CustomBlock;
import com.eragon_skill.lumium.utils.CustomItem;
import com.eragon_skill.lumium.utils.CustomBlock.HarvestLevelEnum;
import com.eragon_skill.lumium.utils.CustomBlock.HarvestToolEnum;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	
	public void init(FMLInitializationEvent e)
	{
		ModItems.initItems();
		ModBlocks.initBlocks();
		ModEntities.initEntities();
		CraftingHandler.registerCraftingRecipes();
		CraftingHandler.registerSmeltingRecipes();
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
}
