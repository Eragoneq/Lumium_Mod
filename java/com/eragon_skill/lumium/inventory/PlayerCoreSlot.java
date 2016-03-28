package com.eragon_skill.lumium.inventory;

import com.eragon_skill.lumium.blocks.CraftingAltar;
import com.eragon_skill.lumium.container.ContainerCraftingAltar;
import com.eragon_skill.lumium.crafting.AltarCraftingManager;
import com.eragon_skill.lumium.items.ModItems;
import com.eragon_skill.lumium.items.PlayerCore;
import com.google.common.annotations.Beta;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class PlayerCoreSlot extends Slot{

	public InventoryCrafting craftMatrix;
	public InventoryCoreSlot coreSlot;
	public IInventory craftResult;
	private World worldObj;
	
	public PlayerCoreSlot(IInventory inventoryIn, int index, int xPosition,
			int yPosition, InventoryCoreSlot coreSlot, World worldObj, IInventory craftResult, InventoryCrafting craftMatrix) {
		super(inventoryIn, index, xPosition, yPosition);
		
		this.craftMatrix = craftMatrix;
		this.coreSlot = coreSlot;
		this.craftResult = craftResult;
		this.worldObj = worldObj;
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() instanceof PlayerCore;
	}
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		EntityPlayer opener = CraftingAltar.opener;
		if(coreSlot.getStackInSlot(0) != null){
			if(PlayerCore.isBound(coreSlot.getStackInSlot(0))){
				EntityPlayer player = worldObj.getPlayerEntityByName(PlayerCore.getPlayerNickname(coreSlot.getStackInSlot(0)));
				if(0 < PlayerCore.getUses(coreSlot.getStackInSlot(0))){
					craftResult.setInventorySlotContents(0, AltarCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
				}else{
					craftResult.setInventorySlotContents(0, null);
				}
			}else{
				craftResult.setInventorySlotContents(0, null);
			}
		}else{
			craftResult.setInventorySlotContents(0, null);
		}
	}
}
