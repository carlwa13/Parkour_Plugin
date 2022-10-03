package plunzi.sh.parkour.listener;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plunzi.sh.parkour.Main;
import plunzi.sh.parkour.Timer.Timer.*;


public class join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GOLD + "Es sind jetzt " + Bukkit.getOnlinePlayers().size() + " Gamer/s in the Lobby");
        event.setJoinMessage(ChatColor.GOLD.toString() + ChatColor.UNDERLINE + player.getDisplayName().toString() + " has joind the Lobby!");
        if(Bukkit.getOnlinePlayers().size() == 1) {
            player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "The Game starts in 5 seconds! With " + Bukkit.getOnlinePlayers().size() +" Gamers!");
            Main.getInstance().getTimer().setTime(5);
            Main.getInstance().getTimer().setRunning(true);
            if (Main.getInstance().getTimer().getTime() == 0){
                Bukkit.broadcastMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + "The Game is starting");

            }
        }
    }
}
