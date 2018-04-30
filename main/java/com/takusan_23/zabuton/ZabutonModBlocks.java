package com.takusan_23.zabuton;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ZabutonModBlocks {

	public static Block Zabuton;
	public static Block Ocha;
	public static Block Yunomi;
	public static Block Kyuusu;
	public static Block Kyuusu_Finish;

	public static void Init() {
		Zabuton = new ZabutonBlock(Material.CLOTH);
		Ocha = new Ocha(Material.ROCK);
		Yunomi = new Yunomi_Block(Material.ROCK);
		Kyuusu = new Kyuusu_Block(Material.ROCK);
		Kyuusu_Finish = new Kyuusu_Finish_Block(Material.ROCK);
	}

	public static void register() {
		registerItemBlock(Zabuton);
		ForgeRegistries.BLOCKS.register(Ocha);
		ForgeRegistries.BLOCKS.register(Kyuusu);
		ForgeRegistries.BLOCKS.register(Kyuusu_Finish);
		ForgeRegistries.BLOCKS.register(Yunomi);
	}

	public static void registerItemBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}

	public static void registerRenders() {
		regiserRender(Zabuton);
		regiserRender(Ocha);
		regiserRender(Yunomi);
		regiserRender(Kyuusu);
		regiserRender(Kyuusu_Finish);
	}

	public static void regiserRender(net.minecraft.block.Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block),0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}

}
