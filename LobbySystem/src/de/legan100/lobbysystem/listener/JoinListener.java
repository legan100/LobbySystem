
package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.utils.InventoryManager;
import de.legan100.lobbysystem.utils.Tablist;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        p.getInventory().clear();

        Tablist Tablist = new Tablist();
        Tablist.create("Admin", 10, "§dAdmin | §f", null, "System.Admin");
        Tablist.create("Content", 12, "§bContent | §f", null, "System.Content");
        Tablist.create("Dev", 14, "§bDeveloper | §f", null, "System.Dev");
        Tablist.create("SrMod", 16, "§cMod+ | §f", null, "System.SrMod");
        Tablist.create("Mod", 18, "§cModerator | §f", null, "System.Mod");
        Tablist.create("Sup", 20, "§9Helfer | §f", null, "System.Sup");
        Tablist.create("Builder", 24, "§2Builder | §f", null, "System.Builder");
        Tablist.create("Designer", 26, "§aDesigner | §f", null, "System.Designer");
        Tablist.create("Media", 32, "§5Media | §f", null, "System.Media");
        Tablist.create("Premium", 36, "§6Premium | §f", null, "System.Premium");
        Tablist.create("Spieler", 38, "§8Spieler | §f", null, null);
        Tablist.addPlayer(e.getPlayer());
        Tablist.update();

        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        p.setPlayerListHeader(cfg1.getString("Tablist.Header"));
        p.setPlayerListFooter(cfg1.getString("Tablist.Footer"));


        InventoryManager.getItems(e.getPlayer());

        p.setFoodLevel(20);
        p.setLevel(2022);

        File file = new File("plugins//LobbySystem//spawns.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        String w = cfg.getString("Spawn.Worldname");
        double X = cfg.getDouble("Spawn.X");
        double Y = cfg.getDouble("Spawn.Y");
        double Z = cfg.getDouble("Spawn.Z");
        double Yaw = cfg.getDouble("Spawn.Yaw");
        double Pitch = cfg.getDouble("Spawn.Pitch");
        Location loc = new Location(Bukkit.getWorld(w), X, Y, Z);
        loc.setYaw((float)Yaw);
        loc.setPitch((float)Pitch);
        p.teleport(loc);

        p.setGameMode(GameMode.SURVIVAL);

        File file2 = new File("plugins//LobbySystem//spawns.yml");
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);

        if (!p.hasPermission("System.Spieler")) {
            p.setAllowFlight(true);
            p.setFlying(false);
        }

        File file1 = new File("plugins//LobbySystem//datenschutz.yml");
        YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(file1);

        if(cfg3.getString(p.getUniqueId().toString())== null){
            p.sendMessage(cfg1.getString("Message.Datenschutz.NotAccept"));
        }

        for (Player players: Bukkit.getOnlinePlayers()) {
            if(InventoryClickListener.hidedPlayer.contains(players)){
                players.hidePlayer(p);
            }
        }

    }
}
