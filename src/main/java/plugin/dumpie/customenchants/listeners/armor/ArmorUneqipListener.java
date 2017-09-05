package plugin.dumpie.customenchants.listeners.armor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;

public class ArmorUneqipListener implements Listener
{
    private CustomEnchants instance;
    public ArmorUneqipListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent e)
    {
        Player p = e.getPlayer();
        ItemStack item = e.getBrokenItem();
        if(p == null) return;
        if(item == null || item.getType() == Material.AIR) return;

        Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(item, new ItemStack(Material.AIR), p));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        Player p = e.getEntity();
        if(p == null) return;
        if(p.getInventory().getArmorContents() == null) return;

        for(ItemStack armor : p.getInventory().getArmorContents())
        {
            if(armor == null || armor.getType() == Material.AIR) return;
            Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(armor, new ItemStack(Material.AIR), p));
        }
    }
}
