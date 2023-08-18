package crystal.client.mod.impl;

import crystal.client.Client;
import crystal.client.mod.DraggableMod;
import crystal.client.mod.Mod;

public class TestMod extends DraggableMod {

    public TestMod() {
        super("Test", ModCategory.MISC);
        setDescription("A test mod used for testing purposes");
    }

    @Override
    public int getWidth() {
        return Client.getCrystal().getFont(24).getStringWidth("Test");
    }

    @Override
    public int getHeight() {
        return Client.getCrystal().getFont(24).getStringHeight("Test");
    }

    @Override
    public int getDefaultX() {
        return 45;
    }

    @Override
    public int getDefaultY() {
        return 10;
    }

    @Override
    public void render() {
        Client.getCrystal().getFont(24).drawString("Test", x, y, -1);
    }

    @Override
    public void renderExample() {
        Client.getCrystal().getFont(24).drawString("Test", x, y, -1);
    }

}
