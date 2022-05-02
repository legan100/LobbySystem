package de.legan100.lobbysystem.utils;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Tablist {
    private static HashMap<String, String> teams = new HashMap<>();

    public void create(String name, int rank, String prefix, String suffix, String permission) {
        String fullName = String.valueOf(rank) + "_" + name;
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Team t = board.getTeam(fullName);
        if (t != null)
            t.unregister();
        t = board.registerNewTeam(fullName);
        if (prefix != null)
            t.setPrefix(prefix);
        if (suffix != null)
            t.setSuffix(suffix);
        teams.put(permission, fullName);
    }

    public void addPlayer(Player p) {
        Team t = null;
        for (String perm : teams.keySet()) {
            if (perm == null || p.hasPermission(perm)) {
                String currentTeamName = teams.get(perm);
                if (t == null || getRank(currentTeamName) < getRank(t.getName()))
                    t = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(currentTeamName);
            }
        }
        if (t != null)
            t.addPlayer((OfflinePlayer)p);
    }

    public void update() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            removePlayer(players);
            addPlayer(players);
        }
    }

    public void removePlayer(Player p) {
        for (String teamName : teams.values()) {
            Team t = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(teamName);
            if (t != null && t.hasPlayer((OfflinePlayer)p))
                t.removePlayer((OfflinePlayer)p);
        }
    }

    public int getRank(String teamName) {
        if (!teamName.contains("_"))
            return -1;
        String[] array = teamName.split("_");
        try {
            int i = Integer.parseInt(array[0]);
            return i;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
