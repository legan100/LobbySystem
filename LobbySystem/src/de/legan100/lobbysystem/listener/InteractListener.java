package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.LobbySystem;
import de.legan100.lobbysystem.commands.CMD_Build;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        e.setCancelled(true);
        try {
            if (e.getItem().getItemMeta().getDisplayName().equals("§6Einstellungen")) {
                if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                    final Inventory inv = Bukkit.createInventory(null, 54, "§6Einstellungen");
                    int counter;
                    for (counter = 0; counter <= 53; counter++) {
                        ItemStack EY = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 0; counter <= 9; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 17; counter <= 18; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 26; counter <= 27; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 35; counter <= 36; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 44; counter <= 53; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }

                    ItemStack SW = new ItemStack(Material.ENDER_EYE);
                    ItemMeta SWmeta = SW.getItemMeta();
                    SWmeta.setDisplayName("§cSpawn setzen");
                    SW.setItemMeta(SWmeta);
                    inv.setItem(20, SW);

                    ItemStack RW = new ItemStack(Material.BARRIER);
                    ItemMeta RWmeta = RW.getItemMeta();
                    RWmeta.setDisplayName("§cReload");
                    RW.setItemMeta(RWmeta);
                    inv.setItem(22, RW);

                    ItemStack EW = new ItemStack(Material.RED_DYE);
                    ItemMeta EWmeta = EW.getItemMeta();
                    EWmeta.setDisplayName("§cComming soon");
                    EW.setItemMeta(EWmeta);
                    inv.setItem(24, EW);

                    ItemStack TW = new ItemStack(Material.ORANGE_DYE);
                    ItemMeta TWmeta = TW.getItemMeta();
                    TWmeta.setDisplayName("§cServerrestart");
                    TW.setItemMeta(TWmeta);
                    inv.setItem(30, TW);

                    p.openInventory(inv);
                }
                if (p.hasPermission("System.Builder")) {
                    e.setCancelled(true);
                    final Inventory inv = Bukkit.createInventory(null, 45, "");
                    e.setCancelled(true);
                    int counter;
                    for (counter = 0; counter <= 44; counter++) {
                        ItemStack EY = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 0; counter <= 9; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 17; counter <= 18; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 26; counter <= 27; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    for (counter = 35; counter <= 44; counter++) {
                        ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                        ItemMeta EYmeta = EY.getItemMeta();
                        EYmeta.setDisplayName(" ");
                        EY.setItemMeta(EYmeta);
                        inv.setItem(counter, EY);
                    }
                    e.setCancelled(true);
                    ItemStack BW = new ItemStack(Material.DIAMOND_AXE);
                    ItemMeta BWmeta = BW.getItemMeta();
                    BWmeta.setDisplayName("aktivieren");
                    BW.setItemMeta(BWmeta);
                    inv.setItem(22, BW);
                    p.openInventory(inv);

                    e.setCancelled(true);
                }
            } else if (e.getItem().getItemMeta().getDisplayName().equals("§bSpieler §3verstecken")) {
                e.setCancelled(true);
                final Inventory inv = Bukkit.createInventory(null, 45, "§bSpieler §3verstecken");
                p.openInventory(inv);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        for (int counter = 0; counter <= 44; counter++) {
                            ItemStack EY = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                    }
                },5);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        int counter;
                        for (counter = 0; counter <= 9; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 17; counter <= 18; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 26; counter <= 27; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 35; counter <= 44; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                    }
                },10);

                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {

                        ItemStack isRedstone = new ItemStack(Material.REDSTONE);
                        ItemMeta imRedstone = isRedstone.getItemMeta();
                        imRedstone.setDisplayName("§cAlle Spieler verstecken");
                        isRedstone.setItemMeta(imRedstone);
                        inv.setItem(24, isRedstone);

                        ItemStack isGoldenAppel = new ItemStack(Material.EMERALD);
                        ItemMeta imGoldenAppel = isGoldenAppel.getItemMeta();
                        imGoldenAppel.setDisplayName("§aAlle Spieler zeigen");
                        isGoldenAppel.setItemMeta(imGoldenAppel);
                        inv.setItem(20, isGoldenAppel);

                        ItemStack isBarrier = new ItemStack(Material.BARRIER);
                        ItemMeta imBarrier = isBarrier.getItemMeta();
                        imBarrier.setDisplayName("§4Schließen");
                        isBarrier.setItemMeta(imBarrier);
                        inv.setItem(40, isBarrier);
                    }
                },15);
            } else if (e.getItem().getItemMeta().getDisplayName().equals("§aNavi§2gator")) {
                final Inventory inv = Bukkit.createInventory(null, 54, "§aNavi§2gator");
                p.openInventory(inv);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        for (int counter = 0; counter <= 53; counter++) {
                            ItemStack EY = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                    }
                },5);

                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        int counter;
                        for (counter = 0; counter <= 9; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 17; counter <= 18; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 26; counter <= 27; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 35; counter <= 36; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                        for (counter = 44; counter <= 53; counter++) {
                            ItemStack EY = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                    }
                },10);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        ItemStack isGrassBlock = new ItemStack(Material.GRASS_BLOCK);
                        ItemMeta imGrassBlock = isGrassBlock.getItemMeta();
                        imGrassBlock.setDisplayName("§2RPBuild");
                        isGrassBlock.setItemMeta(imGrassBlock);
                        inv.setItem(13, isGrassBlock);

                        ItemStack isDiamond = new ItemStack(Material.DIAMOND);
                        ItemMeta imDiamond = isDiamond.getItemMeta();
                        imDiamond.setDisplayName("§aSpawn");
                        isDiamond.setItemMeta(imDiamond);
                        inv.setItem(31, isDiamond);

                        ItemStack isBarrier = new ItemStack(Material.BARRIER);
                        ItemMeta imBarrier = isBarrier.getItemMeta();
                        imBarrier.setDisplayName("§4Schließen");
                        isBarrier.setItemMeta(imBarrier);
                        inv.setItem(49, isBarrier);
                    }
                },15);
            } else if (CMD_Build.allowedBuild.contains(e.getPlayer())) {
                e.setCancelled(false);
            } else if(e.getItem().getItemMeta().getDisplayName().equals("§6Boots")){
                p.performCommand("boots");
            } else {
                e.setCancelled(true);
            }
        } catch (Exception e1) {
            if (CMD_Build.allowedBuild.contains(e.getPlayer()))
                e.setCancelled(false);
            return;
        }
    }
}