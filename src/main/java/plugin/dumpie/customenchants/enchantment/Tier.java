package plugin.dumpie.customenchants.enchantment;

import org.bukkit.ChatColor;

public enum Tier
{
    BASIC(ChatColor.WHITE),
    ABNORMAL(ChatColor.GREEN),
    MYTHICAL(ChatColor.RED);

    private ChatColor color;

    Tier(ChatColor color)
    {
        this.color = color;
    }

    public ChatColor getColor()
    {
        return this.color;
    }

    public static Tier getTierFromString(String input)
    {
        for(Tier tier : Tier.values())
        {
            if(tier.name().equalsIgnoreCase(input)) return tier;
        }

        return null;
    }
}
