package com.mrmakeit.fireflower;

import com.mrmakeit.fireflower.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = FireFlower.MODID, version = FireFlower.VERSION)
public class FireFlower
{
    public static final String MODID = "fireflower";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide="com.mrmakeit.fireflower.proxy.ClientProxy", serverSide="com.mrmakeit.fireflower.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    public static Item fireball;
    public static Item fireFlower;
    
    @EventHandler
    public void load(FMLPreInitializationEvent event)
    {
    	fireFlower = new ItemFireFlower(0, true);
    	fireball = new ItemFireball();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerItem(fireFlower, "Fire Flower");
    	GameRegistry.registerItem(fireball, "Fire Flower Fireball");
    	EntityRegistry.registerModEntity(EntityFlowerFireball.class,"itemFireball",4,this,80,3,true);
        proxy.registerRenderers();
        ItemStack redflower = new ItemStack(Blocks.red_flower);
        ItemStack yellowflower = new ItemStack(Blocks.yellow_flower);
        ItemStack firecharge = new ItemStack(Items.fire_charge);
        GameRegistry.addShapelessRecipe(new ItemStack(fireFlower), redflower,firecharge);
        GameRegistry.addShapelessRecipe(new ItemStack(fireFlower), yellowflower,firecharge);
    }



}
