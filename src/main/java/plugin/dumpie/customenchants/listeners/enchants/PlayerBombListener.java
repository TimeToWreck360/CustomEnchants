package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

public class PlayerBombListener implements Listener
{
    private CustomEnchants instance;
    public PlayerBombListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        Player p = e.getEntity();
        Location loc = p.getLocation();

        if(p.getInventory().getArmorContents() == null) return;
        if(p.getInventory().getChestplate() == null) return;

        ItemStack chestplate = p.getInventory().getChestplate();
        if(Application.getType(chestplate.getType()) != Application.CHESTPLATE) return;
        if(!chestplate.hasItemMeta()) return;
        if(!chestplate.getItemMeta().hasLore()) return;

        CustomEnchantment bomb = instance.getEnchants().getEnchantFromString("Bomb");
        if(bomb == null) return;
        if(!instance.getEnchants().hasEnchant(chestplate, bomb)) return;
        loc.getWorld().createExplosion(loc, 5F);
    }
}
