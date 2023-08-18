package crystal.client.mod;

import crystal.client.mod.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModManager {

    public ArrayList<Mod> mods;

    public ModManager() {
        this.mods = new ArrayList<>();
        this.mods.add(new TestMod());
        this.mods.add(new ModFPS());
        this.mods.add(new ModArmourStatus());
    }

    public ArrayList<Mod> getMods() {
        return mods;
    }

    public List<DraggableMod> getDraggableMods() {
        return mods.stream()
                .filter(m -> m instanceof DraggableMod)
                .map(m -> (DraggableMod) m)
                .collect(Collectors.toList());
    }

    public List<DraggableMod> getEnabledDraggableMods() {
        return mods.stream()
                .filter(m -> m instanceof DraggableMod && m.isEnabled())
                .map(m -> (DraggableMod) m)
                .collect(Collectors.toList());
    }

    public List<Mod> getEnabledMods() {
        return mods.stream()
                .filter(Mod::isEnabled)
                .collect(Collectors.toList());
    }
}
