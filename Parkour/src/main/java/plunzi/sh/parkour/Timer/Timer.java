package plunzi.sh.parkour.Timer;


import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import plunzi.sh.parkour.Main;

public class Timer {
    private boolean running;
    private int time;

    public void timer(boolean running, int time) {
        this.running = running;
        this.time = time;
        run();
    }

    //Timer timer = new Timer(false, 0)


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {

        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void send_Action_bar() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + "The Game hasn't started."));
                continue;
            }
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTime()));
            //player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + "The Game is starting soon!"));
        }
    }

    private void run(){
        new BukkitRunnable() {
            @Override
            public void run() {

                send_Action_bar();

                if (!isRunning()) {
                    return;
                }
                setTime(getTime()-1);
                if (getTime() == 0){
                    setRunning(false);

                }
            }
        }.runTaskTimer(Main.getInstance(), 20,20);
    }
}

