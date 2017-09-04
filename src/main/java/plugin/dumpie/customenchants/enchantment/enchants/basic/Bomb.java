package plugin.dumpie.customenchants.enchantment.enchants.basic;

import org.bukkit.ChatColor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Bomb implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Bomb";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "Tick, tock, tick, tock... don't let the bomb go off!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.CHESTPLATE};
    }

    @Override
    public Tier getTier()
    {
        return Tier.BASIC;
    }
}
