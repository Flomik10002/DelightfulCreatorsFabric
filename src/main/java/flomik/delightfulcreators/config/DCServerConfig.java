package flomik.delightfulcreators.config;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

/** Server-side settings shared by dedicated and integrated servers. */
public final class DCServerConfig {

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    private static boolean registered;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        SERVER = new Server(builder);
        SERVER_SPEC = builder.build();
    }

    private DCServerConfig() {
    }

    /** Must be called once from the Fabric common initializer. */
    public static void register() {
        if (registered) {
            return;
        }
        ForgeConfigRegistry.INSTANCE.register(
                DelightfulCreatorsMod.MOD_ID,
                ModConfig.Type.SERVER,
                SERVER_SPEC);
        registered = true;
    }

    public static final class Server {

        public final ForgeConfigSpec.BooleanValue mechanicalCutterBasinProcessing;

        private Server(ForgeConfigSpec.Builder builder) {
            builder.push("mechanicalCutter");

            mechanicalCutterBasinProcessing = builder
                    .comment(
                            "Whether the Mechanical Cutter also processes items placed in a Basin two blocks",
                            "below it, the same way Create's own Mechanical Press does. Disable this to keep",
                            "the Cutter limited to belt/depot and world item processing only.")
                    .define("basinProcessing", true);

            builder.pop();
        }
    }
}
