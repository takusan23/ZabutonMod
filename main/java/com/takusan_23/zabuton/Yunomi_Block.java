package com.takusan_23.zabuton;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Yunomi_Block extends Block {

		public static final PropertyDirection FACING;

		public Yunomi_Block(Material materialIn) {
			super(Material.CIRCUITS);
			setCreativeTab(ZabutonMod.ZabutonModTab);
			setHardness(2.0F);
			setSoundType(blockSoundType.STONE);
			setUnlocalizedName("Yunomi_Block");
			setRegistryName("yunomi_block");
	        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}
		  static {
				FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
		   }

/*		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
		{
	        double d0 = (double)((float)pos.getX() + 0.4F + rand.nextFloat() * 0.2F);
	        double d1 = (double)((float)pos.getY() + 0.7F + rand.nextFloat() * 0.3F);
	        double d2 = (double)((float)pos.getZ() + 0.4F + rand.nextFloat() * 0.2F);

	        worldIn.spawnParticle(EnumParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
*/
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			return new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.4D, 0.6875D);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state)
		{
			return false;
		}

		@Override
		public boolean isFullCube(IBlockState state)
		{
			return false;
		}
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	    {
	        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	    }


	    public IBlockState withRotation(IBlockState state, Rotation rot)
	    {
	        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	    }


	    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	    {
	        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	    }


	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	    }


	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	    }


	    public int getMetaFromState(IBlockState state)
	    {
	        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {FACING});
	    }

}
