package plugin.dumpie.customenchants.enchantment;

import org.bukkit.Material;

import java.lang.reflect.Type;
import java.util.ArrayList;

public enum Application
{
    HOE(new Material[]{Material.DIAMOND_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.STONE_HOE, Material.WOOD_HOE}),
    SHOVEL(new Material[]{Material.DIAMOND_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.STONE_SPADE, Material.WOOD_SPADE}),
    PICKAXE(new Material[]{Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.STONE_PICKAXE, Material.WOOD_PICKAXE}),
    AXE(new Material[]{Material.DIAMOND_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.STONE_AXE, Material.WOOD_AXE}),
    SWORD(new Material[]{Material.DIAMOND_SWORD, Material.IRON_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.STONE_SWORD, Material.WOOD_SWORD}),
    BOW(new Material[]{Material.BOW}),
    HELMET(new Material[]{Material.DIAMOND_HELMET, Material.IRON_HELMET, Material.GOLD_HELMET, Material.CHAINMAIL_HELMET, Material.LEATHER_HELMET}),
    CHESTPLATE(new Material[]{Material.DIAMOND_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.LEATHER_CHESTPLATE}),
    LEGGINGS(new Material[]{Material.DIAMOND_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.LEATHER_LEGGINGS}),
    BOOTS(new Material[]{Material.DIAMOND_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.LEATHER_BOOTS});

    private Material[] materials;

    Application(Material[] materials)
    {
        this.materials = materials;
    }

    public Material[] getMaterials()
    {
        return this.materials;
    }

    public static Application getType(Material material)
    {
        for(Application type : Application.values())
        {
            for(Material submat : type.getMaterials())
            {
                if(submat == material) return type;
            }
        }

        return null;
    }
}
