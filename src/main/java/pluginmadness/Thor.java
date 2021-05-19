package pluginmadness;

import org.bukkit.Material;

import java.util.ArrayList;

public class Thor {
    public static boolean running;
    public static Material target = Material.DIAMOND_AXE;

    public static void start() {
        running = true;
    }

    public static void stop() {
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setHand(Material hand) {
        target = hand;
    }

    public static Material targetHand() {
        return target;
    }
}
