package crystal.client.mod;

import crystal.client.files.ModFileSystem;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class DraggableMod extends Mod {

    public double x;
    public double y;

    public double scale;
    public Color color;

    public DraggableMod(String name, ModCategory category) {
        super(name, category);
        this.scale = 1;
        this.x = getDefaultX();
        this.y = getDefaultY();
        this.color = Color.white;

        if(!ModFileSystem.getProperties().get(name).containsKey("x")) {
            Map<String, Object> properties = new HashMap<>();
            properties.put("x", getDefaultX());
            properties.put("y", getDefaultY());
            properties.put("color", "#ffffff");
            properties.put("scale", 1);

            ModFileSystem.addProperty(name, properties);
            System.out.println("Added draggable properties for mod: " + name);
        } else {
            HashMap<String, Object> myProperties = ModFileSystem.getProperties().get(name);
            this.x = (double) myProperties.get("x");
            this.y = (double) myProperties.get("y");
            this.scale = (double) myProperties.get("scale");
            this.color = Color.decode((String) myProperties.get("color"));
        }
    }

    public abstract int getWidth();
    public abstract int getHeight();

    public abstract int getDefaultX();
    public abstract int getDefaultY();

    public abstract void render();

    public abstract void renderExample();

    public void moveOffset(int x, int y) {
        this.x += x;
        this.y += y;

        Map<String, Object> properties = new HashMap<>();
        properties.put("x", this.x);
        properties.put("y", this.y);
        ModFileSystem.addProperty(name, properties);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        Map<String, Object> properties = new HashMap<>();
        properties.put("x", this.x);
        properties.put("y", this.y);
        ModFileSystem.addProperty(name, properties);
    }

}
