package fr.acilaw.hacroskript.RedirectionCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RedirectionPoubelle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.getServer().dispatchCommand(commandSender, "playtime");
        return true;
    }
}