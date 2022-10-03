package plunzi.sh.parkour.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class teleporter_start {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location loc = new Location(Bukkit.getWorld("world"), 0, 0, 0, 0, 0);
        player.teleport(loc);
    }

}
