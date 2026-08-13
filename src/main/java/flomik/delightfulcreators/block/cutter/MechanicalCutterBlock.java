package flomik.delightfulcreators.block.cutter;

import com.zurrtum.create.AllShapes;
import com.zurrtum.create.content.kinetics.base.HorizontalKineticBlock;
import com.zurrtum.create.content.processing.basin.BasinBlock;
import com.zurrtum.create.foundation.block.IBE;
import flomik.delightfulcreators.init.ModBlockEntityTypesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Kinetic operator that automates the knife subset of Farmer's Delight cutting-board recipes.
 */
public class MechanicalCutterBlock extends HorizontalKineticBlock implements IBE<MechanicalCutterBlockEntity> {

    public MechanicalCutterBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityContext
                && entityContext.getEntity() instanceof Player) {
            return AllShapes.CASING_14PX.get(Direction.DOWN);
        }

        return AllShapes.MECHANICAL_PROCESSOR_SHAPE;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // AssemblyOperatorBlockItem leaves the actual work position two blocks below the cutter.
        return !BasinBlock.isBasin(level, pos.below());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction preferredSide = getPreferredHorizontalFacing(context);
        if (preferredSide != null) {
            return defaultBlockState().setValue(HORIZONTAL_FACING, preferredSide);
        }
        return super.getStateForPlacement(context);
    }

    @Override
    public Axis getRotationAxis(BlockState state) {
        return state.getValue(HORIZONTAL_FACING).getAxis();
    }

    @Override
    public boolean hasShaftTowards(LevelReader level, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == state.getValue(HORIZONTAL_FACING).getAxis();
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
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
