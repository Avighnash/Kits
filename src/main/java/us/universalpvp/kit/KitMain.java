package us.universalpvp.kit;

import us.universalpvp.kit.api.KitAPI;
import us.universalpvp.kit.event.listeners.GUIInteractionListener;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by avigh on 7/23/2016.
 */
public class KitMain extends JavaPlugin {
    @Override
    public void onEnable() {
        KitAPI.initialise(this);

        getServer().getPluginManager().registerEvents(new GUIInteractionListener(this), this);
    }
}