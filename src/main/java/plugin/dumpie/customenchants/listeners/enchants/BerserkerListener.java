package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

public class BerserkerListener implements Listener
{
    private CustomEnchants instance;
    public BerserkerListener(CustomEnchants instance)
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
        CustomEnchantment berserker = instance.getEnchants().getEnchantFromString("Berserker");

        if(weapon == null || weapon.getType() == Material.AIR) return;
        if(Application.getType(weapon.getType()) != Application.SWORD) return;
        if(!weapon.hasItemMeta()) return;
        if(!weapon.getItemMeta().hasLore()) return;
        if(!instance.getEnchants().hasEnchant(weapon, berserker)) return;

        killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 3, 1));
    }
}
