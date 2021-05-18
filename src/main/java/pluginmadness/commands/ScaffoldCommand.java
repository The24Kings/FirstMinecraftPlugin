package pluginmadness.commands;

import pluginmadness.Scaffold;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScaffoldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Location playerLocation = new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());

        if(label.equalsIgnoreCase("scaffold")) {
            if(Scaffold.isRunning()) {
                Scaffold.stop();
            } else Scaffold.start();
        }
        if (label.equalsIgnoreCase("scaffold") && args[0] != null) {
            if(args[0].equalsIgnoreCase("ice")) {
                Scaffold.setMaterial(Material.ICE);
            } else if(args[0].equalsIgnoreCase("packed_ice")) {
                Scaffold.setMaterial(Material.PACKED_ICE);
            } else if(args[0].equalsIgnoreCase("blue_ice")) {
                Scaffold.setMaterial(Material.BLUE_ICE);
            }
        }
        return true;
    }
}
