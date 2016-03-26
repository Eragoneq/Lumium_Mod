package com.eragon_skill.lumium.entities;

import java.util.Random;

import com.eragon_skill.lumium.LumiumMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EntityThrownTNT extends EntityThrowable{

	public EntityThrownTNT(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}
	public EntityThrownTNT(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	public EntityThrownTNT(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		double posx = posX;
		double posy = posY;
		double posz = posZ;
		for(int i=0; i<10; i++){
			double motionX = rand.nextGaussian() * 0.02D;
			double motionY = rand.nextGaussian() * 0.02D;
			double motionZ = rand.nextGaussian() * 0.02D;
			posx = posX + rand.nextFloat() * width * 2.0F - width;
			posy = posY + 0.5D + rand.nextFloat() * height;
			posz = posZ + rand.nextFloat() * width * 2.0F - width;
        	this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, posx, posy, posz, motionX, motionY, motionZ, new int[0]);
        }
		if(!this.worldObj.isRemote){
			this.setDead();
			if(!this.worldObj.isRemote){
				this.worldObj.createExplosion((Entity) null, posx, posy, posz, 2.5F, true);
			}
		}
	}
}
