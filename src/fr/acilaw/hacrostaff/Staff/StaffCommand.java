package fr.acilaw.hacrostaff.Staff;

import fr.acilaw.hacrostaff.ItemBuilder.GetItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class StaffCommand extends GetItem implements CommandExecutor {

    public HashMap<UUID, Boolean> staffActive = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(player.hasPermission("group.moderateur")){

            if(!staffActive.containsKey(player.getUniqueId()) || !staffActive.get(player.getUniqueId())){

                player.getInventory().clear();

                staffActive.put(((Player) commandSender).getUniqueId(), true);
                player.sendMessage("§8[§eCrom§6Chat§8] §aTu es passé en mode staff");

                player.getInventory().addItem(
                        getItem(new ItemStack(Material.SHEARS), "§cTue un joueur",
                                "§b",
                                "§eCet objet permet de §atuer un joueur",
                                "§elorsque tu effectues un §aclique droit",
                                "§esur le §ajoueur concerné",
                                "§b"),
                        getItem(new ItemStack(Material.FEATHER), "§bActive le fly",
                                "§b",
                                "§eCet objet permet §ad'activer le fly §esur",
                                "§ele serveur, clique droit pour §aactiver",
                                "§aou désactiver",
                                "§b"),
                        getItem(new ItemStack(Material.SHEARS), "§eActive le God",
                                "§b",
                                "§eCet objet permet §ad'activer le God §esur",
                                "§ele serveur, clique droit pour §aactiver",
                                "§aou désactiver",
                                "§b"),
                        getItem(new ItemStack(Material.NETHER_STAR), "§eActive le Speed",
                                "§b",
                                "§eCet objet permet §ad'avoir Speed 2 §esur",
                                "§ele serveur, clique droit pour §aactiver",
                                "§aou désactiver",
                                "§b"),
                        getItem(new ItemStack(Material.STICK), "§eKnockBack Test",
                                "§b",
                                "§aClique droit sur un joueur §epour savoir",
                                "§esi il prend §abien des knockbacks §esur",
                                "§ele serveur",
                                "§b"),
                        getItem(new ItemStack(Material.COMPASS), "§eCPS Test",
                                "§b",
                                "§aClique droit sur un joueur §epour savoir le",
                                "§anombre de CPS §equ'il effectue actuellement.",
                                "§b"),
                        getItem(new ItemStack(Material.REDSTONE), "§2Vanish",
                                "§b",
                                "§aClique droit pour §aactiver/désactiver §ele §avanish",
                                "§esur le serveur.",
                                "§b"),
                        getItem(new ItemStack(Material.WATCH), "§dTéléportation Aléatoire",
                                "§b",
                                "§aClique droit §epour te §atéléporter §eà un joueur",
                                "§aaléatoire sur le serveur.",
                                "§b"),
                        getItem(new ItemStack(Material.CHEST), "§dOuvrir l'inventaire",
                                "§b",
                                "§aClique gauche/droit §epour ouvrir l'inventaire",
                                "§ed'un joueur et §avoir son contenu.",
                                "§b"));



                // Activation of fly, vanish and god
                player.getServer().dispatchCommand(player, "fly on");
                player.getServer().dispatchCommand(player, "vanish on");
                player.getServer().dispatchCommand(player, "god on");

            }else{
                ((Player) commandSender).getInventory().clear();
                staffActive.put(player.getUniqueId(), false);

                // Deactivation of fly, vanish and god
                player.getServer().dispatchCommand(player, "fly off");
                player.getServer().dispatchCommand(player, "vanish off");
                player.getServer().dispatchCommand(player, "god off");

                player.sendMessage("§8[§eCrom§6Chat§8] §cTu as quitté le mode staff");
            }
            return true;
        }else{
            player.sendMessage("§8[§eCrom§6Chat§8] §cCette commande est inconnue");
            return false;
        }
    }
}