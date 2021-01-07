package com.smallaswater.anvilplus.inventorys;

import cn.nukkit.Player;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.InventoryHolder;

/**
 * @author SmallasWater
 * Create on 2021/1/7 13:29
 * Package com.smallaswater.anvilplus.inventorys
 */
public class BaseHolder implements InventoryHolder {


    private AnvilPlusInventory inventory;

    public BaseHolder(Player player){
        this.inventory = new AnvilPlusInventory(player,this);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
