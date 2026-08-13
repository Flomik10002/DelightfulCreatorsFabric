package flomik.delightfulcreators.block.cutter;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.foundation.block.IBE;
import flomik.delightfulcreators.init.ModBlockEntityTypesRegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

/**
 * Kinetic operator that automates the knife subset of Farmer's Delight cutting-board recipes.
 */
public class MechanicalCutterBlock extends HorizontalKineticBlock implements IBE<MechanicalCutterBlockEntity> {

    public MechanicalCutterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (context instanceof EntityShapeContext entityContext
                && entityContext.getEntity() instanceof PlayerEntity) {
            return AllShapes.CASING_14PX.get(Direction.DOWN);
        }

        return AllShapes.MECHANICAL_PROCESSOR_SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // AssemblyOperatorBlockItem leaves the actual work position two blocks below the cutter.
        return !BasinBlock.isBasin(world, pos.down());
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction preferredSide = getPreferredHorizontalFacing(context);
        if (preferredSide != null) {
            return getDefaultState().with(HORIZONTAL_FACING, preferredSide);
        }
        return super.getPlacementState(context);
    }

    @Override
    public Axis getRotationAxis(BlockState state) {
        return state.get(HORIZONTAL_FACING).getAxis();
    }

    @Override
    public boolean hasShaftTowards(WorldView world, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == state.get(HORIZONTAL_FACING).getAxis();
    }

    @Override
    public Class<MechanicalCutterBlockEntity> getBlockEntityClass() {
        return MechanicalCutterBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalCutterBlockEntity> getBlockEntityType() {
        return ModBlockEntityTypesRegister.MECHANICAL_CUTTER;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
