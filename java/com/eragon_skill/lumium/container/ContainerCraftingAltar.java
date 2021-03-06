package com.eragon_skill.lumium.container;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import com.eragon_skill.lumium.blocks.CraftingAltar;
import com.eragon_skill.lumium.blocks.ModBlocks;
import com.eragon_skill.lumium.crafting.AltarCraftingManager;
import com.eragon_skill.lumium.inventory.InventoryCoreSlot;
import com.eragon_skill.lumium.inventory.PlayerCoreSlot;
import com.eragon_skill.lumium.items.PlayerCore;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Tick;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ContainerCraftingAltar extends Container{

	public InventoryCrafting craftMatrix;
	public InventoryCoreSlot coreSlot;
	public IInventory craftResult;
	public IInventory stackCore;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	
	public ContainerCraftingAltar(InventoryPlayer playerInventory, World world, int x, int y, int z) {
		{
			craftMatrix = new InventoryCrafting(this, 3, 3);
			craftResult = new InventoryCraftResult();
			coreSlot = new InventoryCoreSlot();
	        this.worldObj = world;
	        this.posX = x;
	        this.posY = y;
	        this.posZ = z;
	        int indx = 0;
	        
	        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 134, 48));
	        
	        this.addSlotToContainer(new Slot(this.craftMatrix, indx, 22, 20)); //1
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 52, 5)); //2
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 79, 20)); //3
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 8, 48)); //1
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 52, 48)); //2
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 94, 48)); //3
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 22, 76)); //1
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 52, 90)); //2
	        this.addSlotToContainer(new Slot(this.craftMatrix, ++indx, 80, 76)); //3
	        
			this.addSlotToContainer(new PlayerCoreSlot(coreSlot, 0, 134, 81, coreSlot, worldObj, craftResult, craftMatrix));

	        for (int k = 0; k < 3; ++k)
	        {
	            for (int i1 = 0; i1 < 9; ++i1)
	            {
	                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 112 + k * 18));
	            }
	        }

	        for (int l = 0; l < 9; ++l)
	        {
	            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 170));
	        }

	        this.onCraftMatrixChanged(this.craftMatrix);
	    }
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
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
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() != ModBlocks.crafting_altar) {
			return false;
		}else{
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}

	}
	
	public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);

                if (itemstack != null)
                {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
            ItemStack stack = this.coreSlot.removeStackFromSlot(0);
            
            if(stack != null){
            	playerIn.dropPlayerItemWithRandomChoice(stack, false);
            }
        }
    }

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			} else if (index >= 10 && index < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (index >= 37 && index < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(playerIn, itemstack1);
		}

		return itemstack;
	}
	
	public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}
