package fr.acilaw.hacroskript;

import fr.acilaw.hacroskript.Command.GamblingCommand;
import fr.acilaw.hacroskript.RedirectionCommand.RedirectionPlaytime;
import fr.acilaw.hacroskript.RedirectionCommand.RedirectionPoubelle;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("§8[§eHacro§6Skript§8] §a Le plugin vient de démarrer !");
        this.getCommand("gambling").setExecutor(new GamblingCommand());
        this.getCommand("poubelle").setExecutor(new RedirectionPoubelle());
        this.getCommand("pt").setExecutor(new RedirectionPlaytime());
    }

    @Override
    public void onDisable() {
        System.out.println("§8[§eHacro§6Skript§8] §c Le plugin vient s'éteindre !");
    }
}
