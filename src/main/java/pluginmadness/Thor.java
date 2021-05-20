package pluginmadness;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Thor {
    public static boolean running;
    public static ItemStack target = new ItemStack(Material.DIAMOND_AXE);

    public static void start() {
        running = true;
    }

    public static void stop() {
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setHand(ItemStack hand) {
        target = hand;
    }

    public static ItemStack targetHand() {
        return target;
    }
}
