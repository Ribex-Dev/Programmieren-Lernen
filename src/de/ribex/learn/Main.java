package de.ribex.learn;

import de.ribex.learn.commands.FlyCommand;
import de.ribex.learn.commands.HealCommand;
import de.ribex.learn.commands.TestCommand;
import de.ribex.learn.events.BlockEvents;
import de.ribex.learn.events.JoinQuitListeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {                                        //Start des Plugins
        getLogger().info( "§aPlugin Loaded");

        //Initialisieren der Commands
        getCommand("test").setExecutor(new TestCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new HealCommand());

        //Initialisieren der Events
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinQuitListeners() , this);
        manager.registerEvents(new BlockEvents() , this);
    }

    public static String getPrefix(){
        return ChatColor.GRAY + "[" + ChatColor.GOLD + "Lean-Plugin" + ChatColor.GRAY + "] > ";
    }

    @Override
    public void onDisable() {
        getLogger().info( "§cPlugin Disabled");
    }
}