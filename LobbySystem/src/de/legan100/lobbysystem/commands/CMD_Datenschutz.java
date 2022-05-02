package de.legan100.lobbysystem.commands;

import de.legan100.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class CMD_Datenschutz implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player){

            File file1 = new File("plugins//LobbySystem//datenschutz.yml");
            YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(file1);

            Player p = (Player) sender;

            if(cfg3.get(String.valueOf(p.getUniqueId()))!= p.getUniqueId()){
                Inventory inv = Bukkit.createInventory(null, 45, "§bDatenschutz");
                p.openInventory(inv);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) LobbySystem.getPlugin(), new Runnable() {
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

                        ItemStack isPaper = new ItemStack(Material.PAPER);
                        ItemMeta imPaper = isPaper.getItemMeta();
                        imPaper.setDisplayName("§eDatenschutzerklärung annehmen oder nicht?");
                        isPaper.setItemMeta(imPaper);
                        inv.setItem(13,isPaper);

                        ItemStack isGoldenAppel = new ItemStack(Material.EMERALD);
                        ItemMeta imGoldenAppel = isGoldenAppel.getItemMeta();
                        imGoldenAppel.setDisplayName("§aDatenschutzerklärung annehmen");
                        isGoldenAppel.setItemMeta(imGoldenAppel);
                        inv.setItem(20, isGoldenAppel);

                        ItemStack isRedstone = new ItemStack(Material.REDSTONE);
                        ItemMeta imRedstone = isRedstone.getItemMeta();
                        imRedstone.setDisplayName("§cDatenschutzerklärung ablehenen");
                        isRedstone.setItemMeta(imRedstone);
                        inv.setItem(24, isRedstone);

                        ItemStack isPaper2 = new ItemStack(Material.PAPER);
                        ItemMeta imPaper2 = isPaper2.getItemMeta();
                        imPaper2.setDisplayName("§eUnsere Datenschutzerklärung findest du unter: MovieMC.de/datenschutz.html");
                        isPaper2.setItemMeta(imPaper2);
                        inv.setItem(44,isPaper2);

                        ItemStack isBarrier = new ItemStack(Material.BARRIER);
                        ItemMeta imBarrier = isBarrier.getItemMeta();
                        imBarrier.setDisplayName("§4Schließen");
                        isBarrier.setItemMeta(imBarrier);
                        inv.setItem(40, isBarrier);
                    }
                },15);
            }

        }

        return false;
    }
}
