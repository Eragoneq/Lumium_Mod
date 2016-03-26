package com.eragon_skill.lumium;

import com.eragon_skill.lumium.handlers.CraftingHandler;
import com.eragon_skill.lumium.handlers.GuiHandler;
import com.eragon_skill.lumium.proxy.CommonProxy;
import com.eragon_skill.lumium.utils.CustomBlock;
import com.eragon_skill.lumium.utils.CustomItem;

import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class LumiumMod {
	@Instance(value = Reference.MOD_ID)
	public static LumiumMod instance;
	
	@SidedProxy(modId = Reference.MOD_ID, clientSide="com.eragon_skill.lumium.proxy.ClientProxy", serverSide="com.eragon_skill.lumium.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		proxy.init(e);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
}
