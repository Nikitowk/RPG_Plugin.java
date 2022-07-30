package com.kiernan.rpg;

import com.kiernan.rpg.command.Commands;
import com.kiernan.rpg.command.StarterCommand;
import com.kiernan.rpg.events.Events;
import com.kiernan.rpg.listeners.MenuListeners;
import com.kiernan.rpg.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Commands commands = new Commands();
        getCommand("starter").setExecutor(commands);
        getCommand("shop").setExecutor(commands);
        getCommand("starter").setExecutor(new StarterCommand());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "RPG is Enabled.");
        Items.init();
        getServer().getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListeners(), this);
    }

    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "RPG is Disabled.");
    }

}
