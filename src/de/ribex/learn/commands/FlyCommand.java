package de.ribex.learn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if (sender.hasPermission("fly.own")){

            if (sender instanceof Player){

                Player p = (Player)sender;
                if (!p.getAllowFlight()){

                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage("§aDu kannst nun fliegen");

                }else {

                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage("§cDu kannst jezt nicht mehr fliegen");

                }

            }else {
                sender.sendMessage("§cDu musst ein Spieler sein!");
            }

        }else{
            sender.sendMessage("§cKeine Permission!");
        }

        return false;
    }
}
