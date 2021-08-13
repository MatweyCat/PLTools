package com.matweycat.pltools;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

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

    @EventHandler
    public void changeworld(PlayerChangedWorldEvent c) {
        Player p = c.getPlayer();
        String s1 = plugin.getConfig().getString("massanger.changeworld");
        s1 = s1.replace("&", "\u00a7");
        p.sendMessage(s1 + " " + p.getWorld().getName());
    }

    @EventHandler
    public void teleport(PlayerTeleportEvent t) {
        Player p = t.getPlayer();
        String s2 = plugin.getConfig().getString("massanger.teleport");
        s2 = s2.replace("&", "\u00a7");
        p.sendMessage(s2 + " " + t.getTo().getBlockX() + " " + t.getTo().getBlockY() + " " + t.getTo().getBlockZ());
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent r) {
        Player p = r.getPlayer();
        String s3 = plugin.getConfig().getString("messanger.respawn");
        s3 = s3.replace("&", "\u00a7");
        p.sendMessage(s3);
    }
}
