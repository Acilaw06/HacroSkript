package fr.acilaw.hacroskript.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GamblingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            commandSender.sendMessage("§7§m----------------------------\n&e \n§eDans cette arène vous pouvez §acombattre\n§eavec un §astuff prédéfini §eet pariez de\n§al'argent §eentre vous.\n \n§6§lCommande importante\n§a/duel send (pseudo)\n§a/duel accept (pseudo)\n \n§7§m----------------------------");
        }else{
            commandSender.sendMessage("Seul un joueur peut faire cette commande !");
        }
        return true;
    }
}
