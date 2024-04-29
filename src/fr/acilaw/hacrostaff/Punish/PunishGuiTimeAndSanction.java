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
        Inventory inv = Bukkit.createInventory(player, 54, invTimeName);


        inv.setItem(0,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(1,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(7,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(8,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(9,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(17,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(36,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(44,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(45,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(46,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(52,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(53,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));


        inv.setItem(19, getItem(new ItemStack(Material.PAPER), "§c30 Minutes"));
        inv.setItem(20, getItem(new ItemStack(Material.PAPER), "§c1 heure"));
        inv.setItem(21, getItem(new ItemStack(Material.PAPER), "§c6 heures"));
        inv.setItem(22, getItem(new ItemStack(Material.PAPER), "§c1 Jour"));
        inv.setItem(23, getItem(new ItemStack(Material.PAPER), "§c7 Jours"));
        inv.setItem(24, getItem(new ItemStack(Material.PAPER), "§c14 Jours"));
        inv.setItem(25, getItem(new ItemStack(Material.PAPER), "§c1 Mois"));
        inv.setItem(28, getItem(new ItemStack(Material.PAPER), "§c2 Mois"));
        inv.setItem(29, getItem(new ItemStack(Material.PAPER), "§c3 Mois"));
        inv.setItem(30, getItem(new ItemStack(Material.PAPER), "§c6 Mois"));
        inv.setItem(31, getItem(new ItemStack(Material.PAPER), "§c1 an"));
        inv.setItem(32, getItem(new ItemStack(Material.PAPER), "§cDéfinitif"));

        return inv;
    }

    public Inventory punishGuiSanction(Player player){
        Inventory inv = Bukkit.createInventory(player, 27, invSanctionName);

        inv.setItem(0, getItem(new ItemStack(Material.IRON_FENCE), "§cKill Aura"));
        inv.setItem(1, getItem(new ItemStack(Material.IRON_FENCE), "§cForce Field"));
        inv.setItem(2, getItem(new ItemStack(Material.IRON_FENCE), "§cSpeed Hack"));
        inv.setItem(3, getItem(new ItemStack(Material.IRON_FENCE), "§cFly"));
        inv.setItem(4, getItem(new ItemStack(Material.IRON_FENCE), "§cJesus"));
        inv.setItem(5, getItem(new ItemStack(Material.IRON_FENCE), "§cAnti Knockback"));
        inv.setItem(6, getItem(new ItemStack(Material.IRON_FENCE), "§cAutoclick"));
        inv.setItem(7, getItem(new ItemStack(Material.IRON_FENCE), "§cSpider"));
        inv.setItem(8, getItem(new ItemStack(Material.IRON_FENCE), "§cNo Fall"));


        inv.setItem(9, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cInsulte"));
        inv.setItem(10, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cProvocation"));
        inv.setItem(11, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cSpam"));
        inv.setItem(12, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cFlood"));
        inv.setItem(13, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cMajuscule"));
        inv.setItem(14, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cMenace DDOS"));
        inv.setItem(15, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cRacisme"));
        inv.setItem(16, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cHomophobie"));
        inv.setItem(17, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cPublicité"));


        inv.setItem(18, getItem(new ItemStack(Material.ENDER_PEARL), "§cPseudo Incorrect"));
        inv.setItem(19, getItem(new ItemStack(Material.ENDER_PEARL), "§cSkin Incorrect"));
        inv.setItem(20, getItem(new ItemStack(Material.ENDER_PEARL), "§cExploitation de Bug"));
        inv.setItem(21, getItem(new ItemStack(Material.ENDER_PEARL), "§cTpkill"));
        inv.setItem(22, getItem(new ItemStack(Material.ENDER_PEARL), "§cGrief"));
        inv.setItem(23, getItem(new ItemStack(Material.ENDER_PEARL), "§cTrahison"));
        inv.setItem(24, getItem(new ItemStack(Material.ENDER_PEARL), "§c Arnaque"));
        return inv;
    }


}
