package de.legan100.lobbysystem.listener;

import de.legan100.lobbysystem.commands.CMD_Accept;
import de.legan100.lobbysystem.commands.CMD_Vanish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (CMD_Vanish.isVannished.contains(e.getPlayer()))
            if (!CMD_Accept.allowedChat.contains(e.getPlayer()))
                e.setCancelled(true);

    }
}
