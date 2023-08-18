package crystal.client;

import crystal.client.files.ModFileSystem;
import crystal.client.hud.HUDGui;
import crystal.client.mod.ModManager;
import crystal.client.utils.font.CrystalFontRenderer;
import crystal.client.utils.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.HashMap;

public class Client {

    public String name, version;
    private static Client crystal;

    public CrystalFontRenderer regular11_5;
    public CrystalFontRenderer regular16;

    public ModManager modManager;
    public HUDGui hudGui;

    public HashMap<Float, CrystalFontRenderer> fontSizeToFontRenderer;

    public Client() {
        this.name = "Crystal";
        this.version = "Dev";
    }

    public static Client getCrystal() {
        return crystal == null ? crystal = new Client() : crystal;
    }

    public void startup() {
        fontSizeToFontRenderer = new HashMap<>();
        this.regular11_5 = new CrystalFontRenderer(
                FontUtil.getFontFromTTF(new ResourceLocation("crystal/fonts/regular.ttf"), 11.5F, Font.PLAIN),
                true,
                true
        );
        this.regular16 = regular11_5.derive(Font.PLAIN, 16);
        ModFileSystem.initialise();

        this.modManager = new ModManager();
        this.hudGui = new HUDGui();

        fontSizeToFontRenderer.put(11.5F, regular11_5);
        fontSizeToFontRenderer.put(16F, regular16);

        System.out.println("Debug: Crystal has started.");
    }

    public CrystalFontRenderer getFont(float fontSize) {
        if(fontSizeToFontRenderer.containsKey(fontSize)) {
            return fontSizeToFontRenderer.get(fontSize);
        } else {
            CrystalFontRenderer crystalFontRenderer = regular11_5.derive(0, fontSize);
            fontSizeToFontRenderer.put(fontSize, crystalFontRenderer);
            return crystalFontRenderer;
        }
    }

    public void onKey(int key) {
        if(key == Keyboard.KEY_RSHIFT) {
            Minecraft.getMinecraft().displayGuiScreen(hudGui);
        }
    }

    public void shutdown() {
        System.out.println("Debug: Crystal has shutdown.");
    }
}
