package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

public class LifestealListener implements Listener
{
    private CustomEnchants instance;
    public LifestealListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e)
    {
        Player p = e.getEntity();
        Player killer = p.getKiller();

        if(killer == null) return;

        ItemStack weapon = killer.getInventory().getItemInMainHand();
        CustomEnchantment lifesteal = instance.getEnchants().getEnchantFromString("Lifesteal");

        if(weapon == null || weapon.getType() == Material.AIR) return;
        if(Application.getType(weapon.getType()) != Application.SWORD) return;
        if(!weapon.hasItemMeta()) return;
        if(!weapon.getItemMeta().hasLore()) return;
        if(!instance.getEnchants().hasEnchant(weapon, lifesteal)) return;
        if(killer.getHealth() == killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) return;

        double chance = Math.random();
        if(chance <= 0.5)
            killer.setHealth(killer.getHealth() + 4);
    }
}
