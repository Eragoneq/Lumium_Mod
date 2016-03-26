package com.eragon_skill.lumium.items;

import java.util.List;

import com.eragon_skill.lumium.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemModPickaxe extends ItemPickaxe{

	public ItemModPickaxe(ToolMaterial material, String name) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabTools);	
		GameRegistry.registerItem(this, name);
	}
	
	public void RegisterRenderer(String modelName)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(Reference.MOD_ID+":"+modelName, "inventory"));
	}
	
}
