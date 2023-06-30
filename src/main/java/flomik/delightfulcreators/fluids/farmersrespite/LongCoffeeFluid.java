package flomik.delightfulcreators.fluids.farmersrespite;

import flomik.delightfulcreators.fluids.ModFluidsTemplate;
import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class LongCoffeeFluid extends ModFluidsTemplate {

    @Override
    public Fluid getStill() {
        return ModFluidsRegister.STILL_LONG_COFFEE;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_LONG_COFFEE;
    }

    @Override
    public Item getBucketItem() {
        return ModFluidsRegister.LONG_COFFEE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluidsRegister.LONG_COFFEE_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    public static class Flowing extends LongCoffeeFluid {
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

    public static class Still extends LongCoffeeFluid {
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
