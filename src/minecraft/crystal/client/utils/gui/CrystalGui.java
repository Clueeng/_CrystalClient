package crystal.client.utils.gui;

import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class CrystalGui {

    public static void drawOutline(double x, double y, double width, double height, double lineWidth, int color) {
        Gui.drawRect(x, y, x + width, y + lineWidth, color);
        Gui.drawRect(x, y, x + lineWidth, y + height, color);
        Gui.drawRect(x, y + height - lineWidth, x + width, y + height, color);
        Gui.drawRect(x + width - lineWidth, y, x + width, y + height, color);
    }

    public static String colorToHex(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        String hex = String.format("#%02X%02X%02X", red, green, blue);
        return hex;
    }

}
