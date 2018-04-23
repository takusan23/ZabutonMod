package com.takusan_23.zabuton;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ZabutonModItems {
	public static Item OchaItem;
	public static Item Yunomi;

	public static void init()
	{
		OchaItem = new OchaItem(ZabutonModBlocks.Ocha).setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Ocha");
		Yunomi = new Item().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Yumomi");
	}

	public static void register()
	{
		registerItem(OchaItem, "ochaitem");
		registerItem(Yunomi, "yumomi");
	}

	public static void registerItem(Item item, String string)
	{
		item.setRegistryName(new ResourceLocation(ZabutonMod.MOD_ID,string));
		ForgeRegistries.ITEMS.register(item);
	}

	public static void registerRenders()
	{
		registerRender(OchaItem);
		registerRender(Yunomi);
	}

	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
