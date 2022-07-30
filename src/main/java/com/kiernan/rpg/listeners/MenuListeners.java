package com.kiernan.rpg.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static com.kiernan.rpg.items.Items.coin;


public class MenuListeners implements Listener {

    public static void onPurchase(Player player, int amount) {
        int subtractedAmount = 0;
        for (ItemStack item : player.getInventory().getContents()) {
                if (!player.getInventory().containsAtLeast(coin, amount)) return;
                if (item.getItemMeta().getDisplayName().equals(coin.getItemMeta().getDisplayName())) {
                    if (item.getAmount() == amount) {
                        if (subtractedAmount > 0) {
                            item.setAmount(amount - subtractedAmount);
                        } else {
                            item.setAmount(0);
                        }
                        break;
                    } else if (item.getAmount() > amount) {
                        if (subtractedAmount > 0) {
                            int amountNeeded = amount - subtractedAmount;
                            item.setAmount(item.getAmount() - amountNeeded);
                            break;
                        }
                        item.setAmount(item.getAmount() - amount);
                        break;
                    } else {
                        subtractedAmount = item.getAmount();
                        item.setAmount(0);
                    }
                }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (!e.getView().getTitle().equals("Shop")) {
            return;
        }
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }

        if (e.getSlot() == 3) {
            if(player.getInventory().containsAtLeast(coin, 35)) {
                player.getInventory().getHelmet().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                player.getInventory().getChestplate().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                player.getInventory().getLeggings().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                player.getInventory().getBoots().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                onPurchase(player, 35);
                player.sendMessage("§2Thank you for purchasing. Enjoy!");
            }else player.sendMessage("§cNot enough coins. Please come back when you have enough.");
            player.closeInventory();
        }

        if (e.getSlot() == 4) {
            if(player.getInventory().containsAtLeast(coin, 20)) {
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
                onPurchase(player, 20);
                player.sendMessage("§2Thank you for purchasing. Enjoy!");
            }else player.sendMessage("§cNot enough coins. Please come back when you have enough.");
            player.closeInventory();
        }

        if (e.getSlot() == 5) {
            if (player.getInventory().containsAtLeast(coin, 10)) {
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                onPurchase(player, 10);
                player.sendMessage("§2Thank you for purchasing. Enjoy!");
            } else player.sendMessage("§cNot enough coins. Please come back when you have enough.");
            player.closeInventory();
        }
    }
}

