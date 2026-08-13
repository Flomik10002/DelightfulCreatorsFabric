package flomik.delightfulcreators.block.cutter;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.zurrtum.create.client.catnip.render.CachedBuffers;
import com.zurrtum.create.client.catnip.render.SuperByteBuffer;
import com.zurrtum.create.client.content.kinetics.base.KineticBlockEntityRenderer;
import com.zurrtum.create.content.kinetics.press.PressingBehaviour;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/** Renders the kinetic shaft and the animated cutter head. */
public class MechanicalCutterRenderer
        extends KineticBlockEntityRenderer<MechanicalCutterBlockEntity, MechanicalCutterRenderer.MechanicalCutterRenderState> {

    public MechanicalCutterRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public MechanicalCutterRenderState createRenderState() {
        return new MechanicalCutterRenderState();
    }

    @Override
    public void extractRenderState(
            MechanicalCutterBlockEntity be,
            MechanicalCutterRenderState state,
            float tickProgress,
            Vec3 cameraPos,
            @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        super.extractRenderState(be, state, tickProgress, cameraPos, crumblingOverlay);

        BlockState blockState = be.getBlockState();
        PressingBehaviour pressingBehaviour = be.getPressingBehaviour();
        state.head = CachedBuffers.partialFacing(
                ModPartialModels.MECHANICAL_CUTTER_HEAD,
                blockState,
                blockState.getValue(BlockStateProperties.HORIZONTAL_FACING));
        state.offset = -(pressingBehaviour.getRenderedHeadOffset(tickProgress) * pressingBehaviour.mode.headOffset);
    }

    @Override
    protected RenderType getRenderType(MechanicalCutterBlockEntity be, BlockState state) {
        // The head model is cut out, and the shaft renders fine on the same layer.
        return RenderTypes.cutoutMovingBlock();
    }

    @Override
    public boolean shouldRenderOffScreen() {
        return true;
    }

    @Override
    protected BlockState getRenderedBlockState(MechanicalCutterBlockEntity be) {
        return shaft(getRotationAxisOf(be));
    }

    public static class MechanicalCutterRenderState extends KineticRenderState {

        SuperByteBuffer head;
        public float offset;

        @Override
        public void render(PoseStack.Pose matricesEntry, VertexConsumer vertexConsumer) {
            super.render(matricesEntry, vertexConsumer);
            head.translate(0, offset, 0);
            head.light(lightCoords);
            head.renderInto(matricesEntry, vertexConsumer);
        }
    }
}
