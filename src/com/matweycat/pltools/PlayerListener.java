package com.matweycat.pltools;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Main.getInstance().addLog(new Log(e.getPlayer().getName(), Action.join, "", System.currentTimeMillis()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Main.getInstance().addLog(new Log(e.getPlayer().getName(), Action.quit, "", System.currentTimeMillis()));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Main.getInstance().addLog(new Log(e.getPlayer().getName(), Action.command, e.getMessage(), System.currentTimeMillis()));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent e) {
        Main.getInstance().addLog(new Log(e.getPlayer().getName(), Action.chat, e.getMessage(), System.currentTimeMillis()));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onTeleport(PlayerTeleportEvent e) {
        Main.getInstance().addLog(new Log(e.getPlayer().getName(), Action.teleport,

                (e.getTo().getWorld().getName() + " " + e.getTo().getBlockX() + " " + e.getTo().getBlockY() + " " + e.getTo().getBlockZ())

                , System.currentTimeMillis()));
    }
}
