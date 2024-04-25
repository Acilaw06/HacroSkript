package fr.acilaw.hacroskript.Staff;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Staff implements CommandExecutor {

    // Kill Item
    public ItemStack ItemName;
    public ArrayList<String> ItemLore;


    public Staff(){
    }

    public void KillItem(){
        ItemName = new ItemStack(Material.SHEARS);
        ItemLore = new ArrayList<String>();

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

    public void FlyItem(){
        ItemName = new ItemStack(Material.FEATHER);
        ItemLore = new ArrayList<String>();

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

    public void GodItem(){
        ItemName = new ItemStack(Material.NETHER_STAR);
        ItemLore = new ArrayList<String>();

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

    public void SpeedItem(){
        ItemName = new ItemStack(Material.SUGAR);
        ItemLore = new ArrayList<String>();

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

    public void knockbackItem(){
        ItemName = new ItemStack(Material.STICK);
        ItemLore = new ArrayList<String>();

        ItemMeta killMeta = ItemName.getItemMeta();
        killMeta.setDisplayName("§eKnockBack Test");
        ItemLore.add("§b");
        ItemLore.add("§aFrappe un joueur §epour savoir si il prend");
        ItemLore.add("§abien des knockbacks §esur le serveur");
        ItemLore.add("§b");
        killMeta.setLore(ItemLore);
        ItemName.addUnsafeEnchantment(Enchantment.KNOCKBACK,2);

        ItemName.setItemMeta(killMeta);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        player.getInventory().clear();
        KillItem();
        player.getInventory().addItem(ItemName);
        FlyItem();
        player.getInventory().addItem(ItemName);
        GodItem();
        player.getInventory().addItem(ItemName);
        SpeedItem();
        player.getInventory().addItem(ItemName);
        knockbackItem();
        player.getInventory().addItem(ItemName);
        return true;
    }

    // Kill Item


}