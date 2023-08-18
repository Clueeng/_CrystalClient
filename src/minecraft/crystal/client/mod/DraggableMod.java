package crystal.client.mod;

import crystal.client.files.ModFileSystem;

import java.util.HashMap;
import java.util.Map;

public abstract class DraggableMod extends Mod {

    public int x;
    public int y;

    public float scale;

    public DraggableMod(String name, ModCategory category) {
        super(name, category);
        this.scale = 1;

        if(!ModFileSystem.getProperties().get(name).containsKey("x")) {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("x", getDefaultX());
            properties.put("y", getDefaultY());
            properties.put("color", "#ffffff");
            properties.put("scale", 1);

            ModFileSystem.addProperty(name, properties);
            System.out.println("Added draggable properties for mod: " + name);
        }
    }

    public abstract int getWidth();
    public abstract int getHeight();

    public abstract int getDefaultX();
    public abstract int getDefaultY();

    public abstract void render();

    public abstract void renderExample();

}
