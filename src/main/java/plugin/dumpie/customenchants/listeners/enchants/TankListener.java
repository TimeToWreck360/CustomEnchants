package plugin.dumpie.customenchants.listeners.enchants;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.listeners.armor.ArmorEquipEvent;

public class TankListener implements Listener
{
    private CustomEnchants instance;
    public TankListener(CustomEnchants instance)
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

        CustomEnchantment tank = instance.getEnchants().getEnchantFromString("Tank");
        if(tank == null) return;

        if(Application.getType(oldArmor.getType()) != Application.CHESTPLATE && oldArmor.getType() != Material.AIR) return;
        if(Application.getType(newArmor.getType()) != Application.CHESTPLATE && newArmor.getType() != Material.AIR) return;

        if(oldArmor.getType() == Material.AIR)
        {
            if(!newArmor.hasItemMeta()) return;
            if(!newArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(newArmor, tank)) return;
            e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(26);
            return;
        }

        if(newArmor.getType() == Material.AIR)
        {
            if(!oldArmor.hasItemMeta()) return;
            if(!oldArmor.getItemMeta().hasLore()) return;
            if(!instance.getEnchants().hasEnchant(oldArmor, tank)) return;

            if(e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() == 26)
                e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        }
    }
}