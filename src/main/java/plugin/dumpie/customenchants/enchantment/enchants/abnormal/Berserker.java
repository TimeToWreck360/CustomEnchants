package plugin.dumpie.customenchants.enchantment.enchants.abnormal;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Berserker implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Berserker";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }


    @Override
    public String[] getDescription()
    {
        return new String[]{ChatColor.GRAY + "Lovin' the strength!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.SWORD, Application.AXE};
    }

    @Override
    public Tier getTier()
    {
        return Tier.ABNORMAL;
    }
}
