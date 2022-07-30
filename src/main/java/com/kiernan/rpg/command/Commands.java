package com.kiernan.rpg.command;


import com.kiernan.rpg.inventory_ui.InventoryUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can use these commands!");
            return true;
        }

        Player player = (Player) commandSender;

        if(command.getName().equalsIgnoreCase("shop")){
            InventoryUI gui = new InventoryUI();
            player.openInventory(gui.getInventory());
        }

        return true;
    }
}
