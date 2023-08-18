package crystal.client.mod;

import crystal.client.files.ModFileSystem;
import net.minecraft.client.Minecraft;

import java.util.HashMap;
import java.util.Map;

public class Mod {

    public String name;
    public String description;
    public ModCategory category;

    protected Minecraft mc = Minecraft.getMinecraft();

    public boolean enabled;

    public Mod(String name, ModCategory category) {
        this.name = name;
        this.category = category;

        this.description = "";

        if(ModFileSystem.getProperties() == null || !(ModFileSystem.getProperties().containsKey(name))) {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("enabled", false);

            ModFileSystem.addProperty(name, properties);
            System.out.println("Added properties for mod: " + name);
        } else {
            HashMap<String, Object> myProperties = ModFileSystem.getProperties().get(name);
            this.enabled = (boolean) myProperties.get("enabled");
        }
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if(enabled) {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("enabled", true);
            ModFileSystem.addProperty(name, properties);
            onEnable();
        } else {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("enabled", false);
            ModFileSystem.addProperty(name, properties);
            onDisable();
        }
    }

    public void onEnable() {}
    public void onDisable() {}

    public boolean isEnabled() {
        return enabled;
    }

    public ModCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public enum ModCategory {
        HUD,
        SERVER,
        MECHANIC,
        MISC
    }
}
