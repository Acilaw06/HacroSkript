package fr.acilaw.hacrostaff.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FreezeCommand implements CommandExecutor {

    private static boolean freezeState = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cCette commande ne peut être exécutée que par un joueur !");
            return false;
        }

        if(commandSender.hasPermission("group.moderateur")){

            if((Bukkit.getPlayer(strings[0]) != null)){
                Player target = Bukkit.getPlayer(strings[0]);
                if(!freezeState){
                    freezeState = true;
                    target.sendMessage("§8[§c§lSanction§8] §cVous avez été freeze par un staff.");
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,Integer.MAX_VALUE,255));
                }
                else{
                    freezeState = false;
                    target.removePotionEffect(PotionEffectType.SLOW);
                    target.removePotionEffect(PotionEffectType.BLINDNESS);
                    target.sendMessage("§8[§c§lSanction§8] §aVous avez été défreeze par un staff.");
                }
            } else {
                commandSender.sendMessage("§8[§eCrom§6Chat§8] §cLe joueur spécifié n'est pas en ligne !");
            }
        } else {
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cUtilisation: /freeze <joueur>");
        }
        return true;
    }
}
