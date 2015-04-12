package com.mrmakeit.fireflower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlowerFireball extends EntityThrowable {
	
   private int bounceCount=0;
   private World myWorld;

   public EntityFlowerFireball(World par1World)
   {
       super(par1World);
       myWorld=par1World;
   }
   public EntityFlowerFireball(World par1World, EntityPlayer par3EntityPlayer)
   {
       super(par1World, par3EntityPlayer);
       myWorld=par1World;
   }
   public EntityFlowerFireball(World par1World, double par2, double par4, double par6)
   {
       super(par1World, par2, par4, par6);
       myWorld=par1World;
   }

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		if (movingobjectposition.entityHit != null)
        {
			movingobjectposition.entityHit.setFire(5);
			this.setDead();
        }else{
        	if(this.bounceCount<2){
	        	this.bounceCount++;
	        	if(movingobjectposition.sideHit==0||movingobjectposition.sideHit==1){
	        		this.motionY = -this.motionY;
	        	}else if(movingobjectposition.sideHit==2||movingobjectposition.sideHit==3){
	        		this.motionZ = -this.motionZ;
	        	}else if(movingobjectposition.sideHit==4||movingobjectposition.sideHit==5){
	        		this.motionX = -this.motionX;
	        	}
        	}else{
        		Block hitBlock = myWorld.getBlock(movingobjectposition.blockX,movingobjectposition.blockY+1,movingobjectposition.blockZ);
        		if(hitBlock==null||hitBlock.getMaterial() == Material.air){
        			myWorld.setBlock(movingobjectposition.blockX,movingobjectposition.blockY+1,movingobjectposition.blockZ,Blocks.fire);
        		}
        		this.setDead();
        	}
        }
	}

}
