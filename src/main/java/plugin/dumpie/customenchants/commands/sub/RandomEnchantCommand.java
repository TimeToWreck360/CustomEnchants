package plugin.dumpie.customenchants.commands.sub;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.dumpie.customenchants.commands.CustomCommand;
import plugin.dumpie.customenchants.commands.SubCommand;
import plugin.dumpie.customenchants.enchantment.EnchantManager;
import plugin.dumpie.customenchants.enchantment.Tier;

@SubCommand(command = "random", permission = "random.use", usage = "/ce randombook <tier>")
public class RandomEnchantCommand extends CustomCommand
{
    @Override
    public void execute(CommandSender sender, String[] args)
    {
        Player p = (Player) sender;

        if(args.length == 0)
        {
            p.sendMessage(ChatColor.RED + "Please specify an enchant tier.");
            return;
        }

        if(args.length > 1)
        {
            p.sendMessage(ChatColor.RED + "Invalid number of arguments.");
            return;
        }

        Tier tier = Tier.getTierFromString(args[0]);

        if(tier == null)
        {
            p.sendMessage(ChatColor.RED + "Invalid enchant tier.");
            return;
        }

        p.getInventory().addItem(EnchantManager.createEnchantShard(tier));
    }
}
