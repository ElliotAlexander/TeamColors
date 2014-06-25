package com.elllzman.TeamColors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

/**
 * Created by Elliot on 25/06/2014.
 */
public class TeamColors extends JavaPlugin {

    ScoreboardManager manager = getServer().getScoreboardManager();
    Scoreboard board = manager.getMainScoreboard();

    public void onEnable() {
        getServer().getLogger().info("Team colors started.");
    }

    private boolean setTeamFormat(ChatColor format, String teamName, sender) {
        Team t = board.getTeam(teamName);

        if (t == null) {
            sender.sendMessage(ChatColor.RED + "That team does not exist!");
            return true;
        } else {
            String prefix = t.getPrefix();
            t.setPrefix(prefix + format.toString());
            sender.sendMessage(ChatColor.GREEN + "Team color changed to " + color.name().toLowerCase() + "!");
            return true;
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        ChatColor color = ChatColor.valueOf(cmd.getName());
        
        if (color != null && color.isFormat()) {
            return this.setTeamFormat(color, args[0], sender);
        } else {
            return false;
        }
    }
}
