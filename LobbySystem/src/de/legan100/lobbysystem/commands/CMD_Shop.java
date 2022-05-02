package de.legan100.lobbysystem.commands;

import de.legan100.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CMD_Shop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(p.hasPermission("System.Admin")){
                Inventory inv = Bukkit.createInventory(null,54,"§cShop");

                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) LobbySystem.getPlugin(), new Runnable() {
                    public void run() {
                        for (int counter = 0; counter <= 53; counter++) {
                            ItemStack EY = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                            ItemMeta EYmeta = EY.getItemMeta();
                            EYmeta.setDisplayName(" ");
                            EY.setItemMeta(EYmeta);
                            inv.setItem(counter, EY);
                        }
                    }
                },10L);

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
                },20L);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)LobbySystem.getPlugin(), new Runnable() {
                    public void run() {

                        ItemStack isSnow = new ItemStack(Material.SNOW);
                        ItemMeta imSnow = isSnow.getItemMeta();
                        imSnow.setDisplayName("§fSnowfloorboots");
                        isSnow.setItemMeta(imSnow);
                        inv.setItem(20, isSnow);

                        ItemStack isBarrier = new ItemStack(Material.BARRIER);
                        ItemMeta imBarrier = isBarrier.getItemMeta();
                        imBarrier.setDisplayName("§4Schließen");
                        isBarrier.setItemMeta(imBarrier);
                        inv.setItem(49, isBarrier);
                    }
                },30L);

                p.openInventory(inv);
            }

        }


        return false;
    }
}
