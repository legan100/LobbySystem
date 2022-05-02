package de.legan100.lobbysystem.listener;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (e.getMessage().equalsIgnoreCase("/setspawn1")) {
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("Quiz.X", Float.valueOf((float) p.getLocation().getX()));
                cfg.set("Quiz.Y", Float.valueOf((float) p.getLocation().getY()));
                cfg.set("Quiz.Z", Float.valueOf((float) p.getLocation().getZ()));
                cfg.set("Quiz.Yaw", Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Quiz.Pitch", Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Quiz.Worldname", p.getWorld().getName());
                try {
                    cfg.save(file);
                } catch (IOException e1) {
                    p.sendMessage(cfg1.getString("Message.Error"));
                    return;
                }
                p.sendMessage(cfg1.getString("Message.prefix") + "Du hast nun den Quizspawn gesetzt");
            } else {
                p.sendMessage(cfg1.getString("Message.noPerms"));
            }
        } else if (e.getMessage().equalsIgnoreCase("/setspawn")) {
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                cfg.set("Spawn.Yaw", Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Spawn.Pitch", Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Spawn.Worldname", p.getWorld().getName());
                try {
                    cfg.save(file);
                } catch (IOException e1) {
                    p.sendMessage(cfg1.getString("Message.Error"));
                    return;
                }
                p.sendMessage(cfg1.getString("Message.prefix") + "Du hast nun den Spawn gesetzt");
            } else {
                p.sendMessage(cfg1.getString("Message.noPerms"));
            }
        }else if (e.getMessage().equalsIgnoreCase("/setspawn2")) {
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("RPBuild.X", Float.valueOf((float) p.getLocation().getX()));
                cfg.set("RPBuild.Y", Float.valueOf((float) p.getLocation().getY()));
                cfg.set("RPBuild.Z", Float.valueOf((float) p.getLocation().getZ()));
                cfg.set("RPBuild.Yaw", Float.valueOf(p.getLocation().getYaw()));
                cfg.set("RPBuild.Pitch", Float.valueOf(p.getLocation().getPitch()));
                cfg.set("RPBuild.Worldname", p.getWorld().getName());
                try {
                    cfg.save(file);
                } catch (IOException e1) {
                    p.sendMessage(cfg1.getString("Message.Error"));
                    return;
                }
                p.sendMessage(cfg1.getString("Message.prefix") + "Du hast nun den RPBuild gesetzt");
            } else {
                p.sendMessage(cfg1.getString("Message.noPerms"));
            }
        }else if (e.getMessage().equalsIgnoreCase("/setbau")) {
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("Bau.X", Float.valueOf((float) p.getLocation().getX()));
                cfg.set("Bau.Y", Float.valueOf((float) p.getLocation().getY()));
                cfg.set("Bau.Z", Float.valueOf((float) p.getLocation().getZ()));
                cfg.set("Bau.Yaw", Float.valueOf(p.getLocation().getYaw()));
                cfg.set("Bau.Pitch", Float.valueOf(p.getLocation().getPitch()));
                cfg.set("Bau.Worldname", p.getWorld().getName());
                try {
                    cfg.save(file);
                } catch (IOException e1) {
                    p.sendMessage(cfg1.getString("Message.Error"));
                    return;
                }
                p.sendMessage(cfg1.getString("Message.prefix") + "Du hast nun den Bauserver gesetzt");
            } else {
                p.sendMessage(cfg1.getString("Message.noPerms"));
            }
        }
    }
}
