package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

import java.util.Random;

public class DodgeListener implements Listener
{
    private CustomEnchants instance;
    public DodgeListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e)
    {
        if(!(e.getEntity() instanceof Player)) return;
        if(!(e.getDamager() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        Entity damager = e.getDamager();

        if(p == null) return;
        if(damager == null) return;
        if(p.getInventory().getArmorContents() == null) return;
        if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getType() == Material.AIR) return;
        if(Application.getType(p.getInventory().getBoots().getType()) != Application.BOOTS) return;
        if(!(p.getInventory().getBoots().hasItemMeta())) return;
        if(!p.getInventory().getBoots().getItemMeta().hasLore()) return;

        CustomEnchantment dodge = instance.getEnchants().getEnchantFromString("Dodge");
        if(dodge == null) return;
        if(!instance.getEnchants().hasEnchant(p.getInventory().getBoots(), dodge)) return;

        Random r = new Random();
        int chance = r.nextInt(100);

        if(chance <= 0.20)
        {
            p.sendMessage(ChatColor.GREEN + "You dodged the incoming attack!");
            e.setCancelled(true);
        }
    }
}
