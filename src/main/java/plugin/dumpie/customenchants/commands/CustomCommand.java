package plugin.dumpie.customenchants.commands;

import org.bukkit.command.CommandSender;

public abstract class CustomCommand
{
    private SubCommand data;

    public CustomCommand()
    {
        this.data = this.getClass().getAnnotation(SubCommand.class);
    }

    public abstract void execute(CommandSender sender, String[] args);

    public SubCommand getData()
    {
        return data;
    }
}
