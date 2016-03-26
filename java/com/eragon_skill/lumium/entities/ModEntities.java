package com.eragon_skill.lumium.entities;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.eragon_skill.lumium.LumiumMod;

public class ModEntities {
	
	public static EntityThrownTNT thrown_tnt;
	
	public static void initEntities(){
		createEntity(EntityThrownTNT.class, "thrown_tnt");
	}
	
	public static void createEntity(Class classId, String name){
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(classId, name, id);
		EntityRegistry.registerModEntity(classId, name, id, LumiumMod.instance, 80, 10, true);
	}
	
	public static void createEntity(Class classId, String name, int solidColor, int spotColor){
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(classId, name, id);
		EntityRegistry.registerModEntity(classId, name, id, LumiumMod.instance, 80, 10, true);
		EntityRegistry.registerEgg(classId, solidColor, spotColor);
	}
}
