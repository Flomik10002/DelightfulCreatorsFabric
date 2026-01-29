package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class DogFoodFluid extends ModFluidsTemplate {

    @Override
    public Fluid getSource() {
        return ModFluidsRegister.STILL_DOG_FOOD;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluidsRegister.FLOWING_DOG_FOOD;
    }

    @Override
    public Item getBucket() {
        return ModFluidsRegister.DOG_FOOD_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return ModFluidsRegister.DOG_FOOD_BLOCK.defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    protected int getDropOff(LevelReader worldView) {
        return 1;
    }

    public static class Flowing extends DogFoodFluid {
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

    public static class Still extends DogFoodFluid {
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