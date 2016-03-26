package com.eragon_skill.lumium.items;


import java.util.List;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundListSerializer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.eragon_skill.lumium.Reference;
import com.eragon_skill.lumium.utils.CustomItem;

public class ModItems {
	//items
	public static CustomItem lumium_ingot;
	public static CustomItem ignisium_ingot;
	//misc
	public static PlayerCore player_core;
	//tools
	public static ItemModPickaxe lumium_pickaxe;
	public static ItemModSword lumium_sword;
	public static ItemModAxe lumium_axe;
	public static ItemModShovel lumium_shovel;
	//
	public static ItemModPickaxe ignisium_pickaxe;
	public static ItemModSword ignisium_sword;
	public static ItemModAxe ignisium_axe;
	public static ItemModShovel ignisium_shovel;
	//rods
	public static ExplosionRod explosion_rod;
	//armor
	public static ItemModArmor lumium_helmet;
	public static ItemModArmor lumium_chestplate;
	public static ItemModArmor lumium_leggings;
	public static ItemModArmor lumium_boots;
	//
	public static ItemModArmor ignisium_helmet;
	public static ItemModArmor ignisium_chestplate;
	public static ItemModArmor ignisium_leggings;
	public static ItemModArmor ignisium_boots;
	//materials
	public static ToolMaterial lumiumMaterial = EnumHelper.addToolMaterial("lumium", 4, 1024, 10.0F, 2.0F, 25);
	public static ToolMaterial ignisiumMaterial = EnumHelper.addToolMaterial("ignisium", 4, 2048, 13.0F, 4.0F, 22);
	public static ArmorMaterial lumiumArmorMaterial = EnumHelper.addArmorMaterial("lumiumArmorMaterial", Reference.MOD_ID+":lumium_armor", 27, new int[]{2, 6, 4, 3}, 25, null);
	public static ArmorMaterial ignisiumArmorMaterial = EnumHelper.addArmorMaterial("ignisiumArmorMaterial", Reference.MOD_ID+":ignisium_armor", 50, new int[]{3, 8, 6, 3}, 22, null);
	public static ToolMaterial rodMaterial = EnumHelper.addToolMaterial("rod", 0, 128, 1.0F, 2.0F, 0);
	
	public static void initItems(){
		//items
		lumium_ingot = new CustomItem("lumium_ingot", CreativeTabs.tabMaterials, 64);
		ignisium_ingot = new CustomItem("ignisium_ingot", CreativeTabs.tabMaterials, 64);
		//misc
		player_core = new PlayerCore();
		explosion_rod = new ExplosionRod(rodMaterial);
		//tools
		lumium_pickaxe = new ItemModPickaxe(lumiumMaterial, "lumium_pickaxe");
		lumium_sword = new ItemModSword(lumiumMaterial, "lumium_sword");
		lumium_axe = new ItemModAxe(lumiumMaterial, "lumium_axe");
		lumium_shovel = new ItemModShovel(lumiumMaterial, "lumium_shovel");
		//
		ignisium_pickaxe = new ItemModPickaxe(ignisiumMaterial, "ignisium_pickaxe");
		ignisium_sword = new ItemModSword(ignisiumMaterial, "ignisium_sword");
		ignisium_axe = new ItemModAxe(ignisiumMaterial, "ignisium_axe");
		ignisium_shovel = new ItemModShovel(ignisiumMaterial, "ignisium_shovel");
		//armor
		lumium_helmet = new ItemModArmor("lumium_helmet", lumiumArmorMaterial, 1, EntityEquipmentSlot.HEAD);
		lumium_chestplate = new ItemModArmor("lumium_chestplate", lumiumArmorMaterial, 1, EntityEquipmentSlot.CHEST);
		lumium_leggings = new ItemModArmor("lumium_leggings", lumiumArmorMaterial, 2, EntityEquipmentSlot.LEGS);
		lumium_boots = new ItemModArmor("lumium_boots", lumiumArmorMaterial, 1, EntityEquipmentSlot.FEET);
		//
		ignisium_helmet = new ItemModArmor("ignisium_helmet", ignisiumArmorMaterial, 1, EntityEquipmentSlot.HEAD);
		ignisium_chestplate = new ItemModArmor("ignisium_chestplate", ignisiumArmorMaterial, 1, EntityEquipmentSlot.CHEST);
		ignisium_leggings = new ItemModArmor("ignisium_leggings", ignisiumArmorMaterial, 2, EntityEquipmentSlot.LEGS);
		ignisium_boots = new ItemModArmor("ignisium_boots", ignisiumArmorMaterial, 1, EntityEquipmentSlot.FEET);
	}
	public static final CreativeTabs tabMod = new CreativeTabs(CreativeTabs.getNextID(), "lumiumtab")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return ModItems.lumium_ingot;
        }
    };
}
