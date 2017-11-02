package com.mrmakeit.fireflower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemFireFlower extends ItemFood {
  public ItemFireFlower(int health, boolean edible)
  {
    super(health, edible);
    setCreativeTab(CreativeTabs.COMBAT);
    setUnlocalizedName(FireFlower.MODID + ":" + "fireFlower");
    setAlwaysEdible();
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
      EnumHand hand) {
    ItemStack fireball = new ItemStack(FireFlower.fireball);
    return super.onItemRightClick(fireball, worldIn, playerIn, hand);
  }

}
