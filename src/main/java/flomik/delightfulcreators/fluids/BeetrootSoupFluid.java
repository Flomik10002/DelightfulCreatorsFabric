package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jspecify.annotations.NonNull;

public abstract class BeetrootSoupFluid extends ModFluidsTemplate {

    @Override
    public @NonNull Fluid getSource() {
        return ModFluidsRegister.STILL_BEETROOT_SOUP;
    }

    @Override
    public @NonNull Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_BEETROOT_SOUP;
    }

    @Override
    public @NonNull Item getBucket() {
        return ModFluidsRegister.BEETROOT_SOUP_BUCKET;
    }

    @Override
    protected @NonNull BlockState createLegacyBlock(@NonNull FluidState state) {
        return ModFluidsRegister.BEETROOT_SOUP_BLOCK.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    public static class Flowing extends BeetrootSoupFluid {
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
        public boolean isSource(@NonNull FluidState state) {
            return false;
        }

    }

    public static class Still extends BeetrootSoupFluid {
        @Override
        public int getAmount(@NonNull FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(@NonNull FluidState state) {
            return true;
        }
    }
}
