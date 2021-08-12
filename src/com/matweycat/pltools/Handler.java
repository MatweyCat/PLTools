package com.matweycat.pltools;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Handler implements Listener {
    private Main plugin;

    public Handler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String s = plugin.getConfig().getString("massanger.join");
        s = s.replace("&", "\u00a7");
        p.sendMessage(s);
    }
}
