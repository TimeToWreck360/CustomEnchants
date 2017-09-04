package plugin.dumpie.customenchants.enchantment.enchants.abnormal;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Dodge implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Dodge";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "Be the leaf!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.BOOTS};
    }

    @Override
    public Tier getTier()
    {
        return Tier.BASIC;
    }
}
