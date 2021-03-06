package pluginmadness.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pluginmadness.PluginMadness;
import pluginmadness.Scaffold;

public class ScaffoldCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        World world = player.getWorld();
        Location playerLocation = player.getLocation();
        
        if(label.equalsIgnoreCase("scaffold") && args.length == 0) {
            if(Scaffold.isRunning()) {
                player.sendMessage(ChatColor.GOLD + "Stopped scaffold");
            } else player.sendMessage(ChatColor.GOLD + "Started scaffold");
            Scaffold.toggle();
            return true;
        }
        
        if (label.equalsIgnoreCase("scaffold")) {
            if(args[0].equalsIgnoreCase("ice")) {
                Scaffold.setMaterial(Material.ICE);
                player.sendMessage(ChatColor.AQUA + "Set Scaffold to 'minecraft:ice'");
            } else if(args[0].equalsIgnoreCase("packed_ice")) {
                Scaffold.setMaterial(Material.PACKED_ICE);
                player.sendMessage(ChatColor.AQUA + "Set Scaffold to 'minecraft:packed_ice'");
            } else if(args[0].equalsIgnoreCase("blue_ice")) {
                Scaffold.setMaterial(Material.BLUE_ICE);
                player.sendMessage(ChatColor.AQUA + "Set Scaffold to 'minecraft:blue_ice'");
            } else if(args[0].equalsIgnoreCase("add_player")) {
                if(args.length > 1) {
                    Player selPlayer = PluginMadness.getPlugin().getServer().getPlayer(args[1]);
                    if(world.getPlayers().contains(selPlayer)) {
                        Scaffold.add(selPlayer);
                        player.sendMessage(ChatColor.AQUA + "Added: " + ChatColor.WHITE + player.getName());
                    } else player.sendMessage(ChatColor.DARK_RED + "Player does not exist!");
                } else player.sendMessage(ChatColor.DARK_RED + "Requires player name!");
            } else if(args[0].equalsIgnoreCase("remove_player")) {
                if(args.length > 1) {
                    Player selPlayer = PluginMadness.getPlugin().getServer().getPlayer(args[1]);
                    if(world.getPlayers().contains(selPlayer)) {
                        Scaffold.remove(selPlayer);
                        player.sendMessage(ChatColor.RED + "Removed: " + ChatColor.WHITE + player.getName());
                    } else player.sendMessage(ChatColor.DARK_RED + "Player does not exist!");
                } else player.sendMessage(ChatColor.DARK_RED + "Requires player name!");
            } else player.sendMessage(ChatColor.DARK_RED + "Invalid Syntax!");
        }
        return true;
    }
}
