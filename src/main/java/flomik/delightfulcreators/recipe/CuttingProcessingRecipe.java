package flomik.delightfulcreators.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zurrtum.create.content.processing.recipe.ChanceOutput;
import com.zurrtum.create.foundation.recipe.CreateSingleStackRollableRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

/**
 * A Mechanical Cutter step that can be embedded in Create Sequenced Assembly recipes. Mirrors how
 * Create's own Mechanical Press plugs in via {@code create:pressing}, but keeps the up-to-four
 * chance results a cutting recipe needs.
 */
public record CuttingProcessingRecipe(List<ChanceOutput> results, Ingredient ingredient)
        implements CreateSingleStackRollableRecipe {

    /** Matches the output limit the Forge edition's processing recipe used. */
    public static final int MAX_RESULTS = 4;

    @Override
    public RecipeSerializer<CuttingProcessingRecipe> getSerializer() {
        return DCRecipeTypes.CUTTING_PROCESSING_SERIALIZER;
    }

    @Override
    public RecipeType<CuttingProcessingRecipe> getType() {
        return DCRecipeTypes.CUTTING_PROCESSING;
    }

    public static class Serializer implements RecipeSerializer<CuttingProcessingRecipe> {

        public static final MapCodec<CuttingProcessingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                ChanceOutput.CODEC.listOf(1, MAX_RESULTS).fieldOf("results").forGetter(CuttingProcessingRecipe::results),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(CuttingProcessingRecipe::ingredient)
        ).apply(instance, CuttingProcessingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CuttingProcessingRecipe> PACKET_CODEC = StreamCodec.composite(
                ChanceOutput.PACKET_CODEC.apply(ByteBufCodecs.list()),
                CuttingProcessingRecipe::results,
                Ingredient.CONTENTS_STREAM_CODEC,
                CuttingProcessingRecipe::ingredient,
                CuttingProcessingRecipe::new
        );

        @Override
        public MapCodec<CuttingProcessingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CuttingProcessingRecipe> streamCodec() {
            return PACKET_CODEC;
        }
    }
}
