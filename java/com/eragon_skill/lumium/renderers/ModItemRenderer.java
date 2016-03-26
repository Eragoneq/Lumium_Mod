package com.eragon_skill.lumium.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.eragon_skill.lumium.Reference;
import com.eragon_skill.lumium.items.ModItems;

public class ModItemRenderer {
	
	public static void registerItemRenderers(){
		//items
		reg(ModItems.lumium_ingot);
		reg(ModItems.ignisium_ingot);
		//
		reg(ModItems.player_core);
		reg(ModItems.explosion_rod);
		//armor
		reg(ModItems.lumium_helmet);
		reg(ModItems.lumium_chestplate);
		reg(ModItems.lumium_leggings);
		reg(ModItems.lumium_boots);
		//
		reg(ModItems.ignisium_helmet);
		reg(ModItems.ignisium_chestplate);
		reg(ModItems.ignisium_leggings);
		reg(ModItems.ignisium_boots);
		//tools
		reg(ModItems.lumium_pickaxe);
		reg(ModItems.lumium_shovel);
		reg(ModItems.lumium_sword);
		reg(ModItems.lumium_axe);
		//
		reg(ModItems.ignisium_pickaxe);
		reg(ModItems.ignisium_shovel);
		reg(ModItems.ignisium_sword);
		reg(ModItems.ignisium_axe);
	} 
	public static void reg(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID+":"+item.getUnlocalizedName().substring(5), "inventory"));
	}
}
