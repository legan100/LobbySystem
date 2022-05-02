package de.legan100.lobbysystem.commands;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Vanish implements CommandExecutor {
    public static ArrayList<Player> isVannished = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Content") || p.hasPermission("System.Dev") || p.hasPermission("System.SrMod") || p.hasPermission("System.Mod")) {
                if (isVannished.contains(p)) {
                    for (Player all : Bukkit.getOnlinePlayers())
                        all.hidePlayer(p);
                    isVannished.remove(p);
                    p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Vanish.show"));
                } else {
                    for (Player all : Bukkit.getOnlinePlayers())
                        all.showPlayer(p);
                    isVannished.add(p);
                    p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Vanish.hide"));
                }
            } else {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}
