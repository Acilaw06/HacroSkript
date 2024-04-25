package fr.acilaw.hacroskript;

import fr.acilaw.hacroskript.Command.GamblingCommand;
import fr.acilaw.hacroskript.RedirectionCommand.RedirectionPlaytime;
import fr.acilaw.hacroskript.RedirectionCommand.RedirectionPoubelle;
import fr.acilaw.hacroskript.Staff.Staff;
import fr.acilaw.hacroskript.Staff.StaffEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("&8[&eHacro&6Skript&8] &a Le plugin vient de démarrer !");
        this.getCommand("gambling").setExecutor(new GamblingCommand());
        this.getCommand("poubelle").setExecutor(new RedirectionPoubelle());
        this.getCommand("pt").setExecutor(new RedirectionPlaytime());
        this.getCommand("staff").setExecutor(new Staff());
        getServer().getPluginManager().registerEvents(new StaffEvents(),this);

    }

    @Override
    public void onDisable() {
        System.out.println("&8[&eHacro&6Skript&8] &c Le plugin vient s'éteindre !");
    }
}
