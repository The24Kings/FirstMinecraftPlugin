package pluginmadness;

import org.bukkit.Material;

public class Scaffold {
    public static boolean running;
    public static Material mainMaterial = Material.ICE;

    public static void toggle() {
        running = !running;
    }

    public static void setMaterial(Material material) {
        mainMaterial = material;
    }

    public static boolean isRunning() {
        return running;
    }

    public static Material curMaterial() {
        return mainMaterial;
    }

}
