package de.ribex.learn.commands;

import de.ribex.learn.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player){
            Player p = (Player)sender;

            p.sendMessage(Main.getPrefix() + "§aDu hast das TestItem bekommen");
            ItemStack stack = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§cDiamant Schwert");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("    ");
            lore.add("§a>> Dieses Schwrt ist cool");
            lore.add("§a>> Wie macht man das?");
            lore.add("    ");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.KNOCKBACK, 1000 , true);
            stack.setItemMeta(meta);

            p.getInventory().addItem(stack);

        }else {
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "Du musst ein Spieler sein!");
        }


        return false;
    }
}
