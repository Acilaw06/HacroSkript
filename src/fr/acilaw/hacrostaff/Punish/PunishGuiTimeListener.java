package fr.acilaw.hacrostaff.Punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishGuiTimeListener extends PunishGuiTime implements Listener {

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
