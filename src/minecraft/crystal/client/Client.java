package crystal.client;

import crystal.client.utils.font.CrystalFontRenderer;
import crystal.client.utils.font.FontUtil;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class Client {

    public String name, version;
    private static Client crystal;

    public CrystalFontRenderer regular11_5;
    public CrystalFontRenderer regular16;

    public Client() {
        this.name = "Crystal";
        this.version = "Dev";
    }

    public static Client getCrystal() {
        return crystal == null ? crystal = new Client() : crystal;
    }

    public void startup() {
        this.regular11_5 = new CrystalFontRenderer(
                FontUtil.getFontFromTTF(new ResourceLocation("crystal/fonts/regular.ttf"), 11.5F, Font.PLAIN),
                true,
                true
        );
        this.regular16 = regular11_5.derive(Font.PLAIN, 16);

        System.out.println("Debug: Crystal has started.");
    }

    public void shutdown() {
        System.out.println("Debug: Crystal has shutdown.");
    }
}
