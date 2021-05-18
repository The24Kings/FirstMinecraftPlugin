package pluginmadness.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ScaffoldTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("ice");
        parameters.add("packed_ice");
        parameters.add("blue_ice");

        return parameters;
    }
}
