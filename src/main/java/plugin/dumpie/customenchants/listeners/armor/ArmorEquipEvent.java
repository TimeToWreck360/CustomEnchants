package plugin.dumpie.customenchants.listeners.armor;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorEquipEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled = false;
    private ItemStack oldArmor;
    private ItemStack newArmor;
    private Player p;

    public ArmorEquipEvent(ItemStack oldArmor, ItemStack newArmor, Player p)
    {
        super(p);
        this.oldArmor = oldArmor;
        this.newArmor = newArmor;
        this.p = p;
    }

    public ItemStack getOldArmor()
    {
        return this.oldArmor;
    }

    public ItemStack getNewArmor()
    {
        return this.newArmor;
    }

    public void setOldArmor(ItemStack armor)
    {
        this.oldArmor = armor;
    }

    public void setNewArmor(ItemStack armor)
    {
        this.newArmor = armor;
    }

    public void setPlayer(Player p)
    {
        this.p = p;
    }

    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b)
    {
        this.cancelled = b;
    }

    public final static HandlerList getHandlerList()
    {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers()
    {
        return HANDLERS;
    }
}
