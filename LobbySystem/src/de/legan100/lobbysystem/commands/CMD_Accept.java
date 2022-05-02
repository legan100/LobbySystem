package de.legan100.lobbysystem.commands;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Accept implements CommandExecutor {
    public static ArrayList<Player> allowedChat = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Content") || p.hasPermission("System.Dev") || p.hasPermission("System.SrMod") || p.hasPermission("System.Mod")) {
                if (CMD_Vanish.isVannished.contains(p)) {
                    if (allowedChat.contains(p)) {
                        allowedChat.remove(p);
                        p.sendMessage(cfg1.get("Message.prefix") + "Du kannst nun nicht mehr schreiben.");
                    } else {
                        allowedChat.add(p);
                        p.sendMessage(cfg1.get("Message.prefix") + "Du kannst nun schreiben.");
                    }
                } else {
                    p.sendMessage(cfg1.get("Message.prefix") + "Du darfst diesen Befehl nur aufwenn du im Vanish bist.");
                }
            } else {
                p.sendMessage((String)cfg1.get("Message.prefix") + cfg1.get("Message.noPerms"));
            }
        } else {
            sender.sendMessage((String)cfg1.get("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}
