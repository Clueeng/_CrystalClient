package crystal.client.hud;

import crystal.client.Client;
import crystal.client.mod.DraggableMod;
import crystal.client.utils.gui.CrystalGui;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.util.List;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

// GUI for moving de mods
public class HUDGui extends GuiScreen {
    private static final int OUTLINE_OFFSET = 3;
    private static final int OUTLINE_COLOR = Color.white.getRGB();

    private DraggableMod selectedMod;
    private int tempX, tempY;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawDefaultBackground();

        List<DraggableMod> enabledMods = Client.getCrystal().modManager.getEnabledDraggableMods();
        for (DraggableMod mod : enabledMods) {
            mod.renderExample();
            CrystalGui.drawOutline(mod.x - OUTLINE_OFFSET, mod.y - OUTLINE_OFFSET,
                    mod.getWidth() + OUTLINE_OFFSET, mod.getHeight() + OUTLINE_OFFSET, 1, OUTLINE_COLOR);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClickMove(int x, int y, int button, long time) {
        if (selectedMod != null) {
            selectedMod.moveOffset(x - tempX, y - tempY);
        }

        tempX = x;
        tempY = y;
        super.mouseClickMove(x, y, button, time);
    }

    @Override
    protected void mouseClicked(int x, int y, int mb) throws IOException {
        tempX = x;
        tempY = y;

        List<DraggableMod> enabledMods = Client.getCrystal().modManager.getEnabledDraggableMods();

        Optional<DraggableMod> hoveredMod = enabledMods.stream().filter(mod ->
                x >= mod.x && x <= mod.x + mod.getWidth() &&
                        y >= mod.y && y <= mod.y + mod.getHeight()
        ).findFirst();

        hoveredMod.ifPresent(draggableMod -> {
            selectedMod = draggableMod;
            System.out.println("Mod found: " + selectedMod.name);
        });

        super.mouseClicked(x, y, mb);
    }
}
