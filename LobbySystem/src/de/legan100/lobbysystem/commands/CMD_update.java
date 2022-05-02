package de.legan100.lobbysystem.commands;

import de.legan100.lobbysystem.utils.Tablist;
import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_update implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player) {
            Tablist team = new Tablist();
            team.update();
            Player p = (Player)sender;
            p.sendMessage(cfg1.getString("Message.prefix") + "Du hast die Tablistteams aktualisiert");
        } else {
            sender.sendMessage(cfg1.getString("Message.onlyPlayerAllowed"));
        }

        return false;
    }
}
