package com.mrmakeit.fireflower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFireball extends Item
{
  public ItemFireball()
  {
    super();
    setMaxStackSize(1);
    this.setUnlocalizedName(FireFlower.MODID + ":" + "fireball"); //Sets the name of this item, Has to be unique!
    this.setCreativeTab(CreativeTabs.COMBAT); //This Item will be in the Combat Creative Tab!
    //this.setTextureName(FireFlower.MODID + ":" + "fireball"); //The texture for this item is the Grenade!
    this.setMaxDamage(200);
  }
  @Override
  public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player){
    return false;
  }
  @Override
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
  {
    if(!world.isRemote){
      if(entity instanceof EntityPlayer){
        EntityPlayer player = (EntityPlayer) entity;
        itemStack.damageItem(1, player);
      }
    }
    if(itemStack.getItemDamage() >= itemStack.getMaxDamage()){
      if(entity instanceof EntityPlayer){
        EntityPlayer player = (EntityPlayer) entity;
        player.inventory.decrStackSize(player.inventory.getSlotFor(itemStack),1);
      }
    }

  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
      EnumHand hand) {
    // TODO Auto-generated method stub
    BlockPos position = playerIn.getPosition();
    worldIn.playSound(playerIn, position, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
    if (!worldIn.isRemote)
    {
        worldIn.spawnEntityInWorld(new EntityFlowerFireball(worldIn, playerIn));
    }
    return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
  }
}
