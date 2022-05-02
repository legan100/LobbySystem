package de.legan100.lobbysystem.commands;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Spec implements CommandExecutor {

    public static ArrayList<Player> allowedPlayer = new ArrayList<>();
    File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("System.Admin") || p.hasPermission("System.SrMod") || p.hasPermission("System.Mod")) {
                if (CMD_Vanish.isVannished.contains(p)) {
                    if (allowedPlayer.contains(p)) {
                        p.sendMessage(String.valueOf(cfg1.getString("Message.prefix") + cfg1.get("Message.Spectator.quit")));
                        allowedPlayer.remove(p);
                        p.setGameMode(GameMode.SURVIVAL);
                    } else {
                        allowedPlayer.add(p);
                        p.sendMessage(String.valueOf(cfg1.getString("Message.prefix") + cfg1.get("Message.Spectator.join")));
                        p.setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    p.sendMessage(String.valueOf(cfg1.getString("Message.prefix") + cfg1.get("Message.Spectator.in.Vanish.allow")));
                }
            } else {
                p.sendMessage(String.valueOf(cfg1.getString("Message.prefix") + cfg1.get("Message.noPerms")));
            }
        } else {
            sender.sendMessage(String.valueOf(cfg1.getString("Message.prefix") + cfg1.get("Message.onlyPlayerAllowed")));
        }
        return false;
    }
}
