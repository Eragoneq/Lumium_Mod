package com.eragon_skill.lumium.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.eragon_skill.lumium.Reference;
import com.google.common.collect.Sets;

public class ItemModAxe extends ItemTool{

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder, Blocks.wooden_button, Blocks.wooden_pressure_plate});
	
	public ItemModAxe(ToolMaterial material, String name) {
		super(material, EFFECTIVE_ON);
		setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName(name);
		this.attackSpeed = -3.0F;
		this.damageVsEntity = material.getDamageVsEntity() + 5.0F;
		GameRegistry.registerItem(this, name);
	}

	

}

