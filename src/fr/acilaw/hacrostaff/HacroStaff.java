package fr.acilaw.hacrostaff;

import fr.acilaw.hacrostaff.Staff.StaffCommand;
import fr.acilaw.hacrostaff.Staff.StaffEvents;
import fr.acilaw.hacrostaff.Staff.RandomTeleportPlayer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class HacroStaff extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getLogger().info("§8[§eHacro§6Staff§8] §a Le plugin vient de démarrer !");
        this.getCommand("staff").setExecutor(new StaffCommand());
        this.getCommand("randomTeleportPlayer").setExecutor(new RandomTeleportPlayer());
        getServer().getPluginManager().registerEvents(new StaffEvents(),this);

    }

    @Override
    public void onDisable() {
        this.getLogger().info("§8[§eHacro§6Staff§8] §c Le plugin vient s'éteindre !");
    }
}