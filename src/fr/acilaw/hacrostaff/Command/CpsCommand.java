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
import java.util.UUID;

public class CpsCommand implements CommandExecutor, Listener {

    private boolean testBool = false;
    private static HashMap<UUID, Integer> cpsMap = new HashMap<>();
    private int timer = 10;

    public CpsCommand(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls des joueurs peuvent faire cette commande.");
            return false;
        }

        if(sender.hasPermission("group.moderateur")) {
            Player player = (Player) sender;
            if (args.length != 1) {
                player.sendMessage("Usage: /cps <player>");
                return false;
            }

            Player target = player.getServer().getPlayer(args[0]);
            if (target == null) {
                player.sendMessage("Joueur pas trouvé!");
                return false;
            }

            startCpsTracking(target, player);

            player.sendMessage("§8[§eHacro§6Staff§8] §aLancement du test pour " + target.getName() + "...");
        }
        return true;
    }

    public void startCpsTracking(Player target, Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                testBool = true;
                if (timer <= 0) {
                    cancel();
                    int cps = cpsMap.getOrDefault(target.getUniqueId(), 0) / 10;
                    player.sendMessage("§8[§eHacro§6Staff§8] §cRésultat: Le joueur " + target.getName() + " a fait " + cps + " CPS.");
                    cpsMap.remove(target.getUniqueId());
                } else {
                    timer--;
                    testBool = false;
                    int cps = cpsMap.getOrDefault(target.getUniqueId(), 0) / (10-timer);
                    player.sendMessage("§8[§eHacro§6Staff§8] §cLe joueur " + target.getName() + " fait " + cps + " CPS.");
                }
            }
        }.runTaskTimer(HacroStaff.getPlugin(HacroStaff.class), 0, 20); // 20 ticks = 1 seconde
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(testBool){
            Player player = event.getPlayer();
            int count = cpsMap.getOrDefault(player.getUniqueId(), 0);
            cpsMap.put(player.getUniqueId(), count + 1);
        }
    }
}
