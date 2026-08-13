package flomik.delightfulcreators.config;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/** Server-side settings shared by dedicated and integrated servers. */
public final class DCServerConfig {

    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    private static boolean registered;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
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
        ConfigRegistry.INSTANCE.register(
                DelightfulCreatorsMod.MOD_ID,
                ModConfig.Type.SERVER,
                SERVER_SPEC);
        registered = true;
    }

    public static final class Server {

        public final ModConfigSpec.BooleanValue mechanicalCutterBasinProcessing;

        private Server(ModConfigSpec.Builder builder) {
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
