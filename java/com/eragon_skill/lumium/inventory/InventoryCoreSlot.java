package com.eragon_skill.lumium.inventory;

import com.eragon_skill.lumium.items.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class InventoryCoreSlot implements IInventory{
	
	private ItemStack[] stackCore = new ItemStack[1];
	
	@Override
	public String getName() {
		return "Player Core Slot";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.stackCore[0];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.func_188383_a(this.stackCore, 0);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.func_188383_a(this.stackCore, 0);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.stackCore[0] = stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public void markDirty() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {	
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {	
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		this.stackCore[0]=null;
	}
}
