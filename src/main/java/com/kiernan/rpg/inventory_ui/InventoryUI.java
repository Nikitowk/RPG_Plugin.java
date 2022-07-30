package com.kiernan.rpg.inventory_ui;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.Collections;
import java.util.List;

public class InventoryUI implements Listener {

    private Inventory inv;

    public InventoryUI(){
        inv = Bukkit.createInventory(null, 9, "Shop");
        init();
    }

    private void init(){
        ItemStack item;
        item = createItem("§3§lEnchantments", Material.ENCHANTED_BOOK, Collections.singletonList("Enchant your gear for 35 coins!"));
        inv.setItem(3, item);

        item = createItem("§d§lArmor", Material.DIAMOND_HELMET, Collections.singletonList("Purchase new gear here for 20 coins!"));
        inv.setItem(4, item);

        item = createItem("§a§lWeapons", Material.DIAMOND_SWORD, Collections.singletonList("Purchase a new weapon here for 10 coins!"));
        inv.setItem(5, item);
    }

    private ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public Inventory getInventory() {
        return inv;
    }


}
