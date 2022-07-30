package com.kiernan.rpg.events;

import com.kiernan.rpg.items.Items;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class Events implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("§bWelcome to the RPG server! To get started, use '/starter' for a kit to get you going on your adventure!");
        player.sendMessage("§bKilling mobs will have them drop " + "§6coins.");
        player.sendMessage("§bUse these coins in the shop by doing '/shop' and purchase the necessary upgrades to take on the world! Good luck and have fun!");
    }

    @EventHandler
    public static void onEntityDeath(EntityDeathEvent event) {
        Random rand = new Random();
        float dropChance = rand.nextFloat();
        if (event.getEntity() instanceof Mob) {
            if (dropChance <= 0.50f) {
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(Items.coin));
            }
        }
    }

}
