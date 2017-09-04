package plugin.dumpie.customenchants.enchantment.enchants.basic;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Autosmelt implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Autosmelt";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "No need for a furnace, autosmelt is here!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.PICKAXE};
    }

    @Override
    public Tier getTier()
    {
        return Tier.BASIC;
    }
}
