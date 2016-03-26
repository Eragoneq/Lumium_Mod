package com.eragon_skill.lumium.blocks;

import org.lwjgl.opengl.GL11;

import com.eragon_skill.lumium.Reference;
import com.eragon_skill.lumium.container.ContainerCraftingAltar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiCraftingAltar extends GuiContainer{

	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/CraftingAltar.png");
	
	public GuiCraftingAltar(InventoryPlayer inv, World world, int x, int y, int z) {
		super(new ContainerCraftingAltar(inv, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
	}
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		//this.fontRendererObj.drawString(StatCollector.translateToLocal("Crafting Altar"), 100, 5, 0x000000);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
