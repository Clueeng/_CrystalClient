package crystal.client.mod;

public abstract class DraggableMod extends Mod {

    public int x;
    public int y;

    public int width, height;

    public DraggableMod(String name, ModCategory category) {
        super(name, category);
    }

}
