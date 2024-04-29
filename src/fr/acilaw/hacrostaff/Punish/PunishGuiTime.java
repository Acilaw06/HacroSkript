package fr.acilaw.hacrostaff.Punish;


import fr.acilaw.hacrostaff.ItemBuilder.GetItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishGuiTime extends GetItem implements CommandExecutor, Listener {


    public final String invName = "§2Choisir une durée";
    public String duration;
    public String punishedPlayer;
    public String typeSanction;
    public String motif;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {

            commandSender.sendMessage("§cSeul un joueur peut faire cette commande");
            return true;
        }


        if(!(commandSender.hasPermission("group.moderateur"))){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu n'as pas la permission de faire cette commande.");
        }

        if(strings.length < 3){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu dois choisir un type de sanction");
            return true;
        }

        if(strings.length > 3){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu ne peux pas choisir plus de 3 arguments");
            return true;
        }


        Player player = (Player) commandSender;
        typeSanction = strings[0];
        punishedPlayer = Bukkit.getPlayer(strings[1]).getName();
        motif = strings[2];
        Inventory inv = Bukkit.createInventory(player, 18, invName);


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

        player.openInventory(inv);
        return true;
    }


}
