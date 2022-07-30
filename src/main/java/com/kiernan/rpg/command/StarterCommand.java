package com.kiernan.rpg.command;

import com.kiernan.rpg.items.Items;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StarterCommand implements CommandExecutor {

    Map<UUID, Long> coolDown = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(!coolDown.containsKey(player.getUniqueId())){
                this.coolDown.put(player.getUniqueId(), System.currentTimeMillis() / 1000);
                player.getInventory().addItem(Items.sword);
                player.getInventory().addItem(Items.helm);
                player.getInventory().addItem(Items.chest);
                player.getInventory().addItem(Items.legs);
                player.getInventory().addItem(Items.boots);
                player.getInventory().addItem(Items.meat);
            }else{
                long timeLeft = (System.currentTimeMillis() / 1000) - coolDown.get(player.getUniqueId());
                if(timeLeft >= 10000 / 1000){
                    this.coolDown.put(player.getUniqueId(), System.currentTimeMillis() / 1000);
                    player.getInventory().addItem(Items.sword);
                    player.getInventory().addItem(Items.helm);
                    player.getInventory().addItem(Items.chest);
                    player.getInventory().addItem(Items.legs);
                    player.getInventory().addItem(Items.boots);
                    player.getInventory().addItem(Items.meat);
                }else{
                    player.sendMessage("You can't use this kit for another " + ((10000 / 1000) - timeLeft) + " seconds.");
                }
            }
        }

        return true;
    }
}
