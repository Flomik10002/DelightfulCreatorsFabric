package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class BeefStewFluid extends ModFluidsTemplate {

    @Override
    public Fluid getSource() {
        return ModFluidsRegister.STILL_BEEF_STEW;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_BEEF_STEW;
    }

    @Override
    public Item getBucket() {
        return ModFluidsRegister.BEEF_STEW_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return ModFluidsRegister.BEEF_STEW_BLOCK.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    public static class Flowing extends BeefStewFluid {
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

    public static class Still extends BeefStewFluid {
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
