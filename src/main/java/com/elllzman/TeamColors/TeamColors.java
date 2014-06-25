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

        if(nullCheck(t)==false){ return false; }

        if(cmd.getName().equalsIgnoreCase("Bold"))
        {
                t.setPrefix(prefix + ChatColor.BOLD.toString() + "");
                sender.sendMessage(ChatColor.GREEN + "Team color changed to bold!");
                return true;
        }

        if(cmd.getName().equalsIgnoreCase("italic"))
        {
            t.setPrefix(prefix + ChatColor.ITALIC.toString() + "");
            sender.sendMessage(ChatColor.GREEN + "Team color changed to italic!");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("underline"))
        {
            t.setPrefix(prefix + ChatColor.UNDERLINE.toString() + "" );
            sender.sendMessage(ChatColor.GREEN + "Team color changed to underline!");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("strikethrough"))
        {
            t.setPrefix(prefix + ChatColor.STRIKETHROUGH.toString() + "");
            sender.sendMessage(ChatColor.GREEN + "Team color changed to strikethrough!");
            return true;
        }
        return true;
    }

    private boolean nullCheck(Object o)
    {
        if(o==null)
        {
            return false;
        }
        return true;
    }



}
