package com.mrmakeit.fireflower.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.mrmakeit.fireflower.EntityFlowerFireball;
import com.mrmakeit.fireflower.FireFlower;


public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFlowerFireball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FireFlower.fireball, Minecraft.getMinecraft().getRenderItem()));	
	}
}
