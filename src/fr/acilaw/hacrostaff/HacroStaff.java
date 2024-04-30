package fr.acilaw.hacrostaff;

import fr.acilaw.hacrostaff.Command.CpsCommand;
import fr.acilaw.hacrostaff.Command.RandomTeleportPlayer;
import fr.acilaw.hacrostaff.Punish.*;
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
        this.getCommand("cps").setExecutor(new CpsCommand(this));


        // Punish Command

        this.getCommand("punish").setExecutor(new PunishGui());
        getServer().getPluginManager().registerEvents(new PunishGuiListener(),this);

        // Punish Gui Time Listener
        getServer().getPluginManager().registerEvents(new PunishGuiTimeListener(),this);


        // Punish Gui Sanction Listener
        getServer().getPluginManager().registerEvents(new PunishGuiSanctionListener(),this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§8[§eHacro§6Staff§8] §c Le plugin vient s'éteindre !");
    }
}