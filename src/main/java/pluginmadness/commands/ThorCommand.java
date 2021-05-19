package pluginmadness.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pluginmadness.Thor;

public class ThorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Location playerLocation = new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());

        if (label.equalsIgnoreCase("thor") && args.length == 0) {
            if (Thor.isRunning()) {
                player.sendMessage(ChatColor.GOLD + "Stopped Thor");
                Thor.stop();
            } else {
                player.sendMessage(ChatColor.GOLD + "Started Thor");
                Thor.start();
            }
            return true;
        }
        if (label.equalsIgnoreCase("thor")) {
            if(args[0].equalsIgnoreCase("netherite_axe") ) {
                Thor.setHand(Material.NETHERITE_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            } else if (args[0].equalsIgnoreCase("diamond_axe")) {
                Thor.setHand(Material.DIAMOND_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            } else if(args[0].equalsIgnoreCase("golden_axe")) {
                Thor.setHand(Material.GOLDEN_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            } else if(args[0].equalsIgnoreCase("iron_axe")) {
                Thor.setHand(Material.IRON_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            } else if(args[0].equalsIgnoreCase("stone_axe")) {
                Thor.setHand(Material.STONE_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            } else if(args[0].equalsIgnoreCase("wooden_axe")) {
                Thor.setHand(Material.WOODEN_AXE);
                player.sendMessage(ChatColor.AQUA + "Set Mjǫllnir to '" + args[0] + "'");
            }
            else player.sendMessage(ChatColor.DARK_RED + "Cannot set axe to '" + args[0] + "'");
        }
        return true;
    }
}
