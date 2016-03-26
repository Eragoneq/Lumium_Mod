package com.eragon_skill.lumium.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.eragon_skill.lumium.Reference;

public class ItemModShovel extends ItemSpade{
	
	public ItemModShovel(ToolMaterial material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabTools);	
		GameRegistry.registerItem(this, name);
	}
}
