package com.eragon_skill.lumium.renderers;

import com.eragon_skill.lumium.LumiumMod;
import com.eragon_skill.lumium.entities.EntityThrownTNT;
import com.eragon_skill.lumium.entities.ModEntities;
import com.eragon_skill.lumium.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntityRenderer {
	//poprawic
	public static void registerEntityRenderers(){
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownTNT.class, new RenderSnowball(mcRender(), Items.fire_charge, itemRender()));
	}
	private static RenderManager mcRender(){
		return Minecraft.getMinecraft().getRenderManager();
	}
	private static RenderItem itemRender(){
		return Minecraft.getMinecraft().getRenderItem();
	}
}
