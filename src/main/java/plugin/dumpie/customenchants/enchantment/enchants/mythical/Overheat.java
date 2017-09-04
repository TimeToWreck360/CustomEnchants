package plugin.dumpie.customenchants.enchantment.enchants.mythical;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Overheat implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Overheat";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "This girl is on fire!!!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.CHESTPLATE, Application.LEGGINGS};
    }

    @Override
    public Tier getTier()
    {
        return Tier.MYTHICAL;
    }
}
