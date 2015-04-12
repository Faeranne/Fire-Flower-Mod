package com.mrmakeit.fireflower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ItemFireball extends Item
{
	private final String name = "fireball";
	public ItemFireball()
	{
		super();
		setMaxStackSize(1);
		this.setUnlocalizedName(FireFlower.MODID + ":" + this.name); //Sets the name of this item, Has to be unique!
		this.setCreativeTab(CreativeTabs.tabCombat); //This Item will be in the Combat Creative Tab!
		this.setMaxDamage(200);
		GameRegistry.registerItem(this, this.name);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
	    par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	    if (!par2World.isRemote)
	    {
	        par2World.spawnEntityInWorld(new EntityFlowerFireball(par2World, par3EntityPlayer));
	    }
	    return par1ItemStack;
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
				player.inventory.consumeInventoryItem(this);
			}
		}

	}
	
	public String getName()
	{
		return name;
	}
}
