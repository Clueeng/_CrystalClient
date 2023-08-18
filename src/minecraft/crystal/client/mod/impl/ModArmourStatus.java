package crystal.client.mod.impl;

import crystal.client.files.ModFileSystem;
import crystal.client.mod.DraggableMod;
import crystal.client.utils.collections.ArrayUtils;
import crystal.client.utils.gui.CrystalGui;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ModArmourStatus extends DraggableMod {

    private boolean showHelmet, showChestplate, showLeggings, showBoots, showDurability;

    public ModArmourStatus() {
        super("Armour Status", ModCategory.HUD);
        setDescription("Displays your armour on the screen.");
        setEnabled(true);

        // Property setup

        if(ModFileSystem.getProperties().get("Armour Status") == null || ModFileSystem.getProperties().get("Armour Status").isEmpty() || !ModFileSystem.getProperties().get("Armour Status").containsKey("showHelmet")) {
            Map<String, Object> properties = new HashMap<>();
            properties.put("showHelmet", true);
            properties.put("showChestplate", true);
            properties.put("showLeggings", true);
            properties.put("showBoots", true);
            properties.put("showDurability", true);
            ModFileSystem.addProperty("Armour Status", properties);
        } else {
            showHelmet = (boolean) ModFileSystem.getProperties().get("Armour Status").get("showHelmet");
            showChestplate = (boolean) ModFileSystem.getProperties().get("Armour Status").get("showChestplate");
            showLeggings = (boolean) ModFileSystem.getProperties().get("Armour Status").get("showLeggings");
            showBoots = (boolean) ModFileSystem.getProperties().get("Armour Status").get("showBoots");
            showDurability = (boolean) ModFileSystem.getProperties().get("Armour Status").get("showDurability");
        }
    }

    @Override
    public int getWidth() {
        return 20;
    }

    @Override
    public int getHeight() {
        return 68;
    }

    @Override
    public int getDefaultX() {
        return 10;
    }

    @Override
    public int getDefaultY() {
        return 10;
    }

    @Override
    public void render() {
        if(!(mc.thePlayer.inventory.armorInventory.length == 0)) {
            CrystalGui.renderItemStacksVertically(this.x, this.y, ArrayUtils.reverse(mc.thePlayer.inventory.armorInventory));
        }
    }

    @Override
    public void renderExample() {
        ItemStack[] exampleItems = new ItemStack[] {
                new ItemStack(Items.diamond_helmet),
                new ItemStack(Items.diamond_chestplate),
                new ItemStack(Items.diamond_leggings),
                new ItemStack(Items.diamond_boots)
        };

        CrystalGui.renderItemStacksVertically(this.x, this.y, exampleItems);
    }
}
