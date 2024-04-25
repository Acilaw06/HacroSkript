package fr.acilaw.hacrostaff.Staff;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class StaffEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        ItemStack itemInHand = event.getPlayer().getInventory().getItemInHand();
        if (itemInHand != null && itemInHand.hasItemMeta()) {
            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§cTue un joueur")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(),"kill " + touchedPlayer.getName());
                }
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§eKnockBack Test")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(),"vulcan kb " + touchedPlayer.getName());
                }
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§eCPS Test")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(),"vulcan cps " + touchedPlayer.getName());
                }
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§dOuvrir l'inventaire")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(),"invsee " + touchedPlayer.getName());
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack itemInHand = event.getItem();
        if (itemInHand != null && itemInHand.hasItemMeta()) {
            ItemMeta itemMeta = itemInHand.getItemMeta();
            if (itemMeta != null) {
                if (Objects.equals(itemMeta.getDisplayName(), "§bActive le fly")) {
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "fly");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§eActive le God")) {
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "god");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§eActive le Speed")) {
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "speed 2");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§2Vanish")) {
                    event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "vanish");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§dTéléportation Aléatoire")) {
                event.getPlayer().getServer().dispatchCommand(event.getPlayer(), "randomteleportplayer");
            }
            }
        }
    }
}
