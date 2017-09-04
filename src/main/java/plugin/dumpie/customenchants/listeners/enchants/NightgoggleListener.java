package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.listeners.armor.ArmorEquipEvent;

public class NightgoggleListener implements Listener
{
    private CustomEnchants instance;
    public NightgoggleListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onEquipArmor(ArmorEquipEvent e)
    {
        if(e.getOldArmor() == null) return;
        if(e.getNewArmor() == null) return;

        ItemStack oldArmor = e.getOldArmor();
        ItemStack newArmor = e.getNewArmor();

        CustomEnchantment nightgoggles = instance.getEnchants().getEnchantFromString("Nightgoggles");
        if(nightgoggles == null) return;

        if(Application.getType(oldArmor.getType()) != Application.HELMET && oldArmor.getType() != Material.AIR) return;
        if(Application.getType(newArmor.getType()) != Application.HELMET && newArmor.getType() != Material.AIR) return;

        if(oldArmor.getType() == Material.AIR)
        {
            if(!newArmor.hasItemMeta()) return;
            if(!newArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(newArmor, nightgoggles)) return;
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
            return;
        }

        if(newArmor.getType() == Material.AIR)
        {
            if(!oldArmor.hasItemMeta()) return;
            if(!oldArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(oldArmor, nightgoggles)) return;

            if(e.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
                e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }
}
