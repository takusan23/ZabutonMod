package com.takusan_23.zabuton.proxy;

import com.takusan_23.zabuton.ZabutonModBlocks;
import com.takusan_23.zabuton.ZabutonModEntities;
import com.takusan_23.zabuton.ZabutonModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		ZabutonModBlocks.Init();
		ZabutonModBlocks.register();
		ZabutonModItems.init();
		ZabutonModItems.register();
	}

	public void init(FMLInitializationEvent event)
	{
    	ZabutonModEntities.register();

	}

	public void postInit(FMLPostInitializationEvent event)
	{

	}

}
