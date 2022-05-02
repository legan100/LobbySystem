package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.commands.CMD_Accept;
import de.legan100.lobbysystem.commands.CMD_Build;
import de.legan100.lobbysystem.commands.CMD_Fly;
import de.legan100.lobbysystem.commands.CMD_Spec;
import de.legan100.lobbysystem.commands.CMD_Vanish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        e.getPlayer().getInventory().clear();
        if (CMD_Build.allowedBuild.contains(e.getPlayer()))
            CMD_Build.allowedBuild.remove(e.getPlayer());
        if (CMD_Fly.allowedFly.contains(e.getPlayer()))
            CMD_Build.allowedBuild.remove(e.getPlayer());
        if (CMD_Vanish.isVannished.contains(e.getPlayer()))
            CMD_Vanish.isVannished.remove(e.getPlayer());
        if (CMD_Accept.allowedChat.contains(e.getPlayer()))
            CMD_Accept.allowedChat.remove(e.getPlayer());
        if (CMD_Spec.allowedPlayer.contains(e.getPlayer()))
            CMD_Spec.allowedPlayer.remove(e.getPlayer());
    }
}
