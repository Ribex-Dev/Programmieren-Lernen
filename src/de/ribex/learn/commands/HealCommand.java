package de.ribex.learn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender.hasPermission("heal.own")){
            if (sender instanceof Player){
                Player p = (Player)sender;

                p.setFoodLevel(40);
                p.setHealth(20);
                p.sendMessage("§aDu wurdest geheilt und gefüttert!");

            }else{
                sender.sendMessage("§cDu muss ein Spieler sein!");
            }
        }else{
            sender.sendMessage("§cDu hat keine Berechtigung!");
        }



        return false;
    }
}
