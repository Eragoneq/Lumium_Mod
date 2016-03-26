package com.eragon_skill.lumium.utils;

import java.util.List;

import com.eragon_skill.lumium.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CustomItem extends Item
{
	public CustomItem(String name, CreativeTabs creativetab, int maxstacksize)
	{
		this.setUnlocalizedName(name);
		this.setCreativeTab(creativetab);
		this.setMaxStackSize(maxstacksize);
		GameRegistry.registerItem(this, name);
	}
}
