package de.legan100.lobbysystem.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
    public static void createFile() {
        File ordner = new File("plugins//LobbySystem//");
        if (!ordner.exists())
            ordner.mkdir();
        File file = new File("plugins//LobbySystem//mysql.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!file.exists())
            try {
                cfg.addDefault("MySQL.host", "localhost");
                cfg.addDefault("MySQL.port", "3306");
                cfg.addDefault("MySQL.Database", "database");
                cfg.addDefault("MySQL.user", "username");
                cfg.addDefault("MySQL.password", "password");
                cfg.options().copyDefaults(true);
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (!messageDE.exists())
            try {
                cfg1.addDefault("Tablist.Footer","§cLegendenArmy.de §8| §aDein Netzwerk");
                cfg1.addDefault("Tablist.Header", "Dein Filmnetzwerk");
                cfg1.addDefault("Message.prefix", "§aSystem §8>> §e");
                cfg1.addDefault("Message.Error", "Bitte melde dich beim Serverteam.");
                cfg1.addDefault("Message.noPerms", "Dafür benötigst du einen höheren Rang");
                cfg1.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur fSpieler gedacht.");
                cfg1.addDefault("Message.unknownCMD", "Command!");
                cfg1.addDefault("Message.Spectator.quit", "Du hast den Spectatormodus verlassen.");
                cfg1.addDefault("Message.Spectator.join", "Du hast den Spectatormodus betreten.");
                cfg1.addDefault("Message.Spectator.in.Vanish.allow", "Du kannst diesen Befehl nur nutzen, wenn du im Vanish bist.");
                cfg1.addDefault("Message.Build.quit", "Du hast den Baumodus ");
                cfg1.addDefault("Message.Build.join", "Du hast den Baumodus ");
                cfg1.addDefault("Message.Teleport.Quiz", "Du hast dich zum §cQuiz §eteleportiert.");
                cfg1.addDefault("Message.Teleport.Spawn", "Du hast dich zum §cSpawn §eteleportiert.");
                cfg1.addDefault("Message.Show.all.Players", "Dir werdenen nun alle Spieler angezeigt.");
                cfg1.addDefault("Message.Hide.all.Players", "Du versteckst nun alle Spieler.");
                cfg1.addDefault("Message.Vanish.hide", "Du hast den Vanishmodus ");
                cfg1.addDefault("Message.Vanish.show", "Du hast den Vanishmodus ");
                cfg1.addDefault("Message.quit.fly.before", "Du musst davor den Flymodus verlassen");
                cfg1.addDefault("Message.quit.build.before", "Du musst davor den Buildmodus ");
                cfg1.addDefault("Message.Fly.join", "Du hast den Flugmodus ");
                cfg1.addDefault("Message.Fly.quit", "Du hast den Flugmodus ");
                cfg1.options().copyDefaults(true);
                cfg1.save(messageDE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        File messageAU = new File("plugins//LobbySystem//message_en_GB.yml");
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(messageAU);
        if (!messageAU.exists())
            try {
                cfg2.addDefault("Message.prefix", "§aSystem §8>> §e");
                cfg2.addDefault("Message.Error", "Bitte melde dich beim Serverteam.");
                cfg2.addDefault("Message.noPerms", "Dafür benötigst du einen höheren Rang");
                cfg2.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur fSpieler gedacht.");
                cfg2.addDefault("Message.unknownCMD", "Command!");
                cfg2.addDefault("Message.Spectator.quit", "Du hast den Spectatormodus verlassen.");
                cfg2.addDefault("Message.Spectator.join", "Du hast den Spectatormodus betreten.");
                cfg2.addDefault("Message.Spectator.in.Vanish.allow", "Du kannst diesen Befehl nur nutzen, wenn du im Vanish bist.");
                cfg2.addDefault("Message.Build.quit", "Du hast den Baumodus ");
                cfg2.addDefault("Message.Build.join", "Du hast den Baumodus ");
                cfg2.addDefault("Message.Teleport.Quiz", "Du hast dich zum §cQuiz §eteleportiert.");
                cfg2.addDefault("Message.Teleport.Spawn", "Du hast dich zum §cSpawn §eteleportiert.");
                cfg2.addDefault("Message.Show.all.Players", "Dir werdenen nun alle Spieler angezeigt.");
                cfg2.addDefault("Message.Hide.all.Players", "Du versteckst nun alle Spieler.");
                cfg2.addDefault("Message.Vanish.hide", "Du hast den Vanishmodus ");
                cfg2.addDefault("Message.Vanish.show", "Du hast den Vanishmodus ");
                cfg2.addDefault("Message.quit.fly.before", "Du musst davor den Flymodus verlassen");
                cfg2.addDefault("Message.quit.build.before", "Du musst davor den Buildmodus ");
                cfg2.addDefault("Message.Fly.join", "Du hast den Flugmodus ");
                cfg2.addDefault("Message.Fly.quit", "Du hast den Flugmodus ");
                cfg2.options().copyDefaults(true);
                cfg2.save(messageAU);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

    }
}
