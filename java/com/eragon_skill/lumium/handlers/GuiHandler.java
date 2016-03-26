package com.eragon_skill.lumium.handlers;

import com.eragon_skill.lumium.blocks.GuiCraftingAltar;
import com.eragon_skill.lumium.blocks.ModBlocks;
import com.eragon_skill.lumium.container.ContainerCraftingAltar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));	
		if(ID == ModBlocks.guiIDCraftingAltar) {
			return ID == ModBlocks.guiIDCraftingAltar && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.crafting_altar ? new ContainerCraftingAltar(player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == ModBlocks.guiIDCraftingAltar ) {
			return ID == ModBlocks.guiIDCraftingAltar  && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.crafting_altar ? new GuiCraftingAltar(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

}