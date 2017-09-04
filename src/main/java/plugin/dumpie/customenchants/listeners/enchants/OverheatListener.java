package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

public class OverheatListener implements Listener
{
    private CustomEnchants instance;
    public OverheatListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e)
    {
        if(!(e.getEntity() instanceof Player)) return;
        if(!(e.getDamager() instanceof Player)) return;

        Player p = (Player) e.getEntity();
        Player damager = (Player) e.getDamager();
        ItemStack chestplate = p.getInventory().getChestplate();

        if(p.getInventory().getArmorContents() == null) return;
        if(p.getInventory().getChestplate() == null || p.getInventory().getChestplate().getType() == Material.AIR) return;
        if(Application.getType(chestplate.getType()) != Application.CHESTPLATE) return;
        if(!chestplate.hasItemMeta()) return;
        if(!chestplate.getItemMeta().hasLore()) return;

        CustomEnchantment overheat = instance.getEnchants().getEnchantFromString("Overheat");
        if(overheat == null) return;
        if(!instance.getEnchants().hasEnchant(chestplate, overheat)) return;

        double chance = Math.random();
        if(chance <= 0.25)
            damager.setFireTicks(20 * 5);
    }
}
