package flomik.delightfulcreators.block.cutter;

import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;

/** Renders the kinetic shaft and the animated cutter head. */
public class MechanicalCutterRenderer extends KineticBlockEntityRenderer<MechanicalCutterBlockEntity> {

    public MechanicalCutterRenderer(BlockEntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public boolean rendersOutsideBoundingBox(MechanicalCutterBlockEntity blockEntity) {
        return true;
    }

    @Override
    protected void renderSafe(
            MechanicalCutterBlockEntity blockEntity,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay) {
        // The cutter has no Flywheel Visual, so render its shaft directly instead of relying on
        // the base renderer's visualization gate.
        BlockState renderedState = getRenderedBlockState(blockEntity);
        RenderLayer renderLayer = getRenderType(blockEntity, renderedState);
        renderRotatingBuffer(
                blockEntity,
                getRotatedModel(blockEntity, renderedState),
                matrices,
                vertexConsumers.getBuffer(renderLayer),
                light);

        BlockState blockState = blockEntity.getCachedState();
        PressingBehaviour pressingBehaviour = blockEntity.getPressingBehaviour();
        float headOffset = pressingBehaviour.getRenderedHeadOffset(tickDelta)
                * pressingBehaviour.mode.headOffset;

        SuperByteBuffer head = CachedBuffers.partialFacing(
                ModPartialModels.MECHANICAL_CUTTER_HEAD,
                blockState,
                blockState.get(HORIZONTAL_FACING));
        head.translate(0, -headOffset, 0)
                .light(light)
                .renderInto(matrices, vertexConsumers.getBuffer(RenderLayer.getCutout()));
    }

    @Override
    protected BlockState getRenderedBlockState(MechanicalCutterBlockEntity blockEntity) {
        return shaft(getRotationAxisOf(blockEntity));
    }
}
