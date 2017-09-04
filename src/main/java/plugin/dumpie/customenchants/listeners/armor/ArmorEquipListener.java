package plugin.dumpie.customenchants.listeners.armor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import plugin.dumpie.customenchants.CustomEnchants;

public class ArmorEquipListener implements Listener
{
    private CustomEnchants instance;
    public ArmorEquipListener(CustomEnchants instance)
    {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        if(e.getSlotType() != InventoryType.SlotType.ARMOR) return;
        if(e.getWhoClicked() == null) return;
        if(e.getCurrentItem() == null) return;
        if(e.getCursor() == null) return;

        ArmorEquipEvent equip = new ArmorEquipEvent(e.getCurrentItem(), e.getCursor(), (Player) e.getWhoClicked());
        Bukkit.getServer().getPluginManager().callEvent(equip);
    }
}
