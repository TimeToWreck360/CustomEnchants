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

public class FireshieldListener implements Listener
{
    private CustomEnchants instance;
    public FireshieldListener(CustomEnchants instance)
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

        CustomEnchantment fireshield = instance.getEnchants().getEnchantFromString("Fireshield");
        if(fireshield == null) return;

        if(Application.getType(oldArmor.getType()) != Application.BOOTS && oldArmor.getType() != Material.AIR) return;
        if(Application.getType(newArmor.getType()) != Application.BOOTS && newArmor.getType() != Material.AIR) return;

        if(oldArmor.getType() == Material.AIR)
        {
            if(!newArmor.hasItemMeta()) return;
            if(!newArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(newArmor, fireshield)) return;
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
            return;
        }

        if(newArmor.getType() == Material.AIR)
        {
            if(!oldArmor.hasItemMeta()) return;
            if(!oldArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(oldArmor, fireshield)) return;

            if(e.getPlayer().hasPotionEffect(PotionEffectType.FIRE_RESISTANCE))
                e.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        }
    }
}
