package com.eragon_skill.lumium.blocks;

import com.eragon_skill.lumium.LumiumMod;
import com.eragon_skill.lumium.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CraftingAltar extends Block{
	
	public CraftingAltar() {
		super(Material.iron);
		this.setUnlocalizedName("crafting_altar");
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(ModItems.tabMod);
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
	}
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!player.isSneaking()){
			player.openGui(LumiumMod.instance, ModBlocks.guiIDCraftingAltar, world, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}else{
			return false;
		}
	}
}
