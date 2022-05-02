package de.legan100.lobbysystem.commands;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Lobbyversion implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player) {
            Player p = (Player)sender;

            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev") || p.hasPermission("System.Content")){
                p.sendMessage(cfg1.getString("Message.prefix") + "Das Plugin ist in der Version 1.0");
            }else {

                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));

            }

        }else{
            sender.sendMessage(cfg1.getString("Message.prefix") + "Das Plugin ist in der Version 1.0");
        }
        return false;
    }
}
