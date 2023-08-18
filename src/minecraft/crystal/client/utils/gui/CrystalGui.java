package crystal.client.utils.gui;

import crystal.client.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class CrystalGui {

    public static void drawOutline(double x, double y, double width, double height, double lineWidth, int color) {
        Gui.drawRect(x, y, x + width, y + lineWidth, color);
        Gui.drawRect(x, y, x + lineWidth, y + height, color);
        Gui.drawRect(x, y + height - lineWidth, x + width, y + height, color);
        Gui.drawRect(x + width - lineWidth, y, x + width, y + height, color);
    }

    public static void renderItemStack(double x, double y, ItemStack is) {

        if(is == null) {
            return;
        }

        GL11.glPushMatrix();


        if(is.getItem().isDamageable()) {
            double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage()) * 100;
            Client.getCrystal().getFont(10).drawString(String.format("%.2f%%", damage), x + 20, y + 5, -1);
        }

        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(is, x, y);
        RenderHelper.disableStandardItemLighting();

        GL11.glPopMatrix();

    }

    public static void renderItemStacksVertically(double x, double y, ItemStack[] items) {

        if(items == null) {
            return;
        }

        GL11.glPushMatrix();

        int yAdd = 0;
        for(ItemStack is : items) {

            if(is == null) {
                yAdd += 18;
                continue;
            }

            if (is.getItem().isDamageable()) {
                double damage = ((is.getMaxDamage() - is.getItemDamage()) / (double) is.getMaxDamage()) * 100;
                Client.getCrystal().getFont(10).drawString(String.format("%.2f%%", damage), x + 20, y + 5 + yAdd, -1);
            }

            RenderHelper.enableGUIStandardItemLighting();
            Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(is, x, y + yAdd);
            RenderHelper.disableStandardItemLighting();
            yAdd += 18;
        }

        GL11.glPopMatrix();

    }


    public static String colorToHex(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        String hex = String.format("#%02X%02X%02X", red, green, blue);
        return hex;
    }

}
