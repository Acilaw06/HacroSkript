package fr.acilaw.hacrostaff.Punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishGuiTimeListener extends PunishGuiTimeAndSanction implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if(!(event.getView().getTitle().equals(invTimeName))) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        switch(slot) {
            case 19: duration = "30m"; break;
            case 20: duration = "1h"; break;
            case 21: duration = "6h"; break;
            case 22: duration = "1d"; break;
            case 23: duration = "7d"; break;
            case 24: duration = "14d"; break;
            case 25: duration = "1mo"; break;
            case 28: duration = "2mo"; break;
            case 29: duration = "3mo"; break;
            case 30: duration = "6mo"; break;
            case 31: duration = "1y"; break;
            case 32: duration = ""; break;
        }

        player.closeInventory();
        player.openInventory(punishGuiSanction(player));

        event.setCancelled(true);
    }
}
