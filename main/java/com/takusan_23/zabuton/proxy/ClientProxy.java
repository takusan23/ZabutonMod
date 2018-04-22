package com.takusan_23.zabuton.proxy;

import com.takusan_23.zabuton.ZabutonModBlocks;
import com.takusan_23.zabuton.ZabutonModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		ZabutonModBlocks.Init();
		ZabutonModBlocks.register();
		ZabutonModItems.init();
		ZabutonModItems.register();
	}

	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		ZabutonModBlocks.registerRenders();
		ZabutonModItems.registerRenders();
	}

	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);

	}

	public static void registerItems(RegistryEvent.Register<Item> event)
	{

	}

    public static void registerBlock(RegistryEvent.Register<Block> event)
    {

    }

   public static void registerModels(ModelRegistryEvent event)
   {

   }

}
