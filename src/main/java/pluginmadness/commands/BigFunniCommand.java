package pluginmadness.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pluginmadness.BigFunni;

public class BigFunniCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("funni") && args.length == 0) {
            if (BigFunni.isRunning()) {
                player.sendMessage(ChatColor.GOLD + "Stopped the big funny");
            } else player.sendMessage(ChatColor.GOLD + "Started the big funny");
            BigFunni.toggle();
            return true;
        } return true;
    }
}
