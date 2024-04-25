package fr.acilaw.hacrostaff;

import fr.acilaw.hacrostaff.Staff.Staff;
import fr.acilaw.hacrostaff.Staff.StaffEvents;
import fr.acilaw.hacrostaff.Staff.randomTeleportPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("§8[§eHacro§6Staff§8] §a Le plugin vient de démarrer !");
        this.getCommand("staff").setExecutor(new Staff());
        this.getCommand("randomTeleportPlayer").setExecutor(new randomTeleportPlayer());
        getServer().getPluginManager().registerEvents(new StaffEvents(),this);

    }

    @Override
    public void onDisable() {
        System.out.println("§8[§eHacro§6Staff§8] §c Le plugin vient s'éteindre !");
    }
}
