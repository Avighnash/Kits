package us.universalpvp.kit.api;

import org.bukkit.inventory.ItemStack;

/**
 * Created by avigh on 7/23/2016.
 */
public class Kit {
    private String name;
    private int attack, defence;
    private double health;
    private ItemStack[] items;
    private ItemStack guiItem;

    public Kit(String name, int attack, int defence, double health, ItemStack guiItem) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.guiItem = guiItem;
    }

    public String getName() {
        return name;
    }

    public int getExtraAttack() {
        return attack;
    }

    public int getExtraDefence() {
        return defence;
    }

    public double getHealth() {
        return health;
    }

    public void setItems(ItemStack[] items) {
        this.items = items;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public ItemStack getGuiItem() {
        return guiItem;
    }

    public void setGuiItem(ItemStack guiItem) {
        this.guiItem = guiItem;
    }
}
