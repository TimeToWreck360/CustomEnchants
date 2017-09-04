package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

public class ScavengerListener implements Listener
{
    private CustomEnchants instance;
    public ScavengerListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerKillMob(EntityDeathEvent e)
    {
        LivingEntity entity = e.getEntity();
        Player p = entity.getKiller();

        if(!(entity instanceof Creature)) return;
        if(entity instanceof Player) return;
        if(p == null) return;
        if(p.getInventory().getArmorContents() == null) return;
        if(p.getInventory().getHelmet() == null || p.getInventory().getHelmet().getType() == Material.AIR) return;

        ItemStack helmet = p.getInventory().getHelmet();

        if(Application.getType(helmet.getType()) != Application.HELMET) return;
        if(!helmet.hasItemMeta()) return;
        if(!helmet.getItemMeta().hasLore()) return;

        CustomEnchantment scavenger = instance.getEnchants().getEnchantFromString("Scavenger");
        if(scavenger == null) return;
        if(!instance.getEnchants().hasEnchant(helmet, scavenger)) return;
        e.setDroppedExp(e.getDroppedExp() * 2);
    }
}
