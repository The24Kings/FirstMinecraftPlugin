package pluginmadness;

import pluginmadness.commands.ScaffoldCommand;
import pluginmadness.commands.ScaffoldTabCompleter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println(ChatColor.DARK_RED + "24Kings Plugin: " + ChatColor.RESET + "I'm enabled nerd");
        RegisterCommandsAndEvents();
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.DARK_RED + "24Kings Plugin: " + ChatColor.RESET + "No dad why!");
    }

    private void RegisterCommandsAndEvents () {
        getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);

        getCommand("scaffold").setExecutor(new ScaffoldCommand());
        getCommand("scaffold").setTabCompleter(new ScaffoldTabCompleter());
    }

}
