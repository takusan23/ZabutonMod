package com.takusan_23.zabuton;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Kyuusu extends Item {

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        //BlockPos blockpos = raytraceresult.getBlockPos();

        if (raytraceresult == null)
        {
            return new ActionResult(EnumActionResult.PASS, itemstack);
        }
        else
        {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = raytraceresult.getBlockPos();
                
                if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER && !playerIn.capabilities.isCreativeMode)
                {
                    worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    playerIn.addItemStackToInventory(new ItemStack(ZabutonModItems.Kyuusu_Water));
                    itemstack.shrink(1);
                    //return new ActionResult(EnumActionResult.SUCCESS);
                }
                if (worldIn.getBlockState(blockpos).getMaterial() == Material.WATER && playerIn.capabilities.isCreativeMode)
                {
                    worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    playerIn.addItemStackToInventory(new ItemStack(ZabutonModItems.Kyuusu_Water));
                    //return new ActionResult(EnumActionResult.SUCCESS);
                }

            }

            return new ActionResult(EnumActionResult.PASS, itemstack);

        }
    }

}
