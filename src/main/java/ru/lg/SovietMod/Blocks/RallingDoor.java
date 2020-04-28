package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockDoor;

public class RallingDoor extends BasicBlockDoor {
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0, 0.0D, 0.47D, 1.0D, 1.0D, 0.59D);
    
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0, 0.0D, 0.53D, 1.0D, 1.0D, 0.41D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.41D, 0.0D, 0.0D, 0.53D, 1.0D, 1.0D);
    
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.59D, 0.0D, 0.0D, 0.47D, 1.0D, 1.0D);
	public RallingDoor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setCreativeTab(null);
	}
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);


        switch (enumfacing)
        {
            case EAST:
            default:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case NORTH:
                return NORTH_AABB;
        }
    }
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegItems.ralling_door_item);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return RegItems.ralling_door_item;
	}

	@Override
	public SoundEvent getSound() {
		
		return RegSounds.openhermodoor;
	}



}
