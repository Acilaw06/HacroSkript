package fr.acilaw.hacrostaff.Punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishGuiListener extends PunishGui implements Listener {

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
}
