package pluginmadness.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ThorTabCompleter  implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("netherite_axe");
        parameters.add("diamond_axe");
        parameters.add("golden_axe");
        parameters.add("iron_axe");
        parameters.add("stone_axe");
        parameters.add("wooden_axe");

        return parameters;
    }
}
