package fr.acilaw.hacrostaff.Staff.Punish;

import fr.acilaw.hacrostaff.Staff.ItemBuilder.GetItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishGuiTime extends GetItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {

            commandSender.sendMessage("§cSeul un joueur peut faire cette commande");
            return true;
        }

        String invName = "§2Choisir une durée";

        Player player = (Player) commandSender;
        Inventory inv = Bukkit.createInventory(player, 9, invName);

        inv.setItem(0, getItem(new ItemStack(Material.PAPER), "§c1 Jour"));
        inv.setItem(1, getItem(new ItemStack(Material.PAPER), "§c7 Jours"));
        inv.setItem(2, getItem(new ItemStack(Material.PAPER), "§c14 Jours"));
        inv.setItem(3, getItem(new ItemStack(Material.PAPER), "§c1 Mois"));
        inv.setItem(4, getItem(new ItemStack(Material.PAPER), "§c2 Mois"));
        inv.setItem(5, getItem(new ItemStack(Material.PAPER), "§c3 Mois"));
        inv.setItem(6, getItem(new ItemStack(Material.PAPER), "§c6 Mois"));
        inv.setItem(7, getItem(new ItemStack(Material.PAPER), "§c1 an"));
        inv.setItem(8, getItem(new ItemStack(Material.PAPER), "§cDéfinitif"));
        return true;
    }
}
