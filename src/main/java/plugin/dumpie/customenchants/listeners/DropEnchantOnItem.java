package plugin.dumpie.customenchants.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

import java.util.ArrayList;
import java.util.List;

public class DropEnchantOnItem implements Listener
{
    private CustomEnchants instance;
    public DropEnchantOnItem(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();
        InventoryAction action = e.getAction();
        ItemStack cursor = e.getCursor();
        ItemStack clicked = e.getCurrentItem();

        if(cursor == null || cursor.getType() == Material.AIR) return;
        if(clicked == null || clicked.getType() == Material.AIR) return;

        if(cursor.getType() != Material.NETHER_STAR) return;
        if(!(cursor.hasItemMeta())) return;
        if(!(cursor.getItemMeta().hasDisplayName()) || !(cursor.getItemMeta().hasLore())) return;

        if(p.getGameMode() == GameMode.CREATIVE)
        {
            p.sendMessage(ChatColor.RED + "You can not use custom enchants while you are in creative mode!");
            return;
        }

        if(action != InventoryAction.SWAP_WITH_CURSOR) return;

        String enchantBookName = cursor.getItemMeta().getDisplayName();
        String enchantName = ChatColor.stripColor(enchantBookName).replace(" ENCHANTMENT SHARD", "");

        CustomEnchantment enchant = instance.getEnchants().getEnchantFromString(enchantName);

        if(enchant == null) return;

        if(!instance.getEnchants().enchantIsApplicable(clicked, enchant)) return;

        if(!clicked.hasItemMeta())
        {
            ItemMeta meta = clicked.getItemMeta();
            List<String> lore = new ArrayList<>();

            lore.add(enchant.getDisplay());
            meta.setLore(lore);
            clicked.setItemMeta(meta);
            cursor.setAmount(cursor.getAmount() - 1);
            e.setCancelled(true);
            return;
        }

        if(!clicked.getItemMeta().hasLore())
        {
            ItemMeta meta = clicked.getItemMeta();
            List<String> lore = new ArrayList<>();

            lore.add(enchant.getDisplay());
            meta.setLore(lore);
            clicked.setItemMeta(meta);
            cursor.setAmount(cursor.getAmount() - 1);
            e.setCancelled(true);
            return;
        }

        if(clicked.getItemMeta().getLore().contains(enchant.getDisplay())) return;

        ItemMeta meta = clicked.getItemMeta();
        List<String> lore = meta.getLore();
        lore.add(enchant.getDisplay());
        meta.setLore(lore);
        clicked.setItemMeta(meta);
        cursor.setAmount(cursor.getAmount() - 1);
        e.setCancelled(true);
    }
}
