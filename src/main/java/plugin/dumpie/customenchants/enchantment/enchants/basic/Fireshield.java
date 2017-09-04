package plugin.dumpie.customenchants.enchantment.enchants.basic;

import plugin.dumpie.customenchants.enchantment.Application;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;
import plugin.dumpie.customenchants.enchantment.Tier;

public class Fireshield implements CustomEnchantment
{
    @Override
    public String getName()
    {
        return "Fireshield";
    }

    @Override
    public String getDisplay()
    {
        return getTier().getColor() + getName();
    }

    @Override
    public String[] getDescription()
    {
        return new String[]{"Burning Man, YEAH!"};
    }

    @Override
    public Application[] getApplication()
    {
        return new Application[]{Application.CHESTPLATE, Application.LEGGINGS};
    }

    @Override
    public Tier getTier()
    {
        return Tier.BASIC;
    }
}
