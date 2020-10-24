package de.ribex.learn.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEvents implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        e.getPlayer().sendMessage("Block Platziert");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (e.getPlayer().isOp()){
            e.setCancelled(false);
        }else{
            e.getPlayer().sendMessage("§c Du darfst nicht abbauen!");
            e.setCancelled(true);
        }
    }

}