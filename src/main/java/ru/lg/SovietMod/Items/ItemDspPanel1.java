package ru.lg.SovietMod.Items;

import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Entity.EntityDspPanel1;

public class ItemDspPanel1 extends Item
{
	private final Class <? extends EntityHanging > hangingEntityClass;

	public ItemDspPanel1(String name, Class <? extends EntityHanging > entityClass)
	{
		this.hangingEntityClass = entityClass;
		this.setCreativeTab(SovietCore.tabMain);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}


	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		BlockPos blockpos = pos.offset(facing);

		if (facing != EnumFacing.DOWN && facing != EnumFacing.UP) 
		{
			if(!worldIn.isRemote) {
			EntityHanging entityhanging =  new EntityDspPanel1(worldIn, blockpos, facing);
			
				worldIn.spawnEntity(entityhanging);
				entityhanging.playPlaceSound();
				
			}
			itemstack.shrink(1);


			return EnumActionResult.SUCCESS;
		}
		else
		{
			return EnumActionResult.FAIL;
		}
	}
}