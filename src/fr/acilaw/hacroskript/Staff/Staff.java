package fr.acilaw.hacroskript.Staff;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Staff implements CommandExecutor {

    // Kill Item
    public ItemStack killItem;
    public ArrayList<String> loreKillItem;


    // Fly Item
    public ItemStack flyItem;
    public ArrayList<String> loreFlyItem;


    public Staff(){
        KillItem();
        FlyItem();
    }

    public void KillItem(){
        killItem = new ItemStack(Material.STICK);
        loreKillItem = new ArrayList<String>();

        ItemMeta killMeta = killItem.getItemMeta();
        killMeta.setDisplayName("§cTue un joueur"); // You should use color codes with § symbol
        loreKillItem.add("§b");
        loreKillItem.add("§eCet objet permet de §atuer un joueur");
        loreKillItem.add("§elorsque tu effectues un §aclique droit");
        loreKillItem.add("§esur le §ajoueur concerné");
        loreKillItem.add("§b");
        killMeta.setLore(loreKillItem);

        // Apply meta to the item
        killItem.setItemMeta(killMeta);
    }

    public void FlyItem(){
        flyItem = new ItemStack(Material.FEATHER);
        loreFlyItem = new ArrayList<String>();

        ItemMeta killMeta = flyItem.getItemMeta();
        killMeta.setDisplayName("§bActive le fly"); // You should use color codes with § symbol
        loreFlyItem.add("§b");
        loreFlyItem.add("§eCet objet permet §ad'activer le fly §esur");
        loreFlyItem.add("§ele serveur, clique droit pour §aactiver");
        loreFlyItem.add("§aou désactiver");
        loreFlyItem.add("§b");
        killMeta.setLore(loreFlyItem);

        // Apply meta to the item
        flyItem.setItemMeta(killMeta);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        player.getInventory().clear();
        player.getInventory().addItem(killItem);
        player.getInventory().addItem(flyItem);
        return true;
    }

    // Kill Item


}