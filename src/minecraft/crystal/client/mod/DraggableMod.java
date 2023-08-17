package crystal.client.mod;

public abstract class DraggableMod extends Mod {

    public int x;
    public int y;

    public float scale;

    public DraggableMod(String name, ModCategory category) {
        super(name, category);
        this.scale = 1;
    }

    public abstract int getWidth();
    public abstract int getHeight();

}
