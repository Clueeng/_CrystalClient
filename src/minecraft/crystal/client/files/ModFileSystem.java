package crystal.client.files;

import com.google.gson.reflect.TypeToken;
import net.minecraft.client.Minecraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class ModFileSystem {

    public static File crystalFolder = new File(Minecraft.getMinecraft().mcDataDir, "CrystalClient");
    public static File modDataFile = new File(crystalFolder, "data.txt");

    public static void initialise() {
        try {
            if (!crystalFolder.exists()) {
                crystalFolder.mkdirs();
            }
            if (!modDataFile.exists()) {
                modDataFile.createNewFile();
            }
        } catch(IOException io) {
            System.err.println("Error in the Mod File System.");
            io.printStackTrace();
        }
    }


    // use like getProperties().get("Armour Status").get("x")
    public static void addProperty(String name, Map<String, Object> property) {
        try {
            Map<String, HashMap<String, Object>> existingProperties = getProperties();

            if(existingProperties == null) {
                existingProperties = new HashMap<>();
                existingProperties.put(name, new HashMap<>(property));
            }
            else if (existingProperties.containsKey(name)) {
                HashMap<String, Object> currentProperty = existingProperties.get(name);
                currentProperty.putAll(property);
            } else {
                existingProperties.put(name, new HashMap<>(property));
            }

            try (Writer writer = new FileWriter(modDataFile)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(existingProperties, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, HashMap<String, Object>> getProperties() {
        try (Reader reader = new FileReader(modDataFile)) {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, HashMap<String, Object>>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

}
