package plugin.dumpie.customenchants.commands.sub;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.dumpie.customenchants.commands.CustomCommand;
import plugin.dumpie.customenchants.commands.SubCommand;

@SubCommand(command = "xp", permission = "ce.xp", usage = "/ce xp")
public class XpCommand extends CustomCommand
{
    @Override
    public void execute(CommandSender sender, String[] args)
    {
        Player p = (Player) sender;

        p.sendMessage(String.valueOf(p.getTotalExperience()));
    }
}
