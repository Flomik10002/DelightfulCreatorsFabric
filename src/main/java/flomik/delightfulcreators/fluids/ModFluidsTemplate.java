package flomik.delightfulcreators.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class ModFluidsTemplate extends FlowingFluid {

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    @Nullable
    protected ParticleOptions getDripParticle() {
        return null;
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid.equals(getSource()) || fluid.equals(getFlowing());
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropResources(state, world, pos, blockEntity);
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockGetter world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected boolean canConvertToSource(ServerLevel world) {
        return world.getGameRules().get(GameRules.LAVA_SOURCE_CONVERSION);
    }

    // TODO: getFlowSpeed was removed, find a proper replacement
    // Looks like it now only uses getNextTickDelay and getTickRate
    protected int getFlowSpeed(LevelReader worldView) {
        return 2;
    }

    @Override
    protected int getDropOff(LevelReader worldView) {
        return 2;
    }

    @Override
    public int getTickDelay(LevelReader worldView) {
        return 30;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0f;
    }

    @Override
    protected int getSlopeFindDistance(LevelReader world) {
        return 4;
    }
}
