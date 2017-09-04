package plugin.dumpie.customenchants.enchantment;

public interface CustomEnchantment
{
    String getName();

    String[] getDescription();

    Application[] getApplication();

    Tier getTier();

    String getDisplay();
}
