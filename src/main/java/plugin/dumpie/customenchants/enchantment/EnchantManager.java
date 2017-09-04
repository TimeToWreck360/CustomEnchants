package plugin.dumpie.customenchants.enchantment;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.dumpie.customenchants.CustomEnchants;
import plugin.dumpie.customenchants.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnchantManager
{
    private List<CustomEnchantment> allEnchants;
    private List<CustomEnchantment> basicEnchants;
    private List<CustomEnchantment> abnormalEnchants;
    private List<CustomEnchantment> mythicalEnchants;
    private CustomEnchants instance;

    public EnchantManager(CustomEnchants instance)
    {
        this.allEnchants = new ArrayList<>();
        this.basicEnchants = new ArrayList<>();
        this.abnormalEnchants = new ArrayList<>();
        this.mythicalEnchants = new ArrayList<>();
        this.instance = instance;
    }

    public List<CustomEnchantment> getEnchantCache()
    {
        return this.allEnchants;
    }

    public List<CustomEnchantment> getBasicEnchants() { return this.basicEnchants; }

    public List<CustomEnchantment> getAbnormalEnchants()
    {
        return this.abnormalEnchants;
    }

    public List<CustomEnchantment> getMythicalEnchants()
    {
        return this.mythicalEnchants;
    }

    private CustomEnchants getInstance()
    {
        return this.instance;
    }

    private boolean isEnabled(CustomEnchantment enchantment)
    {
        return getInstance().getConfig().getBoolean(enchantment.getName() + ".enabled");
    }

    public void registerEnchants(CustomEnchantment... enchants)
    {
        for(CustomEnchantment enchant : enchants)
        {
            getEnchantCache().add(enchant);

            if(enchant.getTier() == Tier.BASIC)
            {
                getBasicEnchants().add(enchant);
            }

            if(enchant.getTier() == Tier.ABNORMAL)
            {
                getAbnormalEnchants().add(enchant);
            }

            if(enchant.getTier() == Tier.MYTHICAL)
            {
                getMythicalEnchants().add(enchant);
            }
        }
    }

    public boolean hasEnchant(ItemStack item, CustomEnchantment enchant)
    {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();

        for(String enchantNames : lore)
        {
            if(enchantNames.contains(enchant.getDisplay()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean canBeEnchanted(ItemStack item)
    {
        for(String itemName : instance.getConfig().getStringList("restricted_items"))
        {
            if(item.getType() == Material.getMaterial(itemName)) return false;
        }

        return true;
    }

    public boolean enchantIsApplicable(ItemStack item, CustomEnchantment enchant)
    {
        for(Application application : enchant.getApplication())
        {
            for(Material material : application.getMaterials())
            {
                if(material == item.getType()) return true;
            }
        }

        return false;
    }

    public CustomEnchantment getEnchantFromString(String input)
    {
        for(CustomEnchantment enchant : allEnchants)
        {
            if(enchant.getName().equalsIgnoreCase(input)) return enchant;
        }

        return null;
    }

    public static ItemStack createEnchantShard(Tier tier)
    {
        ItemStack shard = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = shard.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.setDisplayName(tier.getColor().toString() + ChatColor.UNDERLINE.toString() + ChatColor.BOLD + tier.name() + " ENCHANTMENT SHARD");
        lore.add(ChatColor.GRAY + "Right click to get a random " + StringUtils.capitalizeFirstLetter(tier.name()) + " enchantment crystal!");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shard.setItemMeta(meta);

        return shard;
    }

    public static ItemStack createEnchantCrystal(CustomEnchantment enchantment)
    {
        ItemStack crystal = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = crystal.getItemMeta();

        meta.setDisplayName(enchantment.getTier().getColor().toString() + ChatColor.UNDERLINE.toString() + ChatColor.BOLD + enchantment.getName());
        meta.setLore(Arrays.asList(enchantment.getDescription()));

        crystal.setItemMeta(meta);

        return crystal;
    }
}
