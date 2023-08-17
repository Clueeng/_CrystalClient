package crystal.client;

public class Client {

    public String name, version;
    private static Client crystal;

    public Client() {
        this.name = name;
        this.version = version;
    }

    public static Client getCrystal() {
        return crystal == null ? crystal = new Client() : crystal;
    }
}
