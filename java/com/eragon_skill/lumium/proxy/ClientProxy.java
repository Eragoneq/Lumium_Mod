package com.eragon_skill.lumium.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.eragon_skill.lumium.blocks.ModBlocks;
import com.eragon_skill.lumium.items.ModItems;
import com.eragon_skill.lumium.renderers.ModBlockRenderer;
import com.eragon_skill.lumium.renderers.ModEntityRenderer;
import com.eragon_skill.lumium.renderers.ModItemRenderer;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		ModBlockRenderer.registerBlockRenderers();
		ModItemRenderer.registerItemRenderers();
		ModEntityRenderer.registerEntityRenderers();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}