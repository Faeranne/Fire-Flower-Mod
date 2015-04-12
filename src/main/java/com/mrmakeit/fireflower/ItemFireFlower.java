package com.mrmakeit.fireflower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFireFlower extends ItemFood {
	public ItemFireFlower(int health, boolean edible)
	{
		super(health, edible);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(FireFlower.MODID + ":" + "fireFlower");
		setTextureName(FireFlower.MODID + ":" + "flower");
		setAlwaysEdible();
	}
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player){
		ItemStack fireball = new ItemStack(FireFlower.fireball);
		return fireball;
	}
	
}
