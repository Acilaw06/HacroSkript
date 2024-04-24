package fr.acilaw.hacroskript;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("§8[§eHacro§6Skript§8] §a Le plugin vient de démarrer !");
    }

    @Override
    public void onDisable() {
        System.out.println("§8[§eHacro§6Skript§8] §c Le plugin vient s'éteindre !");
    }
}
