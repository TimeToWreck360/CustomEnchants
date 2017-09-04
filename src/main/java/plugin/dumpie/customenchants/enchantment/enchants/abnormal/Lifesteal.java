package plugin.dumpie.customenchants.enchantment.enchants.abnormal;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Lifesteal implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Lifesteal";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "mhm... Blood ;)"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.SWORD};
    }

    @Override
    public Tier getTier()
    {
        return Tier.ABNORMAL;
    }
}
