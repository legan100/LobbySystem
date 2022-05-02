package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.commands.CMD_Build;
import de.legan100.lobbysystem.utils.InventoryManager;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryClickListener implements Listener {

    public static ArrayList<Player> hidedPlayer = new ArrayList<>();


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player p = (Player)e.getWhoClicked();
        e.setCancelled(true);


        try {
            File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
            YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Schließen")) {
                e.setCancelled(true);
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("   ")) {
                e.setCancelled(true);
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cReload")) {
                Bukkit.broadcastMessage("Relaod des Servers steht an.");
                e.setCancelled(true);
                Bukkit.reload();
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Coming soon")) {
                e.setCancelled(true);
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cServerrestart")) {
                e.setCancelled(true);
                p.performCommand("stop");
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSpawn setzen")) {
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
                p.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aBaumodus aktivieren")) {
                if (CMD_Build.allowedBuild.contains(p)) {
                    CMD_Build.allowedBuild.remove(p);
                    p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Build.quit"));
                    p.setGameMode(GameMode.SURVIVAL);
                    p.getInventory().clear();
                    InventoryManager.getItems(p);
                } else {
                    e.setCancelled(true);
                    CMD_Build.allowedBuild.add(p);
                    p.sendMessage(String.valueOf(cfg1.get("Message.prefix") + cfg1.getString("Message.Build.join")));
                    p.setGameMode(GameMode.CREATIVE);
                    p.getInventory().clear();
                    InventoryManager.getBuildItems(p);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Quiz")) {

                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                String w = cfg.getString("Quiz.Worldname");
                double X = cfg.getDouble("Quiz.X");
                double Y = cfg.getDouble("Quiz.Y");
                double Z = cfg.getDouble("Quiz.Z");
                double Yaw = cfg.getDouble("Quiz.Yaw");
                double Pitch = cfg.getDouble("Quiz.Pitch");
                Location loc = new Location(Bukkit.getWorld(w), -35.5D, 16.0D, 63.5D);
                loc.setYaw((float)Yaw);
                loc.setPitch((float)Pitch);
                p.teleport(loc);
                p.closeInventory();
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Teleport.Quiz"));

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSpawn")) {

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
                p.closeInventory();
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Teleport.Spawn"));

            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2RPBuild")) {

                File file = new File("plugins//LobbySystem//spawns.yml");
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                String w = cfg.getString("RPBuild.Worldname");
                double X = cfg.getDouble("RPBuild.X");
                double Y = cfg.getDouble("RPBuild.Y");
                double Z = cfg.getDouble("RPBuild.Z");
                double Yaw = cfg.getDouble("RPBuild.Yaw");
                double Pitch = cfg.getDouble("RPBuild.Pitch");
                Location loc = new Location(Bukkit.getWorld(w), X, Y, Z);
                loc.setYaw((float)Yaw);
                loc.setPitch((float)Pitch);
                p.teleport(loc);
                p.closeInventory();
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Teleport.RPBuild"));

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAlle Spieler zeigen")) {

                for (Player all : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(all);
                    p.closeInventory();
                }
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Show.all.Players"));

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cAlle Spieler verstecken")) {
                if(hidedPlayer.contains(p)){
                    p.sendMessage("Du hast bereits alle Spieler versteckt");
                }else{
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer(all);
                        p.closeInventory();
                    }
                }
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Hide.all.Players"));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cFireBoots")){

                ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                meta.setDisplayName("§cFireBoots");
                meta.setUnbreakable(true);
                meta.setColor(Color.fromBGR(0,0,230));
                itemStack.setItemMeta(meta);

                p.getInventory().setBoots(itemStack);
                p.closeInventory();

            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§bWaterBoots")){

                ItemStack WaterBoots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta WBmeta = (LeatherArmorMeta) WaterBoots.getItemMeta();
                WBmeta.setDisplayName("§bWaterBoots");
                WBmeta.setUnbreakable(true);
                WBmeta.setColor(Color.fromBGR(255,245,0));
                WaterBoots.setItemMeta(WBmeta);

                p.getInventory().setBoots(WaterBoots);
                p.closeInventory();

            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§fSnowBoots")){

                ItemStack SnowBoots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta SBmeta = (LeatherArmorMeta) SnowBoots.getItemMeta();
                SBmeta.setDisplayName("§fSnowBoots");
                SBmeta.setUnbreakable(true);
                SBmeta.setColor(Color.fromBGR(255,255,255));
                SnowBoots.setItemMeta(SBmeta);

                p.getInventory().setBoots(SnowBoots);
                p.closeInventory();

            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4LoveBoots")){

                ItemStack SnowBoots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta SBmeta = (LeatherArmorMeta) SnowBoots.getItemMeta();
                SBmeta.setDisplayName("§4LoveBoots");
                SBmeta.setUnbreakable(true);
                SBmeta.setColor(Color.fromBGR(0,0,255));
                SnowBoots.setItemMeta(SBmeta);

                p.getInventory().setBoots(SnowBoots);
                p.closeInventory();

            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSchuhe ausziehen")){

                p.getInventory().clear();
                InventoryManager.getItems(p);
                p.closeInventory();

            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aDatenschutzerklärung annehmen")){
                File file1 = new File("plugins//LobbySystem//datenschutz.yml");
                YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(file1);
                p.sendMessage("Testnachricht");
                if(cfg3.getString(p.getUniqueId().toString())== null){
                    cfg3.set(p.getUniqueId().toString(), p.getUniqueId().toString());
                    try {
                        cfg3.save(file1);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        p.sendMessage("Fehler ist aufgetreten. Ein Serverneustart wird nun empfolen.");
                    }
                    p.closeInventory();
                }else{
                    p.closeInventory();

                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cDatenschutzerklärung ablehenen")){
                p.kickPlayer("Du hast die Datenschutzerklärung von uns abgelehnt.\n\nDas ist auch der Grund für den Kick.");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§eUnsere Datenschutzerklärung findest du unter: MovieMC.de/datenschutz.html")){
                p.closeInventory();
                p.sendMessage("§eUnsere Datenschutzerklärung findest du unter: MovieMC.de/datenschutz.html");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cSchuhe ausziehen")){
                p.closeInventory();
                p.getInventory().clear();
                InventoryManager.getItems(p);
                p.sendMessage(cfg1.get("Message.prefix") + cfg1.getString("Message.Schuhe.ausziehen"));
            }else{
                e.setCancelled(true);
            }
        } catch (Exception e1) {
            if (CMD_Build.allowedBuild.contains(p))
                e.setCancelled(false);
            }
        }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if(CMD_Build.allowedBuild.contains(e.getPlayer())){
            e.setCancelled(false);
        }else
            e.setCancelled(true);
    }



}