package me.vantahit;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("VantaHit enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("VantaHit disabled!");
    }
}
