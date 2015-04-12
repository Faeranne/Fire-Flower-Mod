package com.mrmakeit.fireflower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
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
	        	if(movingobjectposition.sideHit==EnumFacing.DOWN||movingobjectposition.sideHit==EnumFacing.UP){
	        		this.motionY = -this.motionY;
	        	}else if(movingobjectposition.sideHit==EnumFacing.NORTH||movingobjectposition.sideHit==EnumFacing.SOUTH){
	        		this.motionZ = -this.motionZ;
	        	}else if(movingobjectposition.sideHit==EnumFacing.EAST||movingobjectposition.sideHit==EnumFacing.WEST){
	        		this.motionX = -this.motionX;
	        	}
        	}else{
        		Block hitBlock = myWorld.getBlockState(new BlockPos(movingobjectposition.getBlockPos().getX(),movingobjectposition.getBlockPos().getY()+1,movingobjectposition.getBlockPos().getZ())).getBlock();
        		
        		if(hitBlock==null||hitBlock.getMaterial() == Material.air){
        			IBlockState fire = Blocks.fire.getDefaultState();
        			myWorld.setBlockState(new BlockPos(movingobjectposition.getBlockPos().getX(),movingobjectposition.getBlockPos().getY()+1,movingobjectposition.getBlockPos().getZ()),fire);
        		}
        		this.setDead();
        	}
        }
	}

}
