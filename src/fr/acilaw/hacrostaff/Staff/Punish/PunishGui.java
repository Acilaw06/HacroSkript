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

public class PunishGui extends GetItem implements Listener, CommandExecutor {

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

        inv.setItem(0, getItem(new ItemStack(Material.PAPER), "§cTest", "§c", "§eSalut"));
        inv.setItem(5, getItem(new ItemStack(Material.PAPER), "§cTest", "§c", "§eSalut"));
        for(int i = 1; i < inv.getSize(); i++){
            if(inv.getItem(i) == null){
                inv.setItem(i, getItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 4), "", ""));
            }
        }
        player.openInventory(inv);

        return true;
    }
}