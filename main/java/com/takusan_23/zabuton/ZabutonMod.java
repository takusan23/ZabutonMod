package com.takusan_23.zabuton;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

	@Mod(modid = ZabutonMod.MOD_ID,
	        name = ZabutonMod.MOD_NAME,
	        version = ZabutonMod.MOD_VERSION,
	        dependencies = ZabutonMod.MOD_DEPENDENCIES,
	        acceptedMinecraftVersions = ZabutonMod.MOD_ACCEPTED_MC_VERSIONS,
	        useMetadata = true)
	@EventBusSubscriber
	public class ZabutonMod{
	    public static final String MOD_ID = "zabutonmod";
	    public static final String MOD_NAME = "Zabuton Mod";
	    public static final String MOD_VERSION = "Depelopper Version 1.0";
	    public static final String MOD_DEPENDENCIES ="required-after:forge@[1.12.2-14.23.2.2655,)";
	    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
	    public static final String CLIENT_PROXY_CLASS = "com.takusan_23.zabuton.proxy.ClientProxy";
	    public static final String COMMON_PROXY_CLASS = "com.takusan_23.zabuton.proxy.CommonProxy";
	    public static final String SERVER_PROXY_CLASS = "com.takusan_23.zabuton.proxy.ServerProxy";

	    public static CreativeTabs ZabutonModTab = new ZabutonModTab("ZabutonModTab");

	    @SidedProxy(clientSide = ZabutonMod.CLIENT_PROXY_CLASS, serverSide = ZabutonMod.SERVER_PROXY_CLASS)
	    public static com.takusan_23.zabuton.proxy.CommonProxy proxy;

	    @Instance
	    public static ZabutonMod Instance;

	    @Mod.EventHandler
	    public void construct(FMLConstructionEvent event)
	    {
	    	MinecraftForge.EVENT_BUS.register(this);
	    }

	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {
	    	ZabutonModBlocks.Init();
	    	ZabutonModBlocks.register();
	    	ZabutonModItems.init();
	    	ZabutonModItems.register();
	    }
	    @EventHandler
	    public void Init(FMLInitializationEvent event)
	    {
	    	proxy.init(event);
	    	ZabutonModEntities.register();
	    }
}
