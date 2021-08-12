package com.matweycat.pltools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
            this.getLogger().warning("Конфиг создан!");
        }

        Bukkit.getPluginManager().registerEvents(new Handler(this), this);
        getCommand("plreload").setExecutor(new Commands(this));

        this.getLogger().info(ChatColor.GREEN + "Плагин активирован!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.RED + "Плагин выключен.");
    }
}
