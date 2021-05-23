package pluginmadness.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pluginmadness.Thor;

public class ThorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Location playerLocation = new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        ItemStack inHand = player.getInventory().getItemInMainHand();

        if (args.length == 0 && label.equalsIgnoreCase("thor")) {
            if (Thor.isRunning()) {
                player.sendMessage(ChatColor.GOLD + "Stopped thor");
            } else player.sendMessage(ChatColor.GOLD + "Started thor");
            Thor.toggle();
            return true;
        }
        if (label.equalsIgnoreCase("thor")) {
            if(args[0].equalsIgnoreCase("set")) {
                if (inHand.getType().toString().contains("AXE")) {
                    Thor.setHand(inHand);
                    player.sendMessage(ChatColor.GOLD + "Successfully Set axe!");
                } else player.sendMessage(ChatColor.DARK_RED + "Not an axe!");
            }
        }
        return true;
    }
}
