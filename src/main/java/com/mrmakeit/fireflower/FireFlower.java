package com.mrmakeit.fireflower;

import com.mrmakeit.fireflower.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
    	GameRegistry.register(fireFlower);
    	GameRegistry.register(fireball);
    	EntityRegistry.registerModEntity(EntityFlowerFireball.class,"itemFireball",4,this,80,3,true);
        proxy.registerRenderers();
        ItemStack redflower = new ItemStack(Blocks.RED_FLOWER);
        ItemStack yellowflower = new ItemStack(Blocks.YELLOW_FLOWER);
        ItemStack firecharge = new ItemStack(Items.FIRE_CHARGE);
        GameRegistry.addShapelessRecipe(new ItemStack(fireFlower), redflower,firecharge);
        GameRegistry.addShapelessRecipe(new ItemStack(fireFlower), yellowflower,firecharge);
    }



}
