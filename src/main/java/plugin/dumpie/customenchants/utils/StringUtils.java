package plugin.dumpie.customenchants.utils;

public class StringUtils
{
    public static String capitalizeFirstLetter(String input)
    {
        input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();

        return input;
    }
}
