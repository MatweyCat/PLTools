package com.matweycat.pltools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    private static Main instance;
    private List<Log> logs = new ArrayList<>();

    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
            this.getLogger().warning("Конфиг создан!");
        }

        Bukkit.getPluginManager().registerEvents(new Handler(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("plreload").setExecutor(new Commands(this));

        this.getLogger().info(ChatColor.GREEN + "Плагин активирован!");
    }

    public void addLog(Log log) {
        Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                synchronized (instance) {
                    logs.add(log);
                }
            }
        })
    }

    public static Main getInstance() {
        return instance;
    }

    public void onDisable() {
        this.getLogger().info(ChatColor.RED + "Плагин выключен.");
    }
}
