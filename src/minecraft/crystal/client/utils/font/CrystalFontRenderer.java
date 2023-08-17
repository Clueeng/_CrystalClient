package crystal.client.utils.font;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.newdawn.slick.Color;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.TrueTypeFont;

public class CrystalFontRenderer {

    private TrueTypeFont font;

    public CrystalFontRenderer(ResourceLocation fontLocation, int fontSize) {
        Font awtFont = loadFontFromResource(fontLocation);
        font = new TrueTypeFont(awtFont.deriveFont(Font.PLAIN, fontSize), true);
    }

    private Font loadFontFromResource(ResourceLocation fontLocation) {
        InputStream fontStream = null;
        try {
            fontStream = Minecraft.getMinecraft().getResourceManager().getResource(fontLocation).getInputStream();
            if (fontStream != null) {
                try {
                    return Font.createFont(Font.TRUETYPE_FONT, fontStream);
                } catch (FontFormatException | IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fontStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void renderString(String text, int x, int y, Color color) {
        // Set up OpenGL for 2D rendering
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        font.drawString(x, y, text, color);

        // Clean up OpenGL state
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public void renderStringWithShadow(String text, int x, int y, Color textColor, Color shadowColor, int shadowOffsetX, int shadowOffsetY) {
        renderString(text, x + shadowOffsetX, y + shadowOffsetY, shadowColor);
        renderString(text, x, y, textColor);
    }

    public int getStringWidth(String text) {
        return font.getWidth(text);
    }

    public int getStringHeight() {
        return font.getHeight();
    }
}

