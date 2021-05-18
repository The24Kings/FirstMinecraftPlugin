package pluginmadness.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pluginmadness.Scaffold;

public class ScaffoldCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Location playerLocation = new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        
        if (label.equalsIgnoreCase("scaffold") && args.length == 0) {
            if (Scaffold.isRunning()) {
                Scaffold.stop();
            } else {
                Scaffold.start();
            }
            return true;
        }
        
        if (label.equalsIgnoreCase("scaffold")) {
            if (args[0].equalsIgnoreCase("ice")) {
                Scaffold.setMaterial(Material.ICE);
            } else if (args[0].equalsIgnoreCase("packed_ice")) {
                Scaffold.setMaterial(Material.PACKED_ICE);
            } else if (args[0].equalsIgnoreCase("blue_ice")) {
                Scaffold.setMaterial(Material.BLUE_ICE);
            }
        }
        return true;
    }
}
