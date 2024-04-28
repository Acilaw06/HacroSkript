package fr.acilaw.hacrostaff.Staff.ItemBuilder;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class GetItem extends JavaPlugin {

    public ItemStack getItem(ItemStack item, String name, List<String> lore) {
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        lore.addAll(lore);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

}
