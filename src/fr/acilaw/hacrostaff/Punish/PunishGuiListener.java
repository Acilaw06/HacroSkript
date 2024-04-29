package fr.acilaw.hacrostaff.Punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishGuiListener extends PunishGuiTimeAndSanction implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!(event.getView().getTitle().equals("§cPunish Menu"))){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        switch (slot){
            case 9:
            case 10:
            case 11:
                sanctionType = "ban";
                player.closeInventory();
                player.openInventory(punishGuiTime(player));
                break;
            case 20:
                sanctionType = "mute";
                player.closeInventory();
                player.openInventory(punishGuiTime(player));
                break;
            case 29:
                sanctionType = "warn";
                player.closeInventory();
                player.openInventory(punishGuiSanction(player));
                break;
        }

        event.setCancelled(true);
    }
}