package com.matweycat.pltools;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private Main plugin;

    public Commands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("pltools.reload")) {
            Player p = (Player) sender;
            String s = plugin.getConfig().getString("massanger.join");
            s = s.replace("&", "\u00a7");
            p.sendMessage(s);
            return true;
        }

        plugin.reloadConfig();
        sender.sendMessage(ChatColor.GREEN + "Конфиг перезагружен!");

        return true;
    }
}
