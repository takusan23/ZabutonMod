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
	public static Item Yunomi_unfinished;
	public static Item Yunomi_Water;
	public static Item Yunomi_Ocha;
	public static Item OCha_Hot;
	public static Item Ocha_ice;
	public static Item Kyuusu;
	public static Item Kyuusu_Water;
	public static Item Kyuusu_Ocha;
	public static Item Kyuusu_Finish;

	public static void init()
	{
		OchaItem = new OchaItem(ZabutonModBlocks.Ocha).setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Ocha");
		Yunomi = new Yunomi(ZabutonModBlocks.Yunomi).setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Yunomi");
		Yunomi_unfinished = new Item().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Yunomi(Unfinished)");
//		Yunomi_Water = new Yunomi_Water().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Yunomi_Water");
		Yunomi_Ocha = new Yunomi_Ocha().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Yunomi_Ocha");
		Kyuusu = new Kyuusu().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Kyuusu");
		Kyuusu_Water = new Kyuusu_Water().setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Kyuusu_Water");
		Kyuusu_Ocha = new Kyuusu_Ocha(ZabutonModBlocks.Kyuusu).setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Kyuusu_Ocha");
		Kyuusu_Finish = new Kyuusu_Finish(ZabutonModBlocks.Kyuusu_Finish).setCreativeTab(ZabutonMod.ZabutonModTab).setUnlocalizedName("Kyuusu_Finish");
	}

	public static void register()
	{
		registerItem(OchaItem, "ochaitem");
		registerItem(Yunomi, "yunomi");
		registerItem(Yunomi_unfinished,"yunomi_unfinished");
		registerItem(Yunomi_Ocha, "yunomi_ocha");
		registerItem(Kyuusu,"kyuusu");
		registerItem(Kyuusu_Water,"kyuusu_water");
		registerItem(Kyuusu_Ocha,"kyuusu_ocha");
		registerItem(Kyuusu_Finish ,"kyuusu_finish");
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
		registerRender(Yunomi_unfinished);
		registerRender(Yunomi_Ocha);
		registerRender(Kyuusu);
		registerRender(Kyuusu_Water);
		registerRender(Kyuusu_Ocha);
		registerRender(Kyuusu_Finish);

	}

	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}



}
