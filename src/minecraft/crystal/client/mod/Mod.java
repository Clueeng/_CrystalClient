package crystal.client.mod;

public class Mod {

    public String name;
    public String description;
    public ModCategory category;


    enum ModCategory {
        HUD,
        SERVER,
        MECHANIC,
        MISC
    }
}
