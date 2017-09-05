package plugin.dumpie.customenchants.listeners.armor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.enchantment.Application;

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

    @EventHandler
    public void onPlayeInteract(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if(p == null) return;
        if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        ItemStack item = e.getItem();
        if(item == null) return;
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if (e.getClickedBlock() == null) return;
        }

        if(Application.getType(item.getType()) != Application.HELMET && Application.getType(item.getType()) != Application.CHESTPLATE &&
                Application.getType(item.getType()) != Application.LEGGINGS && Application.getType(item.getType()) != Application.BOOTS) return;

        /*
        for(String s : instance.getConfig().getStringList("restricted-right-click"))
        {
            if(e.getClickedBlock().getType().name().equalsIgnoreCase(s)) return;
        }
        */

        Application app = Application.getType(item.getType());

        if(app == Application.HELMET)
        {
            Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(new ItemStack(Material.AIR), item, p));
        }

        if(app == Application.CHESTPLATE)
        {
            Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(new ItemStack(Material.AIR), item, p));
        }

        if(app == Application.LEGGINGS)
        {
            Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(new ItemStack(Material.AIR), item, p));
        }

        if(app == Application.BOOTS)
        {
            Bukkit.getServer().getPluginManager().callEvent(new ArmorEquipEvent(new ItemStack(Material.AIR), item, p));
        }
    }
}
