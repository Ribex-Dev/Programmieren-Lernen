package de.ribex.learn.commands;

import de.ribex.learn.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AdminItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){              //Üerprüfen ob der Commandsender ein Spieler ist
            Player player = (Player) sender;        //Den Spieler on player schreiben
            Inventory inventory = Bukkit.createInventory(null , 9*1 , "§cAdminItems");
            ItemStack stack = new ItemStack(Material.DIAMOND_SWORD , 1);

            ArrayList<String> lore = new ArrayList<>();
                lore.add("   ");
                lore.add(ChatColor.GREEN + ">> Dieses Schwert tötet jeden und alles mit einem Hit");
                lore.add("   ");

            ItemMeta meta = stack.getItemMeta();
                    meta.setDisplayName(ChatColor.RED + "One Hit Sword");
                    meta.setLore(lore);
                    meta.spigot().setUnbreakable(true);
                    meta.addEnchant(Enchantment.DAMAGE_ALL , 10000 , true);
                    meta.addEnchant(Enchantment.FIRE_ASPECT , 10000 , true);
                    meta.addEnchant(Enchantment.THORNS , 10000 , true);
                    meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10 , true);
            stack.setItemMeta(meta);

            inventory.setItem(2, stack);
            player.openInventory(inventory);
            player.sendMessage(Main.getPrefix() + ChatColor.GREEN + "Du hast das AdminItems Menue geöffnet");
        }else {
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "Du musst ein Spieler sein!");
        }
        return false;
    }
}
