package fr.acilaw.hacrostaff.Command;

import fr.acilaw.hacrostaff.HacroStaff;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CpsCommand implements CommandExecutor, Listener {

    private static final Map<UUID, Integer> cpsMap = new HashMap<>();
    private static final Map<UUID, Integer> cpsCountdown = new HashMap<>();

    public CpsCommand(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls des joueurs peuvent faire cette commande.");
            return false;
        }

        if (!sender.hasPermission("group.moderateur")) {
            sender.sendMessage("§8[§eHacro§6Staff§8] §cVous n'avez pas la permission d'exécuter cette commande.");
            return false;
        }

        if (args.length != 1) {
            sender.sendMessage("§8[§eHacro§6Staff§8] §cUsage: /cps <player>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            sender.sendMessage("§8[§eHacro§6Staff§8] §cJoueur pas trouvé ou pas en ligne !");
            return false;
        }

        startCpsTracking(target, (Player) sender);
        sender.sendMessage("§8[§eHacro§6Staff§8] §aLancement du test pour " + target.getName() + "...");

        return true;
    }

    public void startCpsTracking(Player target, Player player) {
        if (cpsCountdown.containsKey(target.getUniqueId())) {
            player.sendMessage("§8[§eHacro§6Staff§8] §cLe test est déjà en cours pour ce joueur !");
            return;
        }

        cpsCountdown.put(target.getUniqueId(), 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                int countdown = cpsCountdown.get(target.getUniqueId());
                if (countdown <= 0) {
                    cancel();
                    int cps = cpsMap.getOrDefault(target.getUniqueId(), 0) / 10;
                    player.sendMessage("§8[§eHacro§6Staff§8] §cRésultat: Le joueur " + target.getName() + " a une moyenne de " + cps + " CPS.");
                    cpsMap.remove(target.getUniqueId());
                    cpsCountdown.remove(target.getUniqueId());
                } else {
                    cpsCountdown.put(target.getUniqueId(), countdown - 1);
                    int cps = cpsMap.getOrDefault(target.getUniqueId(), 0);
                    if(cps == 0){
                        cps = 0;
                    }
                    cps = cps / 10;
                    player.sendMessage("§8[§eHacro§6Staff§8] §cLe joueur " + target.getName() + " fait " + cps + " CPS.");
                }
            }
        }.runTaskTimer(HacroStaff.getPlugin(HacroStaff.class), 0, 20);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (cpsCountdown.containsKey(player.getUniqueId())) {
            int count = cpsMap.getOrDefault(player.getUniqueId(), 0);
            cpsMap.put(player.getUniqueId(), count + 1);
        }
    }
}
