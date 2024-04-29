package fr.acilaw.hacrostaff;

import fr.acilaw.hacrostaff.Command.RandomTeleportPlayer;
import fr.acilaw.hacrostaff.Punish.PunishGui;
import fr.acilaw.hacrostaff.Punish.PunishGuiListener;
import fr.acilaw.hacrostaff.Punish.PunishGuiTime;
import fr.acilaw.hacrostaff.Punish.PunishGuiTimeListener;
import fr.acilaw.hacrostaff.Staff.StaffCommand;
import fr.acilaw.hacrostaff.Staff.StaffEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class HacroStaff extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getLogger().info("§8[§eHacro§6Staff§8] §a Le plugin vient de démarrer !");

        // Staff Command
        this.getCommand("staff").setExecutor(new StaffCommand());
        getServer().getPluginManager().registerEvents(new StaffEvents(),this);

        // Command
        this.getCommand("randomteleportplayer").setExecutor(new RandomTeleportPlayer());


        // Punish Command

        this.getCommand("punish").setExecutor(new PunishGui());
        getServer().getPluginManager().registerEvents(new PunishGuiListener(),this);

        this.getCommand("punishtime").setExecutor(new PunishGuiTime());
        getServer().getPluginManager().registerEvents(new PunishGuiTimeListener(),this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§8[§eHacro§6Staff§8] §c Le plugin vient s'éteindre !");
    }
}