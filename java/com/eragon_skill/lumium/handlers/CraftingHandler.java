package com.eragon_skill.lumium.handlers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.eragon_skill.lumium.blocks.ModBlocks;
import com.eragon_skill.lumium.items.ModItems;
import com.eragon_skill.lumium.utils.CustomItem;

public class CraftingHandler {
	public static void registerCraftingRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_pickaxe), new Object[]{"XXX", " I ", " I ", 'X', ModItems.lumium_ingot, 'I', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_axe), new Object[]{"XX ", "XI ", " I ", 'X', ModItems.lumium_ingot, 'I', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_sword), new Object[]{" X ", " X ", " I ", 'X', ModItems.lumium_ingot, 'I', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_shovel), new Object[]{" X ", " I ", " I ", 'X', ModItems.lumium_ingot, 'I', Items.stick});
		//
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_pickaxe), new Object[]{"XXX", " I ", " I ", 'X', ModItems.ignisium_ingot, 'I', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_axe), new Object[]{"XX ", "XI ", " I ", 'X', ModItems.ignisium_ingot, 'I', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_sword), new Object[]{" X ", " X ", " I ", 'X', ModItems.ignisium_ingot, 'I', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_shovel), new Object[]{" X ", " I ", " I ", 'X', ModItems.ignisium_ingot, 'I', Items.blaze_rod});
		//
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_helmet), new Object[]{"XXX", "X X", "   ", 'X', ModItems.lumium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_chestplate), new Object[]{"X X", "XXX", "XXX", 'X', ModItems.lumium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_leggings), new Object[]{"XXX", "X X", "X X", 'X', ModItems.lumium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.lumium_boots), new Object[]{"   ", "X X", "X X", 'X', ModItems.lumium_ingot});
		//
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_helmet), new Object[]{"XXX", "X X", "   ", 'X', ModItems.ignisium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_chestplate), new Object[]{"X X", "XXX", "XXX", 'X', ModItems.ignisium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_leggings), new Object[]{"XXX", "X X", "X X", 'X', ModItems.ignisium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ignisium_boots), new Object[]{"   ", "X X", "X X", 'X', ModItems.ignisium_ingot});
	}
	public static void registerSmeltingRecipes(){
		GameRegistry.addSmelting(ModBlocks.lumium_ore, new ItemStack(ModItems.lumium_ingot), 5.0F);
		GameRegistry.addSmelting(ModBlocks.ignisium_ore, new ItemStack(ModItems.ignisium_ingot), 8.0F);
	}
}
