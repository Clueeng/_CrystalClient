package crystal.client;

import crystal.client.utils.font.CrystalFontRenderer;
import net.minecraft.util.ResourceLocation;

public class Client {

    public String name, version;
    private static Client crystal;

    public CrystalFontRenderer font;

    public Client() {
        this.name = "Crystal";
        this.version = "Dev";
    }

    public static Client getCrystal() {
        return crystal == null ? crystal = new Client() : crystal;
    }

    public void startup() {
        this.font = new CrystalFontRenderer(
                new ResourceLocation("crystal/fonts/regular.ttf"),
                12
        );

        System.out.println("Debug: Crystal has started.");
    }

    public void shutdown() {
        System.out.println("Debug: Crystal has shutdown.");
    }
}
