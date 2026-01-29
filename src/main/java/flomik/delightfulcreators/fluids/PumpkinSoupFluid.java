package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class PumpkinSoupFluid extends ModFluidsTemplate {

    @Override
    public Fluid getSource() {
        return ModFluidsRegister.STILL_PUMPKIN_SOUP;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_PUMPKIN_SOUP;
    }

    @Override
    public Item getBucket() {
        return ModFluidsRegister.PUMPKIN_SOUP_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return ModFluidsRegister.PUMPKIN_SOUP_BLOCK.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    public static class Flowing extends PumpkinSoupFluid {
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

    public static class Still extends PumpkinSoupFluid {
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
