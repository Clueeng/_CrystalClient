package crystal.client;

import net.minecraft.util.ResourceLocation;

public class Client {

    public String name, version;
    private static Client crystal;


    public Client() {
        this.name = "Crystal";
        this.version = "Dev";
    }

    public static Client getCrystal() {
        return crystal == null ? crystal = new Client() : crystal;
    }

    public void startup() {
        System.out.println("Debug: Crystal has started.");
    }

    public void shutdown() {
        System.out.println("Debug: Crystal has shutdown.");
    }
}
