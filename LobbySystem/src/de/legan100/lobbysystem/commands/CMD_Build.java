package de.legan100.lobbysystem.commands;

import de.legan100.lobbysystem.utils.InventoryManager;
import java.io.File;
import java.util.ArrayList;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Build implements CommandExecutor {
    public static ArrayList<Player> allowedBuild = new ArrayList<>();

    File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Builder")) {
                if (!CMD_Spec.allowedPlayer.contains(p)) {
                    if (allowedBuild.contains(p)) {
                        allowedBuild.remove(p);
                        p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Build.quit"));
                        p.getInventory().clear();
                        InventoryManager.getItems(p);
                        p.setGameMode(GameMode.SURVIVAL);
                    } else {
                        allowedBuild.add(p);
                        p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Build.join"));
                        p.getInventory().clear();
                        InventoryManager.getBuildItems(p);
                        p.setGameMode(GameMode.CREATIVE);
                    }
                } else {
                    p.sendMessage(this.cfg1.getString("Message.prefix") + "Du mussst den Spectatormodus verlassen, um in den Baumodus kommen zu k");
                }
            } else {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(this.cfg1.getString("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}
