package crystal.client.mod;

import crystal.client.mod.impl.*;

import java.util.ArrayList;

public class ModManager {

    public ArrayList<Mod> mods;

    public ModManager() {
        this.mods = new ArrayList<>();
        this.mods.add(new TestMod());
    }
}
