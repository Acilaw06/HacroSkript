package fr.acilaw.hacrostaff.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Collection;
import java.util.Random;

public class RandomTeleportPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cCette commande ne peut être exécutée que par un joueur !");
            return false;
        }

        if(commandSender.hasPermission("group.moderateur")) {
            Collection<Player> onlinePlayers = (Collection<Player>) Bukkit.getOnlinePlayers();

            if(onlinePlayers.isEmpty()) {
                commandSender.sendMessage("§8[§eCrom§6Chat§8] §cIl n'y aucun joueur de connecté sur le serveur.");
            }
            int randomIndex = new Random().nextInt(onlinePlayers.size());

            Player randomPlayer = (Player) onlinePlayers.toArray()[randomIndex];

            Player player = (Player) commandSender;

            player.teleport(randomPlayer.getLocation());
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §aTu as été téléporté à " + randomPlayer.getDisplayName());
            return true;
        }else {
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cCette commande est inconnue");
            return false;
        }
    }
}
