package pluginmadness;

import pluginmadness.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class PluginMadness extends JavaPlugin {

    public static PluginMadness plugin;

    public static PluginMadness getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
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

        getCommand("thor").setExecutor(new ThorCommand());
        getCommand("thor").setTabCompleter(new ThorTabCompleter());

        getCommand("funni").setExecutor(new BigFunniCommand());
    }
}
