package crystal.client;

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

    }

    public void shutdown() {

    }
}
