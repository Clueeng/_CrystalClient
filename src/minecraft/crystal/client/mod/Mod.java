package crystal.client.mod;

import net.minecraft.client.Minecraft;

public class Mod {

    public String name;
    public String description;
    public ModCategory category;

    protected Minecraft mc = Minecraft.getMinecraft();

    public boolean enabled;

    public Mod(String name, ModCategory category) {
        this.name = name;
        this.category = category;

        if(this.description == null) {
            this.description = "";
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

    enum ModCategory {
        HUD,
        SERVER,
        MECHANIC,
        MISC
    }
}
