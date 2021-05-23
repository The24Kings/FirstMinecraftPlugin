package pluginmadness.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScaffoldTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("ice");
        parameters.add("packed_ice");
        parameters.add("blue_ice");
        parameters.add("add_player");
        parameters.add("remove_player");
        for (Player p : Bukkit.getOnlinePlayers()) {
            parameters.add(p.getName());
        }

        return parameters;
    }
}
