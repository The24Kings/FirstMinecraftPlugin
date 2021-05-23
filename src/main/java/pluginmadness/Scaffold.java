package pluginmadness;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Scaffold {
    public static boolean running;
    public static Material mainMaterial = Material.ICE;
    public static ArrayList<Player> players = new ArrayList<Player>();

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

    public static void add(Player player) {
        players.add(player);
    }

    public static void remove(Player player) {
        players.remove(player);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
