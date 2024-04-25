package fr.acilaw.hacroskript.Staff;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class StaffEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        if(Objects.equals(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName(), "§cTue un joueur")) {
            if(event.getRightClicked() instanceof Player) {
                Player touchedPlayer = (Player) event.getRightClicked();
                event.getPlayer().getServer().dispatchCommand(event.getPlayer(),"kill " + touchedPlayer.getDisplayName());
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(Objects.equals(event.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName(), "§bActive le fly")){
            event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "fly");
        }
    }
}
