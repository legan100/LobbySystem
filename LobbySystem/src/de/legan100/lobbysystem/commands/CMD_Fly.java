package de.legan100.lobbysystem.commands;

import java.io.File;
import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Fly implements CommandExecutor {
    public static ArrayList<Player> allowedFly = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Content") || p.hasPermission("System.Dev") || p.hasPermission("System.SrMod") || p.hasPermission("System.Mod") || p.hasPermission("System.Sup") || p.hasPermission("System.Builder") || p.hasPermission("System.Designer") || p.hasPermission("System.Media")) {
                if (!CMD_Spec.allowedPlayer.contains(p)) {
                    if (!CMD_Build.allowedBuild.contains(p)) {
                        if (allowedFly.contains(p)) {
                            if (!p.isFlying()) {
                                allowedFly.remove(p);
                                p.setFlying(false);
                                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Fly.quit"));
                            } else {
                                p.sendMessage(cfg1.getString("Message.prefix") + "Bitte auf den Boden, damit du den Flymodus verlassen kannst");
                            }
                        } else {
                            allowedFly.add(p);
                            p.setFlying(true);
                            p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Fly.join"));
                        }
                    } else {
                        p.sendMessage(cfg1.getString(cfg1.getString("Message.prefix") + "Message.quit.fly.before"));
                    }
                } else {
                    p.sendMessage(cfg1.getString(cfg1.getString("Message.prefix") + "Message.quit.build.before"));
                }
            } else {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}
