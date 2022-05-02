package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.commands.CMD_Build;
import de.legan100.lobbysystem.commands.CMD_Fly;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;

public class MovementListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("System.Spieler")){
            if (!CMD_Fly.allowedFly.contains(p)){
                if (p.getGameMode() == GameMode.SURVIVAL && p.getLocation().add(0.0D, -0.5D, 0.0D).getBlock().getType() != Material.AIR) {
                    p.setAllowFlight(true);
                    p.setFlying(false);
                }
            }
        }

        if(p.getLocation().getY() >=25){
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

            File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
            YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);

            p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.over25"));
        }

        try {
            if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§cFireBoots")){
                p.spawnParticle(Particle.FLAME, p.getLocation(), 0, 0,0,0);
            }else if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§fSnowBoots")){
                p.spawnParticle(Particle.SNOW_SHOVEL, p.getLocation(), 0,0,0,0);
            }else if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§bWaterBoots")){
                p.spawnParticle(Particle.WATER_SPLASH, p.getLocation(), 0,0,0,0);
            }else if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§4LoveBoots")){
                p.spawnParticle(Particle.HEART, p.getLocation(), 0,0,0,0);
            }
        }catch (NullPointerException e1){
            if (CMD_Build.allowedBuild.contains(p)){
                e.setCancelled(false);
            }
        }
    }
}
