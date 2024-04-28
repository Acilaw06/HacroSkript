package fr.acilaw.hacrostaff.Staff;

import fr.acilaw.hacrostaff.HacroStaff;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PunishGui implements Listener,CommandExecutor {

    public PunishGui(HacroStaff plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!(event.getView().getTitle().equals("§cPunish Menu"))){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        event.setCancelled(true);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cSeul un joueur peut faire cette commande !");
            return true;
        }

        if(args.length == 0 || Bukkit.getPlayer(args[0]) == null){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu dois choisir un joueur.");
            return true;
        }

        Player player = (Player) commandSender;

        Inventory inv = Bukkit.createInventory(player, 54, "§cPunish Menu");


        // Create Item



        player.openInventory(inv);

        return true;
    }
}