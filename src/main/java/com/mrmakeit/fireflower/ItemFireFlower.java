package com.mrmakeit.fireflower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemFireFlower extends ItemFood {
	private final String name = "flower";
	public ItemFireFlower(int health, boolean edible)
	{
		super(health, edible);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(FireFlower.MODID + ":" + this.name);
		setAlwaysEdible();
		GameRegistry.registerItem(this, this.name);
	}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player){
		ItemStack fireball = new ItemStack(FireFlower.fireball);
		return fireball;
	}
	
	public String getName()
	{
		return name;
	}
	
}
