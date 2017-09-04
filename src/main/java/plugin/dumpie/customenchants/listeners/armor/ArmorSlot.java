package plugin.dumpie.customenchants.listeners.armor;

import org.bukkit.inventory.ItemStack;

public enum ArmorSlot
{
    HELMET(0), CHESTPLATE(1), LEGGINGS(2), BOOTS(3);

    private int slot;

    ArmorSlot(int slot)
    {
        this.slot = slot;
    }

    public int getSlot()
    {
        return this.slot;
    }

    public static ArmorSlot getSlotFromItem(final ItemStack item)
    {
        if(item == null) return null;
        switch(item.getType())
        {
            case DIAMOND_HELMET:
            case GOLD_HELMET:
            case IRON_HELMET:
            case CHAINMAIL_HELMET:
            case LEATHER_HELMET:
                return HELMET;
            case DIAMOND_CHESTPLATE:
            case GOLD_CHESTPLATE:
            case IRON_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case LEATHER_CHESTPLATE:
                return CHESTPLATE;
            case DIAMOND_LEGGINGS:
            case GOLD_LEGGINGS:
            case IRON_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case LEATHER_LEGGINGS:
                return LEGGINGS;
            case DIAMOND_BOOTS:
            case GOLD_BOOTS:
            case IRON_BOOTS:
            case CHAINMAIL_BOOTS:
            case LEATHER_BOOTS:
                return BOOTS;
            default:
                return null;
        }
    }

    private static ArmorSlot matchSlot(int i)
    {
        for(ArmorSlot slot : ArmorSlot.values())
        {
            if(slot.getSlot()  == i) return slot;
        }

        return null;
    }
}
