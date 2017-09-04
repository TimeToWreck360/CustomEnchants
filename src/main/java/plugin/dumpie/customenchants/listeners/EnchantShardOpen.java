package plugin.dumpie.customenchants.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.EnchantManager;

import java.util.Random;

public class EnchantShardOpen implements Listener
{
    private CustomEnchants instance;
    public EnchantShardOpen(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        if(item == null || item.getType() == Material.AIR) return;

        if(item.getType() != Material.PRISMARINE_SHARD) return;

        if(!(item.hasItemMeta())) return;

        if(!(item.getItemMeta().hasDisplayName()) || !(item.getItemMeta().hasLore())) return;

        if(instance.getEnchants().getEnchantCache().isEmpty()) return;
        if(instance.getEnchants().getBasicEnchants().isEmpty()) return;
        if(instance.getEnchants().getAbnormalEnchants().isEmpty()) return;
        if(instance.getEnchants().getMythicalEnchants().isEmpty()) return;

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            Random r = new Random();

            if(item.getItemMeta().getDisplayName().contains("BASIC ENCHANTMENT SHARD"))
            {
                int i = r.nextInt(instance.getEnchants().getBasicEnchants().size());
                CustomEnchantment enchantment = instance.getEnchants().getBasicEnchants().get(i);

                p.getInventory().addItem(EnchantManager.createEnchantCrystal(enchantment));
                p.sendMessage(ChatColor.GRAY + "You just got a(n) " + enchantment.getDisplay() + ChatColor.GRAY + " enchant crystal from the enchantment shard!");
                item.setAmount(item.getAmount() - 1);
                return;
            }

            if(item.getItemMeta().getDisplayName().contains("ABNORMAL ENCHANTMENT SHARD"))
            {
                int i = r.nextInt(instance.getEnchants().getAbnormalEnchants().size());
                CustomEnchantment enchantment = instance.getEnchants().getAbnormalEnchants().get(i);

                p.getInventory().addItem(EnchantManager.createEnchantCrystal(enchantment));
                p.sendMessage(ChatColor.GRAY + "You just got a(n) " + enchantment.getDisplay() + ChatColor.GRAY + " enchant crystal from the enchantment shard!");
                item.setAmount(item.getAmount() - 1);
                return;
            }

            if(item.getItemMeta().getDisplayName().contains("MYTHICAL ENCHANTMENT SHARD"))
            {
                int i = r.nextInt(instance.getEnchants().getMythicalEnchants().size());
                CustomEnchantment enchantment = instance.getEnchants().getMythicalEnchants().get(i);

                p.getInventory().addItem(EnchantManager.createEnchantCrystal(enchantment));
                p.sendMessage(ChatColor.GRAY + "You just got a(n) " + enchantment.getDisplay() + ChatColor.GRAY + " enchant crystal from the enchantment shard!");
                item.setAmount(item.getAmount() - 1);
            }
        }
    }
}
