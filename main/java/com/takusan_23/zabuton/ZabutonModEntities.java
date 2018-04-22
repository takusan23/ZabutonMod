package com.takusan_23.zabuton;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ZabutonModEntities {

	public static void register() {
		EntityRegistry.registerModEntity(new ResourceLocation(""), EntityZabutonBlock.class, "sittable", 0, ZabutonMod.Instance, 80, 1, false);
	}
}
