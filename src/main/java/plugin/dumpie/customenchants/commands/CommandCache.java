package plugin.dumpie.customenchants.commands;

import com.avaje.ebean.LogLevel;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class CommandCache
{
    private List<CustomCommand> commands;

    public CommandCache()
    {
        this.commands = new ArrayList<>();
    }

    public List<CustomCommand> getCommands()
    {
        return this.commands;
    }

    public void register(CustomCommand command)
    {
        commands.add(command);
    }

    public void unregister(CustomCommand command)
    {
        try
        {
            commands.remove(command);
        }
        catch(Exception e)
        {
            Bukkit.getLogger().log(Level.WARNING, "Could not unregister command " + command.getData().command());
        }
    }
}
