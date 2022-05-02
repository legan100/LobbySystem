package de.legan100.lobbysystem;

import de.legan100.lobbysystem.commands.*;
import de.legan100.lobbysystem.listener.*;
import de.legan100.lobbysystem.utils.FileManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    private static LobbySystem plugin;

    public void onEnable() {
        //MySQL.connect();
        FileManager.createFile();
        register();
        plugin = this;
    }

    public void onDisable() {}

    public void register() {
        getServer().getPluginManager().registerEvents((Listener)new BuildListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new ChatListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new CommandListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new DamageListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new FoodListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new InteractListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new InventoryClickListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new SeconHandListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new MovementListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new QuitListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new ToggleFlyListener(), (Plugin)this);
        getServer().getPluginManager().registerEvents(new WeatherListener(), this);
        getCommand("Accept").setExecutor(new CMD_Accept());
        getCommand("Build").setExecutor(new CMD_Build());
        getCommand("fly").setExecutor(new CMD_Fly());
        getCommand("Spec").setExecutor(new CMD_Spec());
        getCommand("spectator").setExecutor(new CMD_Spec());
        getCommand("update").setExecutor(new CMD_update());
        getCommand("vanish").setExecutor(new CMD_Vanish());
        getCommand("v").setExecutor(new CMD_Vanish());
        getCommand("lobbyversion").setExecutor(new CMD_Lobbyversion());
        getCommand("lobbyver").setExecutor(new CMD_Lobbyversion());
        getCommand("boots").setExecutor(new CMD_Boots());
        getCommand("shop").setExecutor(new CMD_Shop());
        getCommand("datenschutz").setExecutor(new CMD_Datenschutz());
    }

    public static LobbySystem getPlugin() {
        return plugin;
    }
}
