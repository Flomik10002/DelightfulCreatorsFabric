package flomik.delightfulcreators.fluids.farmersrespite;

import flomik.delightfulcreators.fluids.ModFluidsTemplate;
import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

public abstract class LongBlackTeaFluid extends ModFluidsTemplate {

    @Override
    public Fluid getStill() {
        return ModFluidsRegister.STILL_LONG_BLACK_TEA;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_LONG_BLACK_TEA;
    }

    @Override
    public Item getBucketItem() {
        return ModFluidsRegister.LONG_BLACK_TEA_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluidsRegister.LONG_BLACK_TEA_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected int getFlowSpeed(WorldView worldView) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 1;
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 5;
    }

    public static class Flowing extends LongBlackTeaFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends LongBlackTeaFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}