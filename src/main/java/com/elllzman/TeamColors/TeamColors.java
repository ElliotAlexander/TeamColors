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

    public void onEnable()
    {
        getServer().getLogger().info("Team colors started.");

    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("Bold"))
        {
            Team t = board.getTeam(args[0]);
            if(t==null)
            {
                sender.sendMessage(ChatColor.RED + "That team does not exist!");
                return true;
            }
            String prefix = t.getPrefix();
            t.setPrefix(prefix + ChatColor.BOLD.toString() + "");
            sender.sendMessage(ChatColor.GREEN + "Team color changed to bold!");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("italic"))
        {
            Team t = board.getTeam(args[0]);
            if(t==null)
            {
                sender.sendMessage(ChatColor.RED + "That team does not exist!");
                return true;
            }
            String prefix = t.getPrefix();
            t.setPrefix(prefix + ChatColor.ITALIC.toString() + "");
            sender.sendMessage(ChatColor.GREEN + "Team color changed to italic!");
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("underline"))
        {
            Team t = board.getTeam(args[0]);
            if(t==null)
            {
                sender.sendMessage(ChatColor.RED + "That team does not exist!");
                return true;
            }
            String prefix = t.getPrefix();
            t.setPrefix(prefix + ChatColor.UNDERLINE.toString() + "" );
            sender.sendMessage(ChatColor.GREEN + "Team color changed to underline!");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("strikethrough"))
        {
            Team t = board.getTeam(args[0]);
            if(t==null)
            {
                sender.sendMessage(ChatColor.RED + "That team does not exist!");
                return true;
            }
            String prefix = t.getPrefix();
            t.setPrefix(prefix + ChatColor.STRIKETHROUGH.toString() + "");
            sender.sendMessage(ChatColor.GREEN + "Team color changed to strikethrough!");
            return true;
        }
        return true;

    }
}
