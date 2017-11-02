package com.mrmakeit.fireflower.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import com.mrmakeit.fireflower.EntityFlowerFireball;
import com.mrmakeit.fireflower.FireFlower;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFlowerFireball.class, new RenderSnowball(FireFlower.fireball));	
	}
}
