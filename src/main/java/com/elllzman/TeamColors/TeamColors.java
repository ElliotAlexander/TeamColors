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

    ScoreboardManager manager;
    Scoreboard board;
    public void onEnable()
    {
        getServer().getLogger().info("Team colors started.");
        manager = getServer().getScoreboardManager();
        board = getServer().getScoreboardManager().getMainScoreboard();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Team t = board.getTeam(args[0]);
        String prefix = t.getPrefix();

        if(t==null){ return false; }
        if(ChatColor.valueOf(cmd.getName().toUpperCase())!=null)
        {
            t.setPrefix(t.getPrefix() + ChatColor.valueOf(cmd.getName().toUpperCase()));
            sender.sendMessage(ChatColor.RED + "Team color of team " + t.getName() + " has been changed to " + cmd.getName());
        }
        return true;
    }
}
