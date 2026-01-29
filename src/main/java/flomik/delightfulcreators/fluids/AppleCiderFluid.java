package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class AppleCiderFluid extends ModFluidsTemplate {

    @Override
    public Fluid getSource() {
        return ModFluidsRegister.STILL_APPLE_CIDER;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_APPLE_CIDER;
    }

    @Override
    public Item getBucket() {
        return ModFluidsRegister.APPLE_CIDER_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return ModFluidsRegister.APPLE_CIDER_BLOCK.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    protected int getFlowSpeed(LevelReader worldView) {
        return 4;
    }

    @Override
    protected int getDropOff(LevelReader worldView) {
        return 1;
    }

    @Override
    public int getTickDelay(LevelReader worldView) {
        return 5;
    }

    public static class Flowing extends AppleCiderFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Still extends AppleCiderFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}