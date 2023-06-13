package flomik.delightfulcreators.init.utils.tags;


import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

public class ModTags {

    public static class ModBlockTags {
    }

    public static class ModItemTags {
    }

    public static class ModFluidTags {

        public static final TagKey<Fluid> TOMATO_SAUCE = createCommonFluidTag("tomato_sauce");

        public static @NotNull TagKey<Fluid> createCommonFluidTag(String modFluidTagName) {
            return TagKey.of(Registry.FLUID_KEY, new Identifier("c", modFluidTagName));
        }
    }
}