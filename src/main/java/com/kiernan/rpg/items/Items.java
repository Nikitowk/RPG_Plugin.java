package com.kiernan.rpg.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

    public static ItemStack coin;
    public static ItemStack chest;
    public static ItemStack helm;
    public static ItemStack legs;
    public static ItemStack boots;
    public static ItemStack sword;
    public static ItemStack meat;

    public static void init(){
        createCoin();
        createChest();
        createSword();
        createHelm();
        createBoots();
        createLegs();
        createMeat();
    }

    public static void createCoin(){
        ItemStack item = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Coin");
        item.setItemMeta(meta);
        coin = item;
    }

    public static void createChest(){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        chest = item;
    }

    public static void createHelm(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
        helm = item;
    }

    public static void createLegs(){
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        legs = item;
    }

    public static void createBoots(){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        boots = item;
    }

    public static void createSword(){
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        sword = item;
    }

    public static void createMeat(){
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 32);
        meat = item;
    }

    public static ItemStack getCoin(){
        return coin;
    }

}
