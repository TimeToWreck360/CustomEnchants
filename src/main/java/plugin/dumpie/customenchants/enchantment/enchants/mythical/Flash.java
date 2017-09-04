package plugin.dumpie.customenchants.enchantment.enchants.mythical;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Flash implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Flash";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "My name is Barry Allen... and I'm the fastest man alive."};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.BOOTS};
    }

    @Override
    public Tier getTier()
    {
        return Tier.MYTHICAL;
    }
}
