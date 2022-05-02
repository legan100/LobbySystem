package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.commands.CMD_Build;
import de.legan100.lobbysystem.commands.CMD_Fly;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class ToggleFlyListener implements Listener {
    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("System.Spieler"))
            if (p.getGameMode() == GameMode.SURVIVAL)
                if (!CMD_Fly.allowedFly.contains(p) && !CMD_Build.allowedBuild.contains(p)) {
                    e.setCancelled(true);
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.setVelocity(p.getLocation().getDirection().multiply(1).add(new Vector(0.0D, 0.8D, 0.0D)));
                }
    }
}
