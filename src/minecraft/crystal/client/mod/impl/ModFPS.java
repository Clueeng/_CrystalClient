package crystal.client.mod.impl;

import crystal.client.Client;
import crystal.client.mod.DraggableMod;
import net.minecraft.client.Minecraft;

public class ModFPS extends DraggableMod {

    public ModFPS() {
        super("Test", ModCategory.MISC);
        setDescription("A test mod used for testing purposes");
        setEnabled(true);
    }

    @Override
    public int getWidth() {
        return Client.getCrystal().getFont(24).getStringWidth("FPS 999");
    }

    @Override
    public int getHeight() {
        return Client.getCrystal().getFont(24).getStringHeight("FPS 999");
    }

    @Override
    public int getDefaultX() {
        return 55;
    }

    @Override
    public int getDefaultY() {
        return 10;
    }

    @Override
    public void render() {
        Client.getCrystal().getFont(24).drawString("FPS " + Minecraft.getDebugFPS(), x, y, -1);
    }

    @Override
    public void renderExample() {
        Client.getCrystal().getFont(24).drawString("FPS 999", x, y, -1);
    }

}
