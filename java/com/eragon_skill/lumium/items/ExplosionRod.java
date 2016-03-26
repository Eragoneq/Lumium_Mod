package com.eragon_skill.lumium.items;

import java.util.Set;

import com.eragon_skill.lumium.entities.EntityThrownTNT;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExplosionRod extends ItemTool{

	private static final Set SET = Sets.newHashSet(new Block[] {Blocks.air});
	
	public ExplosionRod(ToolMaterial material) {
		super(material, SET);
		this.setUnlocalizedName("explosion_rod");
		ItemStack stack = new ItemStack(ModItems.explosion_rod);
		this.setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(this, "explosion_rod");
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState blockIn, BlockPos pos, EntityLivingBase entityLiving) {
		return false;
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		world.playSound(player, player.getPosition(), SoundEvents.item_firecharge_use, SoundCategory.NEUTRAL, 0.7F, 0.9F);
		if(!world.isRemote){
			EntityThrownTNT eTT = new EntityThrownTNT(world, player);
			eTT.func_184538_a(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntityInWorld(eTT);
			stack.damageItem(1, player);
		}
		return super.onItemRightClick(stack, world, player, hand);
	}
}
