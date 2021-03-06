package com.takusan_23.zabuton;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class OchaItem extends ItemBlock{


	   //** Number of ticks to run while 'EnumAction'ing until result. *//*
//    public final int itemUseDuration;
    //** The amount this food item heals the player. *//*
    private final int healAmount;
//    private final float saturationModifier;
    //** Whether wolves like this food (true for raw and cooked porkchop). *//*
//    private final boolean isWolfsFavoriteMeat;
    /** If this field is true, the food can be consumed even if the player don't need to eat. */
    private boolean alwaysEdible;
    /** represents the potion effect that will occurr upon eating this food. Set by setPotionEffect */
    private PotionEffect potionId;
    /** probably of the set potion effect occurring */
    private float potionEffectProbability;

    public OchaItem(Block block) {
		super(block);
        this.healAmount = 1;
        this.alwaysEdible = true;
        //this.potionEffectProbability = setPotionEffect(Potion., .)
		// TODO 自動生成されたコンストラクター・スタブ
	}

/*    public OchaItem()
    {
        this.itemUseDuration = 32;
        this.healAmount = amount;
        this.isWolfsFavoriteMeat = isWolfFood;
        this.saturationModifier = saturation;
        this.setCreativeTab(CreativeTabs.FOOD);
    }
*/


//	   public OchaItem(int amount, boolean isWolfFood)
//    {
//        this(amount, 0.6F, isWolfFood);
//   }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        EntityPlayer entityplayer = (EntityPlayer)entityLiving;

        //EntityPlayerでクリエイティブモードでないとき（サバイバルモード）
        if (entityLiving instanceof EntityPlayer && !entityplayer.capabilities.isCreativeMode)
        {
         	//ItemFood itemfood = this.healAmount;
            entityplayer.getFoodStats().addStats(this.healAmount, 1.0F);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,100,2));
            entityplayer.addItemStackToInventory(new ItemStack(ZabutonModItems.Yunomi));
            //アイテムを１個消費する
            stack.shrink(1);

        }
        //EntityPlayerでクリエイティブモードのとき
        else if (entityplayer.capabilities.isCreativeMode && entityLiving instanceof EntityPlayer)
        {
        	//ItemFood itemfood = this.healAmount;
            entityplayer.getFoodStats().addStats(this.healAmount, 1.0F);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
            entityplayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,100,2));
            entityplayer.addItemStackToInventory(new ItemStack(ZabutonModItems.Yunomi));


        }

            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }


        return stack;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote && this.potionId != null && worldIn.rand.nextFloat() < this.potionEffectProbability)
        {
            player.addPotionEffect(new PotionEffect(this.potionId));
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //if (playerIn.canEat(this.alwaysEdible))
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
/*        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
*/    }

    public int getHealAmount(ItemStack stack)
    {
        return this.healAmount;
    }


/*
 *
 *
 *
    public int getHealAmount(ItemStack stack)
    {
        return this.healAmount;
    }

    public float getSaturationModifier(ItemStack stack)
    {
        return this.saturationModifier;
    }

    *//**
     * Whether wolves like this food (true for raw and cooked porkchop).
     */
/*    public boolean isWolfsFavoriteMeat()
    {
        return this.isWolfsFavoriteMeat;
    }
*/
    public ItemFood setPotionEffect(PotionEffect effect, float probability)
    {
        this.potionId = effect;
        this.potionEffectProbability = probability;
        return null;
    }

    /**
     * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
     */
    public ItemFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return null;
    }
}