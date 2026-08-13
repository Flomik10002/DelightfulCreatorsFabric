package flomik.delightfulcreators.compat.ponder;

import com.zurrtum.create.content.kinetics.press.PressingBehaviour.Mode;
import com.zurrtum.create.client.foundation.ponder.CreateSceneBuilder;
import com.zurrtum.create.client.foundation.ponder.element.BeltItemElement;
import flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import flomik.delightfulcreators.init.ModBlocksRegister;
import flomik.delightfulcreators.init.ModItemsRegister;
import com.zurrtum.create.catnip.math.Pointing;
import com.zurrtum.create.client.ponder.api.element.ElementLink;
import com.zurrtum.create.client.ponder.api.element.WorldSectionElement;
import com.zurrtum.create.client.ponder.api.scene.SceneBuilder;
import com.zurrtum.create.client.ponder.api.scene.SceneBuildingUtil;
import com.zurrtum.create.client.ponder.api.scene.Selection;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

/** Ponder storyboard based on Create's pressing schematic, with the real cutter substituted. */
public final class CutterScenes {

    private CutterScenes() {
    }

    public static void cutting(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("mechanical_cutter", "Cutting Items with the Mechanical Cutter");
        scene.configureBasePlate(0, 0, 5);
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(5);

        ElementLink<WorldSectionElement> depot =
                scene.world().showIndependentSection(util.select().position(2, 1, 1), Direction.DOWN);
        scene.world().moveSection(depot, util.vector().of(0, 0, 1), 0);
        scene.idle(10);

        Selection cutterSelection = util.select().position(2, 3, 2);
        BlockPos cutterPos = util.grid().at(2, 3, 2);
        BlockPos depotPos = util.grid().at(2, 1, 1);
        scene.world().modifyBlock(
                cutterPos,
                state -> ModBlocksRegister.MECHANICAL_CUTTER.defaultBlockState()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH),
                false);
        scene.world().setKineticSpeed(cutterSelection, 0);
        scene.world().showSection(cutterSelection, Direction.DOWN);
        scene.idle(10);

        scene.world().showSection(util.select().fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 2, 3), Direction.SOUTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 3, 3), Direction.NORTH);
        scene.world().setKineticSpeed(cutterSelection, -32);
        scene.effects().indicateSuccess(cutterPos);
        scene.idle(10);

        Vec3 cutterSide = util.vector().blockSurface(cutterPos, Direction.WEST);
        scene.overlay().showText(60)
                .pointAt(cutterSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Mechanical Cutter can process cutting board recipes on items provided beneath it");
        scene.idle(70);
        scene.overlay().showText(60)
                .pointAt(cutterSide.subtract(0, 2, 0))
                .placeNearTarget()
                .text("The Input items can be dropped or placed on a Depot under the Cutter");
        scene.idle(50);

        ItemStack pumpkinPie = new ItemStack(Items.PUMPKIN_PIE);
        scene.world().createItemOnBeltLike(depotPos, Direction.NORTH, pumpkinPie);
        Vec3 depotCenter = util.vector().centerOf(depotPos.south());
        scene.overlay().showControls(depotCenter, Pointing.UP, 30).withItem(pumpkinPie);
        scene.idle(10);

        Class<MechanicalCutterBlockEntity> type = MechanicalCutterBlockEntity.class;
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour().start(Mode.BELT));
        scene.idle(30);
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour()
                        .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(depotPos);
        ItemStack slices = new ItemStack(ModItemsRegister.PUMPKIN_PIE_SLICE, 4);
        scene.world().createItemOnBeltLike(depotPos, Direction.UP, slices);
        scene.idle(10);
        scene.overlay().showControls(depotCenter, Pointing.UP, 50).withItem(slices);
        scene.idle(60);

        scene.world().hideIndependentSection(depot, Direction.NORTH);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
        scene.idle(10);
        scene.world().showSection(util.select().fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
        scene.idle(20);
        BlockPos beltPos = util.grid().at(0, 1, 2);
        scene.overlay().showText(40)
                .pointAt(util.vector().blockSurface(beltPos, Direction.WEST))
                .placeNearTarget()
                .attachKeyFrame()
                .text("When items are provided on a belt...");
        scene.idle(30);

        ElementLink<BeltItemElement> pie =
                scene.world().createItemOnBelt(beltPos, Direction.SOUTH, pumpkinPie);
        scene.idle(15);
        ElementLink<BeltItemElement> secondPie =
                scene.world().createItemOnBelt(beltPos, Direction.SOUTH, pumpkinPie);
        scene.idle(15);
        scene.world().stallBeltItem(pie, true);
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour().start(Mode.BELT));

        scene.overlay().showText(50)
                .pointAt(cutterSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Cutter will hold and process them automatically");

        scene.idle(30);
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour()
                        .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(cutterPos.below(2));
        pie = scene.world().createItemOnBelt(cutterPos.below(2), Direction.UP, slices);
        scene.world().stallBeltItem(pie, true);
        scene.idle(15);
        scene.world().stallBeltItem(pie, false);
        scene.idle(15);
        scene.world().stallBeltItem(secondPie, true);
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour().start(Mode.BELT));
        scene.idle(30);
        scene.world().modifyBlockEntity(
                cutterPos,
                type,
                cutter -> cutter.getPressingBehaviour()
                        .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(cutterPos.below(2));
        secondPie = scene.world().createItemOnBelt(cutterPos.below(2), Direction.UP, slices);
        scene.world().stallBeltItem(secondPie, true);
        scene.idle(15);
        scene.world().stallBeltItem(secondPie, false);
    }
}
