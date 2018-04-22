package com.takusan_23.zabuton;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ZabutonBlock extends BlockHorizontal {

	public static final PropertyDirection FACING;

	public ZabutonBlock(Material materialIn) {
		super(Material.CLOTH);
		setCreativeTab(ZabutonMod.ZabutonModTab);
		setHardness(0.8F);
		setSoundType(blockSoundType.CLOTH);
		setUnlocalizedName("Zabuton");
		setRegistryName("zabuton");
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

	}
	   static {
			FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	   }
		//当たり判定
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.25D, 0.9375D);
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

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!playerIn.isSneaking()) {
			if (ZabutonUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 7 * 0.0625)) {
				worldIn.updateComparatorOutputLevel(pos, this);
				return true;
			}
		}
		return false;
	}

/*	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
*/
	/*
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_)
	{
		if (!(entityIn instanceof EntitySittableBlock)) {
			List<AxisAlignedBB> list = getCollisionBoxList(this.getActualState(state, worldIn, pos));
			for (AxisAlignedBB box : list) {
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, box);
			}
		}
	}
*/
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
		state = state.withProperty(FACING, placer.getHorizontalFacing());
		return state;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state)
	{
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return ZabutonUtil.isSomeoneSitting(worldIn, pos.getX(), pos.getY(), pos.getZ()) ? 1 : 0;
	}

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }


/*	private List<AxisAlignedBB> getCollisionBoxList(IBlockState state)
	{
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
		EnumFacing facing = state.getValue(FACING);
		switch (facing) {
		case NORTH:
			list.add(CHAIR_BACKREST_NORTH);
			break;
		case SOUTH:
			list.add(CHAIR_BACKREST_SOUTH);
			break;
		case WEST:
			list.add(CHAIR_BACKREST_WEST);
			break;
		default:
			list.add(CHAIR_BACKREST_EAST);
			break;
		}
		list.add(CHAIR_SEAT);
		for (int i = 0; i < LEGS.length; i++) {
			list.add(LEGS[i]);
		}
		return list;
	}
*/
/*	@Override
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end)
	{
		List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, worldIn, pos))) {
			list.add(this.rayTrace(pos, start, end, axisalignedbb));
		}

		RayTraceResult raytraceresult1 = null;
		double d1 = 0.0D;

		for (RayTraceResult raytraceresult : list) {
			if (raytraceresult != null) {
				double d0 = raytraceresult.hitVec.squareDistanceTo(end);

				if (d0 > d1) {
					raytraceresult1 = raytraceresult;
					d1 = d0;
				}
			}
		}

		return raytraceresult1;
	}*/
}

