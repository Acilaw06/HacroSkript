package fr.acilaw.hacrostaff.Staff.Punish;

import fr.acilaw.hacrostaff.HacroStaff;
import fr.acilaw.hacrostaff.Staff.ItemBuilder.GetItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishGuiTime extends GetItem implements CommandExecutor, Listener {


    private final String invName = "§2Choisir une durée";
    private String duration = "1d";
    private String punishedPlayer;
    private String typeSanction;
    private String motif;

    public PunishGuiTime(HacroStaff plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {

            commandSender.sendMessage("§cSeul un joueur peut faire cette commande");
            return true;
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
        punishedPlayer = Bukkit.getPlayer(strings[1]).getDisplayName();
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

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if(!(event.getView().getTitle().equals(invName))) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        switch(slot) {
            case 0: duration = "30m"; break;
            case 1: duration = "1h"; break;
            case 2: duration = "6h"; break;
            case 3: duration = "1d"; break;
            case 4: duration = "7d"; break;
            case 5: duration = "14d"; break;
            case 6: duration = "1mo"; break;
            case 7: duration = "2mo"; break;
            case 8: duration = "3mo"; break;
            case 9: duration = "6mo"; break;
            case 10: duration = "1y"; break;
            default:
                duration = ""; break;
        }

        player.getServer().dispatchCommand(player,typeSanction + " " + punishedPlayer + " " + duration + " " + motif);
        player.closeInventory();

        event.setCancelled(true);
    }


}
