package com.eragon_skill.lumium.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.eragon_skill.lumium.Reference;
import com.eragon_skill.lumium.blocks.ModBlocks;

public class ModBlockRenderer {
	
	public static void registerBlockRenderers(){
		reg(ModBlocks.ignisium_ore);
		reg(ModBlocks.lumium_ore);
		reg(ModBlocks.crafting_altar);
	}
	public static void reg(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID+":"+block.getUnlocalizedName().substring(5), "inventory"));
	}
}
