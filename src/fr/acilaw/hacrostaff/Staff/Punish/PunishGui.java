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

    private String punishedPlayer;

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

        switch (slot){
            case 9:
                player.closeInventory();
                player.getServer().dispatchCommand(player, "punishtime ban " + punishedPlayer + " Cheat");
                break;
            case 10:
                player.closeInventory();
                player.getServer().dispatchCommand(player,"punishtime ban " + punishedPlayer + " Exploitation_de_Bugs");
                break;
            case 11:
                player.closeInventory();
                player.getServer().dispatchCommand(player,"punishtime mute " + punishedPlayer + " Languages_Inappropriés");
                break;
            case 20:
                player.closeInventory();
                player.getServer().dispatchCommand(player,"warn " + punishedPlayer + " Languages_Innapropriés");
                break;
        }

        event.setCancelled(true);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cSeul un joueur peut faire cette commande !");
            return true;
        }

        if(!(commandSender.hasPermission("group.moderateur"))){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu n'as pas la permission de faire cette commande.");
        }

        if(args.length == 0 || Bukkit.getPlayer(args[0]) == null){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu dois choisir un joueur.");
            return true;
        }

        Player player = (Player) commandSender;
        punishedPlayer = Bukkit.getPlayer(args[0]).getName();

        // Create Punish Menu

        Inventory inv = Bukkit.createInventory(player, 27, "§cPunish Menu");

        // Create Item

        inv.setItem(0, getItem(new ItemStack(Material.DIAMOND_SWORD), "§cCheat", "§c", "§7▪ §eChoisis la §asanction approprié", "§ejuste en dessous.", "§c", "§eType: §aCheats, Autoclick ...", "§c"));
        inv.setItem(1, getItem(new ItemStack(Material.WATCH), "§cGameplay", "§c", "§7▪ §eChoisis §ala sanction approprié", "§ejuste en dessous.", "§c", "§eType: §aExploitation de bugs, Commandes ...", "§c"));
        inv.setItem(2, getItem(new ItemStack(Material.BOOK_AND_QUILL), "§cChat", "§c", "§7▪ §eChoisis la §asanction approprié", "§ejuste en dessous.", "§c", "§eType: §aInsulte, Provocation, Spam", "§c"));

        // Duration Item
        // Cheats Sanction Item
        inv.setItem(9, getItem(new ItemStack(Material.IRON_FENCE), "§cBannissement", "§c", "§7▪ §eClique pour §achoisir la durée", "§eapproprié à la §asanction.", "§c"));

        // Gameplay Sanction Item

        inv.setItem(10, getItem(new ItemStack(Material.IRON_FENCE), "§cBannissement", "§c", "§7▪ §eClique pour §achoisir la durée", "§eapproprié à la §asanction.", "§c"));


        // Language Sanction Item
        inv.setItem(11, getItem(new ItemStack(Material.PAPER), "§cMute", "§c", "§7▪ §eClique pour §achoisir la durée", "§eapproprié à la §asanction.", "§c"));
        inv.setItem(20, getItem(new ItemStack(Material.BARRIER), "§cAvertissement", "§c", "§7▪ §eClique pour §asanctionner", "§ele joueur immédiatement", "§c"));


        for(int i = 1; i < inv.getSize(); i++){
            if(inv.getItem(i) == null){
                inv.setItem(i, getItem(new ItemStack(Material.STAINED_GLASS_PANE,1, (short) 4), "", ""));
            }
        }
        player.openInventory(inv);

        return true;
    }
}