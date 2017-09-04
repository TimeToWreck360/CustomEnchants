package plugin.dumpie.customenchants.enchantment.enchants.abnormal;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Tank implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Tank";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "Big 'ole belly"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.CHESTPLATE};
    }

    @Override
    public Tier getTier()
    {
        return Tier.ABNORMAL;
    }
}
