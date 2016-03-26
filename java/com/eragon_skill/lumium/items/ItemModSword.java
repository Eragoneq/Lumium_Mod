package com.eragon_skill.lumium.items;

import com.eragon_skill.lumium.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemModSword extends ItemSword{

	public ItemModSword(ToolMaterial material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabCombat);	
		GameRegistry.registerItem(this, name);
	}
}
