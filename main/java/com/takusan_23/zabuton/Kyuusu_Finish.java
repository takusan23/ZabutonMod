package com.takusan_23.zabuton;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Kyuusu_Finish extends ItemBlock{

	public Kyuusu_Finish(Block block) {
		super(block);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	 @SuppressWarnings("incomplete-switch")
	 public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	 {
	    ItemStack itemstack = player.getHeldItem(hand);
	    IBlockState iblockstate = worldIn.getBlockState(pos);
	    Block block = iblockstate.getBlock();

	    if (block == ZabutonModBlocks.Yunomi)
	    {
           worldIn.setBlockState(pos, ZabutonModBlocks.Ocha.getDefaultState(), 2);
           player.addItemStackToInventory(new ItemStack(ZabutonModItems.Kyuusu));
           itemstack.shrink(1);

	    }

		return EnumActionResult.SUCCESS;

	 }

}
