package fr.acilaw.hacrostaff.Punish;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishGuiTimeAndSanction extends PunishGui {


    public final String invTimeName = "§2Choisir une durée";
    public final String invSanctionName = "§eChoisi une sanction";

    public Inventory punishGuiTime(Player player){
        Inventory inv = Bukkit.createInventory(player, 18, invTimeName);


        inv.setItem(0, getItem(new ItemStack(Material.PAPER), "§c30 Minutes"));
        inv.setItem(1, getItem(new ItemStack(Material.PAPER), "§c1 heure"));
        inv.setItem(2, getItem(new ItemStack(Material.PAPER), "§c6 heures"));
        inv.setItem(3, getItem(new ItemStack(Material.PAPER), "§c1 Jour"));
        inv.setItem(4, getItem(new ItemStack(Material.PAPER), "§c7 Jours"));
        inv.setItem(5, getItem(new ItemStack(Material.PAPER), "§c14 Jours"));
        inv.setItem(6, getItem(new ItemStack(Material.PAPER), "§c1 Mois"));
        inv.setItem(7, getItem(new ItemStack(Material.PAPER), "§c2 Mois"));
        inv.setItem(8, getItem(new ItemStack(Material.PAPER), "§c3 Mois"));
        inv.setItem(9, getItem(new ItemStack(Material.PAPER), "§c6 Mois"));
        inv.setItem(10, getItem(new ItemStack(Material.PAPER), "§c1 an"));
        inv.setItem(11, getItem(new ItemStack(Material.PAPER), "§cDéfinitif"));

        return inv;
    }


    public Inventory punishGuiSanction(Player player){
        Inventory inv = Bukkit.createInventory(player, 27, invSanctionName);

        inv.setItem(0, getItem(new ItemStack(Material.IRON_FENCE), "§cKill Aura"));
        inv.setItem(1, getItem(new ItemStack(Material.IRON_FENCE), "§cAuto Click"));
        inv.setItem(2, getItem(new ItemStack(Material.IRON_FENCE), "§cSpeed Hack"));
        inv.setItem(3, getItem(new ItemStack(Material.IRON_FENCE), "§c"));
        inv.setItem(4, getItem(new ItemStack(Material.IRON_FENCE), "§c"));
        inv.setItem(5, getItem(new ItemStack(Material.IRON_FENCE), "§c"));
        inv.setItem(6, getItem(new ItemStack(Material.IRON_FENCE), "§c"));
        inv.setItem(7, getItem(new ItemStack(Material.IRON_FENCE), "§c"));
        inv.setItem(8, getItem(new ItemStack(Material.IRON_FENCE), "§c"));


        inv.setItem(9, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cLanguages inapropriés"));
        inv.setItem(10, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cSpam"));
        inv.setItem(11, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cFlood"));
        inv.setItem(12, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));
        inv.setItem(13, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));
        inv.setItem(14, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));
        inv.setItem(15, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));
        inv.setItem(16, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));
        inv.setItem(17, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§c"));


        inv.setItem(18, getItem(new ItemStack(Material.ENDER_PEARL), "§cExploitations de Bugs"));
        inv.setItem(19, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(20, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(21, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(22, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(23, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(24, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(25, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        inv.setItem(26, getItem(new ItemStack(Material.ENDER_PEARL), "§c"));
        return inv;
    }


}
