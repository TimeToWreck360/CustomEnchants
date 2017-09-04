package plugin.dumpie.customenchants.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.commands.sub.RandomEnchantCommand;
import plugin.dumpie.customenchants.commands.sub.XpCommand;
import plugin.dumpie.customenchants.enchantment.CustomEnchantment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager implements CommandExecutor
{
    private CommandCache cache;
    private CustomEnchants instance;
    public CommandManager(CustomEnchants instance)
    {
        this.instance = instance;

        cache = new CommandCache();
        cache.register(new RandomEnchantCommand());
        cache.register(new XpCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "The console can not use this command!");
            return true;
        }

        Player p = (Player) sender;

        if(!(cmd.getLabel().equalsIgnoreCase("ce")))
        {
            p.sendMessage(ChatColor.RED + "That command does not exist!");
            return true;
        }

        if(args.length < 1)
        {
            p.sendMessage(ChatColor.RED + "Insufficient arguments.");
            return true;
        }

        CustomCommand command = getCommand(args[0]);
        if(command == null) return true;

        if(!(p.hasPermission(command.getData().permission())))
        {
            p.sendMessage(ChatColor.RED + "Insufficient permissions.");
            return true;
        }

        List<String> a = new ArrayList<>(Arrays.asList(args));
        a.remove(0);

        args = a.toArray(new String[a.size()]);
        command.execute(sender, args);

        return true;
    }

    private CommandCache getCache()
    {
        return this.cache;
    }

    private CustomCommand getCommand(String name)
    {
        for(CustomCommand command : getCache().getCommands())
        {
            if(command.getData().command().equalsIgnoreCase(name)) return command;

            for(String alias : command.getData().aliases())
            {
                if(alias.equalsIgnoreCase(name)) return command;
            }
        }

        return null;
    }
}