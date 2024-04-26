package fr.acilaw.hacrostaff.Staff;

import org.bukkit.Server;
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

            Server server = event.getPlayer().getServer();
            Player player = event.getPlayer();
            
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§cTue un joueur")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    server.dispatchCommand(player,"kill " + touchedPlayer.getName());
                }else{
                player.sendMessage("§8[§eCrom§6Chat§8] §cVous devez toucher un joueur");
                }  
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§eKnockBack Test")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    server.dispatchCommand(player,"vulcan kb " + touchedPlayer.getName());
                }else{
                    player.sendMessage("§8[§eCrom§6Chat§8] §cVous devez toucher un joueur");
                }
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§eCPS Test")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    server.dispatchCommand(player,"vulcan cps " + touchedPlayer.getName());
                }else{
                    player.sendMessage("§8[§eCrom§6Chat§8] §cVous devez toucher un joueur");
                }
            }
            if (itemMeta != null && Objects.equals(itemMeta.getDisplayName(), "§dOuvrir l'inventaire")) {
                if (event.getRightClicked() instanceof Player) {
                    Player touchedPlayer = (Player) event.getRightClicked();
                    server.dispatchCommand(player,"invsee " + touchedPlayer.getName());
                }else{
                    player.sendMessage("§8[§eCrom§6Chat§8] §cVous devez toucher un joueur");
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
                
                Server server = event.getPlayer().getServer();
                Player player = event.getPlayer();
                
                if (Objects.equals(itemMeta.getDisplayName(), "§bActive le fly")) {
                    server.dispatchCommand(player, "fly");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§eActive le God")) {
                    server.dispatchCommand(player, "god");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§eActive le Speed")) {
                    server.dispatchCommand(player, "speed 2");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§2Vanish")) {
                    server.dispatchCommand(player, "vanish");
                } else if (Objects.equals(itemMeta.getDisplayName(), "§dTéléportation Aléatoire")) {
                    server.dispatchCommand(player, "randomteleportplayer");
                }
            }
        }
    }
}
