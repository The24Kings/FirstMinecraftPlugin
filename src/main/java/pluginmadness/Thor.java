package pluginmadness;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Thor {
    public static boolean running;
    public static ItemStack target = new ItemStack(Material.DIAMOND_AXE);

    public static void toggle() {
        running = !running;
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
