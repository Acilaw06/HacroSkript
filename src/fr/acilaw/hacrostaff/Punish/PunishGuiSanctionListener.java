package fr.acilaw.hacrostaff.Punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishGuiSanctionListener extends PunishGuiTimeAndSanction implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(!(e.getView().getTitle().equals(invSanctionName))) {
            return;
        }

        Player player = (Player) e.getWhoClicked();
        int slot = e.getSlot();

        motif = e.getCurrentItem().getItemMeta().getDisplayName();

        executeCommand(player);

        e.setCancelled(true);
    }
}
