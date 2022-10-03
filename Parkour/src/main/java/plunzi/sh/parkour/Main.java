package plunzi.sh.parkour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import plunzi.sh.parkour.Timer.Timer;
import plunzi.sh.parkour.listener.join;
import plunzi.sh.parkour.schematic.load;

public final class Main extends JavaPlugin {
    private static Main instance;
    public Timer timer;
    @Override
    public void onLoad() {
        instance = this;
    }
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[PARKOUR] Parkour_Plugin gestartet");
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new join(), this);
    }
    public static Main getInstance() {
        return instance;
    }

    public load Load() {
        return new load();
    }

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
