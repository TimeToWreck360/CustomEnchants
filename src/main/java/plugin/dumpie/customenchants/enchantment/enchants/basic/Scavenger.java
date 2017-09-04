package plugin.dumpie.customenchants.enchantment.enchants.basic;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Scavenger implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Scavenger";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "Increased xp... grinding let's go!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.HELMET};
    }

    @Override
    public Tier getTier()
    {
        return Tier.BASIC;
    }
}
