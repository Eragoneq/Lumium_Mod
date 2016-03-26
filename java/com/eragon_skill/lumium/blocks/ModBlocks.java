package com.eragon_skill.lumium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

import com.eragon_skill.lumium.LumiumMod;
import com.eragon_skill.lumium.utils.CustomBlock;
import com.eragon_skill.lumium.utils.CustomBlock.HarvestLevelEnum;
import com.eragon_skill.lumium.utils.CustomBlock.HarvestToolEnum;

public class ModBlocks {
	//Blocks
	public static CustomBlock lumium_ore;
	public static CustomBlock ignisium_ore;
	//
	public static CraftingAltar crafting_altar;
	public static final int guiIDCraftingAltar = 1;

	public static void initBlocks(){
		lumium_ore = new CustomBlock(Material.rock, "lumium_ore", 3.0F, 5.0F, HarvestToolEnum.PICKAXE, HarvestLevelEnum.IRON, CreativeTabs.tabBlock, 1, 3, 8, 15, 5, 60, new Block[]{Blocks.stone}, new Block[]{Blocks.lava, Blocks.diamond_ore}, 3, true, false, false);
		ignisium_ore = new CustomBlock(Material.rock, "ignisium_ore", 7.0F, 10.0F, HarvestToolEnum.PICKAXE, HarvestLevelEnum.LUMIUM, CreativeTabs.tabBlock, 1, 3, 4, 100, 0, 255, new Block[]{Blocks.netherrack}, new Block[]{Blocks.netherrack}, 0, false, true, false);
		crafting_altar = new CraftingAltar();
	}
}
