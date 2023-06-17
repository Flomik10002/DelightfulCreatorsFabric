package flomik.delightfulcreators.fluids.farmersdelightfluids;

import flomik.delightfulcreators.fluids.ModFluidsRegister;
import flomik.delightfulcreators.fluids.ModFluidsTemplate;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class SweetBerryStuffingFluid extends ModFluidsTemplate {

    @Override
    public Fluid getStill() {
        return ModFluidsRegister.STILL_SWEET_BERRY_STUFFING;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_SWEET_BERRY_STUFFING;
    }

    @Override
    public Item getBucketItem() {
        return ModFluidsRegister.SWEET_BERRY_STUFFING_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluidsRegister.SWEET_BERRY_STUFFING_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    public static class Flowing extends SweetBerryStuffingFluid {
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

    public static class Still extends SweetBerryStuffingFluid {
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
