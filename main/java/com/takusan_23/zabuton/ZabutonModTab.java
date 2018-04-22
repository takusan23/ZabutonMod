package com.takusan_23.zabuton;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ZabutonModTab extends CreativeTabs{

	public ZabutonModTab(String label) {
		super(label);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ZabutonModBlocks.Zabuton);
	}
}
