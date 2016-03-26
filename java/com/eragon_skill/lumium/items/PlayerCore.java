package com.eragon_skill.lumium.items;

import java.util.List;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Chat;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerCore extends Item{
	public PlayerCore() {
		this.setUnlocalizedName("player_core");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
		GameRegistry.registerItem(this, "player_core");

	}
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.isSneaking()){
				if(stack.getTagCompound() == null){
					stack.setTagCompound(new NBTTagCompound());
					NBTTagCompound uses = new NBTTagCompound();
					uses.setInteger("uses", 16 + (int)(Math.random()*16));
					stack.getTagCompound().setTag("use", uses);
				}
				if(!stack.getTagCompound().hasKey("info")){
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("player", playerIn.getName());
					stack.getTagCompound().setTag("info", nbt);
					stack.setStackDisplayName(TextFormatting.GOLD + "Bound Player Core");
				}
		}
		return EnumActionResult.FAIL;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer playerIn, EnumHand hand) {
		if(playerIn.isSneaking()){
			if(stack.getTagCompound() != null){
				if(stack.getTagCompound().hasKey("info")){
					NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("info");
					if(nbt.getString("player") == playerIn.getName()){
						stack.getTagCompound().removeTag("info");
						stack.setStackDisplayName(TextFormatting.AQUA + "Player Core");
					} 
					else{
						playerIn.addChatComponentMessage(new TextComponentString("This core is already bound to another player!"));
					}
				}
			}
		}
		return super.onItemRightClick(stack, world, playerIn, hand);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("use")){
				NBTTagCompound uses = (NBTTagCompound) stack.getTagCompound().getTag("use");;
				int use = uses.getInteger("uses");
				tooltip.add("Uses: " + use);
			}
			if(stack.getTagCompound().hasKey("info")){
				NBTTagCompound nick = (NBTTagCompound) stack.getTagCompound().getTag("info");
				String name = nick.getString("player");
				tooltip.add("Nickname: " + name);
			}
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("info")){
				return stack.getTagCompound().hasKey("info");
			}
		}
		return false;
    }
}
