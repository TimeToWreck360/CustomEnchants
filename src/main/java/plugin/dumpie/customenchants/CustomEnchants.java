package plugin.dumpie.customenchants;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.dumpie.customenchants.commands.CommandManager;
import plugin.dumpie.customenchants.enchantment.EnchantManager;
import plugin.dumpie.customenchants.enchantment.enchants.abnormal.Berserker;
import plugin.dumpie.customenchants.enchantment.enchants.abnormal.Dodge;
import plugin.dumpie.customenchants.enchantment.enchants.abnormal.Lifesteal;
import plugin.dumpie.customenchants.enchantment.enchants.basic.*;
import plugin.dumpie.customenchants.enchantment.enchants.mythical.Flash;
import plugin.dumpie.customenchants.enchantment.enchants.mythical.Overheat;
import plugin.dumpie.customenchants.enchantment.enchants.mythical.Tank;
import plugin.dumpie.customenchants.handlers.InvulnerabilityHandler;
import plugin.dumpie.customenchants.listeners.DropEnchantOnItem;
import plugin.dumpie.customenchants.listeners.EnchantShardOpen;
import plugin.dumpie.customenchants.listeners.armor.ArmorEquipListener;
import plugin.dumpie.customenchants.listeners.armor.ArmorUneqipListener;
import plugin.dumpie.customenchants.listeners.enchants.*;

public class CustomEnchants extends JavaPlugin
{
    private EnchantManager enchantManager;
    private CommandManager commandManager;
    private InvulnerabilityHandler invulnerabilityHandler;

    @Override
    public void onEnable()
    {
        getConfig().options().copyDefaults(true);
        saveConfig();

        enchantManager = new EnchantManager(this);
        commandManager = new CommandManager(this);
        invulnerabilityHandler = new InvulnerabilityHandler();

        registerEvents(this, new EnchantShardOpen(this), new DropEnchantOnItem(this), new ArmorEquipListener(this), new ArmorUneqipListener(this));
        registerEnchantEffects(this, new AutosmeltListener(this), new PlayerBombListener(this),
                new LifestealListener(this), new ScavengerListener(this), new NightgoggleListener(this), new TankListener(this),
                new FlashListener(this), new BerserkerListener(this), new FireshieldListener(this),
                new DodgeListener(this), new OverheatListener(this));
        registerEnchants();

        getCommand("ce").setExecutor(commandManager);
    }

    @Override
    public void onDisable()
    {}

    private void registerEvents(Plugin plugin, Listener... listeners)
    {
        for(Listener listener : listeners)
        {
            getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    private void registerEnchantEffects(Plugin plugin, Listener... listeners)
    {
        for(Listener listener : listeners)
        {
            getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    private void registerEnchants()
    {
        getEnchants().registerEnchants(
                new Berserker(),
                new Dodge(),
                new Lifesteal(),
                new Tank(),
                new Autosmelt(),
                new Bomb(),
                new Fireshield(),
                new Nightgoggles(),
                new Scavenger(),
                new Flash(),
                new Overheat()
        );
    }

    public EnchantManager getEnchants()
    {
        return this.enchantManager;
    }

    public CommandManager getCommandManager()
    {
        return commandManager;
    }

    public InvulnerabilityHandler getInvulnerabilityHandler()
    {
        return invulnerabilityHandler;
    }
}
