package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

import java.util.Arrays;

public class AutosmeltListener implements Listener
{
    private CustomEnchants instance;
    public AutosmeltListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        Block broken = e.getBlock();

        if(item == null || item.getType() == Material.AIR) return;
        if(Application.getType(item.getType()) != Application.PICKAXE) return;
        if(!item.hasItemMeta()) return;
        if(!item.getItemMeta().hasLore()) return;

        CustomEnchantment autosmelt = instance.getEnchants().getEnchantFromString("Autosmelt");
        if(autosmelt == null) return;

        if(!instance.getEnchants().hasEnchant(item, autosmelt)) return;

        if(broken.getType() != Material.COAL_ORE && broken.getType() != Material.IRON_ORE && broken.getType() != Material.GOLD_ORE &&
                broken.getType() != Material.DIAMOND_ORE && broken.getType() != Material.EMERALD_ORE &&
                broken.getType() != Material.LAPIS_ORE && broken.getType() != Material.QUARTZ &&
                broken.getType() != Material.REDSTONE_ORE && broken.getType() != Material.GLOWING_REDSTONE_ORE) return;


        if(broken.getType() == Material.COAL_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.COAL);
            return;
        }

        if(broken.getType() == Material.IRON_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.IRON_INGOT);
            return;
        }

        if(broken.getType() == Material.GOLD_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.GOLD_INGOT);
            return;
        }

        if(broken.getType() == Material.DIAMOND_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.DIAMOND);
            return;
        }

        if(broken.getType() == Material.EMERALD_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.EMERALD);
            return;
        }

        if(broken.getType() == Material.LAPIS_ORE)
        {
            replaceWithAir(broken);
            p.getInventory().addItem(new ItemStack(Material.INK_SACK, 1, (short) 4));
            return;
        }

        if(broken.getType() == Material.QUARTZ_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.QUARTZ);
            return;
        }

        if(broken.getType() == Material.REDSTONE_ORE || broken.getType() == Material.GLOWING_REDSTONE_ORE)
        {
            replaceWithAir(broken);
            giveItem(p, Material.REDSTONE);
        }

    }

    private void giveItem(Player p, Material m)
    {
        p.getInventory().addItem(new ItemStack(m));
    }

    private void replaceWithAir(Block block)
    {
        block.setType(Material.AIR);
    }
}
