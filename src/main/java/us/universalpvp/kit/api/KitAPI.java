package us.universalpvp.kit.api;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import us.universalpvp.kit.KitMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avigh on 7/24/2016.
 */
public final class KitAPI {
    private static KitAPI api;

    public static KitAPI getAPI() {
        return api;
    }

    public static void initialise(JavaPlugin plugin) {
        if (api != null) {
            throw new IllegalStateException();
        }
        api = new KitAPI(plugin);
    }

    private final JavaPlugin plugin;

    private List<Kit> registeredKits = new ArrayList<>();

    private KitAPI(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadKits() {
        ConfigurationSection cs = plugin.getConfig().getConfigurationSection("kits");
        for (String cKey : cs.getKeys(false)) {
            int attack = cs.getInt(cKey + ".attack", 0),
                    defence = cs.getInt(cKey + ".defence", 0);
            double health = cs.getDouble(cKey + ".health");
            ItemStack itemStack = new ItemStack(Material.getMaterial(cs.getString(cKey + ".gui-item").toUpperCase()));

           registerKit(new Kit(cKey, attack, defence, health, itemStack));
        }
    }

    public void unloadKits() {
        getRegisteredKits().clear();
    }

    public List<Kit> getRegisteredKits() {
        return registeredKits;
    }

    public void registerKit(Kit... kits) {
        Arrays.asList(kits).forEach(registeredKits::add);
    }
}
