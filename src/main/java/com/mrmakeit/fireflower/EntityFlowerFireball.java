package com.mrmakeit.fireflower;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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
  protected void onImpact(RayTraceResult result) {
    // TODO Auto-generated method stub
    if (result.entityHit != null)
    {
      result.entityHit.setFire(5);
      this.setDead();
    }else{
      if(this.bounceCount<2){
        this.bounceCount++;
        if(result.sideHit==EnumFacing.DOWN||result.sideHit==EnumFacing.UP){
          this.motionY = -this.motionY;
        }else if(result.sideHit==EnumFacing.SOUTH||result.sideHit==EnumFacing.NORTH){
          this.motionZ = -this.motionZ;
        }else if(result.sideHit==EnumFacing.EAST||result.sideHit==EnumFacing.WEST){
          this.motionX = -this.motionX;
        }
      }else{
        BlockPos position = result.getBlockPos();
        position.add(0,1,0);
        IBlockState hitBlock = myWorld.getBlockState(position);
        if(hitBlock==null||hitBlock.getMaterial() == Material.AIR){
          myWorld.setBlockState(position,Blocks.FIRE.getDefaultState());
        }
        this.setDead();
      }
    }

  }

}
