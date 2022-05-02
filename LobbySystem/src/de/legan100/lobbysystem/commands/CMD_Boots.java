package de.legan100.lobbysystem.commands;

import de.legan100.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class CMD_Boots implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        File messageDE = new File("plugins//LobbySystem//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);

        if(sender instanceof Player){
            Player p =(Player)sender;
            if(!p.hasPermission("System.Spieler")){

                Inventory inv = Bukkit.createInventory(null, 45,"§6Boots");

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

                        ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                        meta.setDisplayName("§cFireBoots");
                        meta.setColor(Color.fromBGR(0,0,230));
                        itemStack.setItemMeta(meta);
                        inv.setItem(20, itemStack);

                        ItemStack WaterBoots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta WBmeta = (LeatherArmorMeta) WaterBoots.getItemMeta();
                        WBmeta.setDisplayName("§bWaterBoots");
                        WBmeta.setColor(Color.fromBGR(255,245,0));
                        WaterBoots.setItemMeta(WBmeta);
                        inv.setItem(23, WaterBoots);

                        ItemStack SnowBoots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta SBmeta = (LeatherArmorMeta) SnowBoots.getItemMeta();
                        SBmeta.setDisplayName("§fSnowBoots");
                        SBmeta.setColor(Color.fromBGR(255,255,255));
                        SnowBoots.setItemMeta(SBmeta);
                        inv.setItem(24, SnowBoots);

                        ItemStack LoveBoots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta LBmeta = (LeatherArmorMeta) LoveBoots.getItemMeta();
                        LBmeta.setDisplayName("§4LoveBoots");
                        LBmeta.setColor(Color.fromBGR(0,0,255));
                        LoveBoots.setItemMeta(LBmeta);
                        inv.setItem(21, LoveBoots);

                        ItemStack isBarrier = new ItemStack(Material.BARRIER);
                        ItemMeta imBarrier = isBarrier.getItemMeta();
                        imBarrier.setDisplayName("§4Schließen");
                        isBarrier.setItemMeta(imBarrier);
                        inv.setItem(40, isBarrier);

                        ItemStack isClock = new ItemStack(Material.CLOCK);
                        ItemMeta imClock = isClock.getItemMeta();
                        imClock.setDisplayName("§cSchuhe ausziehen");
                        isClock.setItemMeta(imClock);
                        inv.setItem(44, isClock);

                    }
                },15);

                p.openInventory(inv);

            }else{

                p.sendMessage("No Perms");

            }

        }else{
            sender.sendMessage("OnlyPlayerallowed");
        }

        return false;
    }
}
