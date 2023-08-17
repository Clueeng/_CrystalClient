package crystal.client.mod;

public class Mod {

    public String name;
    public String description;
    public ModCategory category;

    public boolean enabled;

    public Mod(String name, String description, ModCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
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
