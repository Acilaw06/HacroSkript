package fr.acilaw.hacrostaff.Staff;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class StaffCommand implements CommandExecutor {

    // Kill Item
    private static ItemStack ItemName;
    private static ArrayList<String> ItemLore;

    public HashMap<UUID, Boolean> staffActive = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(player.hasPermission("group.moderateur")){

            if(!staffActive.containsKey(player.getUniqueId()) || !staffActive.get(player.getUniqueId())){

                player.getInventory().clear();

                staffActive.put(((Player) commandSender).getUniqueId(), true);
                player.sendMessage("§8[§eCrom§6Chat§8] §aTu es passé en mode staff");

                killItem();
                player.getInventory().addItem(ItemName);
                flyItem();
                player.getInventory().addItem(ItemName);
                godItem();
                player.getInventory().addItem(ItemName);
                speedItem();
                player.getInventory().addItem(ItemName);
                knockbackItem();
                player.getInventory().addItem(ItemName);
                cpsItem();
                player.getInventory().addItem(ItemName);
                vanishItem();
                player.getInventory().addItem(ItemName);
                randomteleportItem();
                player.getInventory().addItem(ItemName);
                invseeItem();
                player.getInventory().addItem(ItemName);

                // Activation of fly, vanish and god
                player.getServer().dispatchCommand(player, "fly on");
                player.getServer().dispatchCommand(player, "vanish on");
                player.getServer().dispatchCommand(player, "god on");

            }else{
                ((Player) commandSender).getInventory().clear();
                staffActive.put(player.getUniqueId(), false);

                // Desactivation of fly, vanish and god
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

    private void killItem(){
        ItemName = new ItemStack(Material.SHEARS);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§cTue un joueur"); // You should use color codes with § symbol
        ItemLore.add("§b");
        ItemLore.add("§eCet objet permet de §atuer un joueur");
        ItemLore.add("§elorsque tu effectues un §aclique droit");
        ItemLore.add("§esur le §ajoueur concerné");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void flyItem(){
        ItemName = new ItemStack(Material.FEATHER);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§bActive le fly");
        ItemLore.add("§b");
        ItemLore.add("§eCet objet permet §ad'activer le fly §esur");
        ItemLore.add("§ele serveur, clique droit pour §aactiver");
        ItemLore.add("§aou désactiver");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void godItem(){
        ItemName = new ItemStack(Material.NETHER_STAR);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§eActive le God");
        ItemLore.add("§b");
        ItemLore.add("§eCet objet permet §ad'activer le God §esur");
        ItemLore.add("§ele serveur, clique droit pour §aactiver");
        ItemLore.add("§aou désactiver");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void speedItem(){
        ItemName = new ItemStack(Material.SUGAR);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§eActive le Speed");
        ItemLore.add("§b");
        ItemLore.add("§eCet objet permet §ad'avoir Speed 2 §esur");
        ItemLore.add("§ele serveur, clique droit pour §aactiver");
        ItemLore.add("§aou désactiver");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void knockbackItem(){
        ItemName = new ItemStack(Material.STICK);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§eKnockBack Test");
        ItemLore.add("§b");
        ItemLore.add("§aClique droit sur un joueur §epour savoir");
        ItemLore.add("§esi il prend §abien des knockbacks §esur");
        ItemLore.add("§ele serveur");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void cpsItem(){
        ItemName = new ItemStack(Material.COMPASS);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§eCPS Test");
        ItemLore.add("§b");
        ItemLore.add("§aClique droit sur un joueur §epour savoir le");
        ItemLore.add("§anombre de CPS §equ'il effectue actuellement.");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void vanishItem(){
        ItemName = new ItemStack(Material.REDSTONE);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§2Vanish");
        ItemLore.add("§b");
        ItemLore.add("§aClique droit pour §aactiver/désactiver §ele §avanish");
        ItemLore.add("§esur le serveur.");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void randomteleportItem(){
        ItemName = new ItemStack(Material.WATCH);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§dTéléportation Aléatoire");
        ItemLore.add("§b");
        ItemLore.add("§aClique droit §epour te §atéléporter §eà un joueur");
        ItemLore.add("§aaléatoire sur le serveur.");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }

    private void invseeItem(){
        ItemName = new ItemStack(Material.CHEST);
        ItemLore = new ArrayList<>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§dOuvrir l'inventaire");
        ItemLore.add("§b");
        ItemLore.add("§aClique gauche/droit §epour ouvrir l'inventaire");
        ItemLore.add("§ed'un joueur et §avoir son contenu.");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);

        ItemName.setItemMeta(killMeta);
    }
}