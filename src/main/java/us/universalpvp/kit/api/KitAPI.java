package us.universalpvp.kit.api;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import us.universalpvp.kit.KitMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avigh on 7/24/2016.
 */
public class KitAPI {

    private static KitAPI api;

    public void loadKits() {
        ConfigurationSection cs = KitMain.getPlugin().getConfig().getConfigurationSection("kits");
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

    public static KitAPI getAPI() {
        if (api == null) {
            api = new KitAPI();
        }
        return api;
    }

    private static List<Kit> registeredKits = new ArrayList<>();

    public List<Kit> getRegisteredKits() {
        return registeredKits;
    }

    public void registerKit(Kit... kits) {
        Arrays.asList(kits).forEach(kit -> registeredKits.add(kit));
    }
}
