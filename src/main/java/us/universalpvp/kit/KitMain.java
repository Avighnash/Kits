package us.universalpvp.kit;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by avigh on 7/23/2016.
 */
public class KitMain extends JavaPlugin {

    private static KitMain instance;

    @Override
    public void onEnable() {

    }

    public static KitMain getPlugin() {
        return instance == null ? instance = new KitMain() : instance;
    }
}