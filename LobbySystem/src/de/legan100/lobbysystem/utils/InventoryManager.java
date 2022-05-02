package de.legan100.lobbysystem.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {
    public static void getItems(Player p) {
        if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")|| p.hasPermission("System.Builder")) {
            ItemStack isKompass = new ItemStack(Material.COMPASS);
            ItemMeta imKompasss = isKompass.getItemMeta();
            imKompasss.setDisplayName("§aNavi§2gator");
            isKompass.setItemMeta(imKompasss);
            p.getInventory().setItem(1, isKompass);

            ItemStack isChest = new ItemStack(Material.CHEST);
            ItemMeta imChest = isChest.getItemMeta();
            imChest.setDisplayName("§6Boots");
            isChest.setItemMeta(imChest);
            p.getInventory().setItem(3,isChest);

            ItemStack isRedstone = new ItemStack(Material.REDSTONE_TORCH);
            ItemMeta imRedstone = isRedstone.getItemMeta();
            imRedstone.setDisplayName("§6Einstellungen");
            isRedstone.setItemMeta(imRedstone);
            p.getInventory().setItem(5, isRedstone);

            ItemStack isLohenrute = new ItemStack(Material.BLAZE_ROD);
            ItemMeta imLohenrute = isLohenrute.getItemMeta();
            imLohenrute.setDisplayName("§bSpieler §3verstecken");
            isLohenrute.setItemMeta(imLohenrute);
            p.getInventory().setItem(7, isLohenrute);

        } else if (p.hasPermission("System.Content") || p.hasPermission("System.SrMod") || p.hasPermission("System.Mod") || p.hasPermission("System.Sup") || p.hasPermission("System.Designer") || p.hasPermission("System.Media")|| p.hasPermission("System.Premium")) {
            ItemStack isKompass = new ItemStack(Material.COMPASS);
            ItemMeta imKompasss = isKompass.getItemMeta();
            imKompasss.setDisplayName("§aNavi§2gator");
            isKompass.setItemMeta(imKompasss);
            p.getInventory().setItem(2, isKompass);

            ItemStack isChest = new ItemStack(Material.CHEST);
            ItemMeta imChest = isChest.getItemMeta();
            imChest.setDisplayName("§6Boots");
            isChest.setItemMeta(imChest);
            p.getInventory().setItem(4,isChest);

            ItemStack isLohenrute = new ItemStack(Material.BLAZE_ROD);
            ItemMeta imLohenrute = isLohenrute.getItemMeta();
            imLohenrute.setDisplayName("§bSpieler §3verstecken");
            isLohenrute.setItemMeta(imLohenrute);
            p.getInventory().setItem(6, isLohenrute);
        } else {
            ItemStack isKompass = new ItemStack(Material.COMPASS);
            ItemMeta imKompasss = isKompass.getItemMeta();
            imKompasss.setDisplayName("§aNavi§2gator");
            isKompass.setItemMeta(imKompasss);
            p.getInventory().setItem(2, isKompass);

            ItemStack isLohenrute = new ItemStack(Material.BLAZE_ROD);
            ItemMeta imLohenrute = isLohenrute.getItemMeta();
            imLohenrute.setDisplayName("§bSpieler §3verstecken");
            isLohenrute.setItemMeta(imLohenrute);
            p.getInventory().setItem(6, isLohenrute);
        }
    }

    public static void getBuildItems(Player p) {}
}
