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
        }
    }

    public void toggle() {
         this.enabled = !this.enabled;
        if(enabled) {
            onEnable();
        } else {
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
