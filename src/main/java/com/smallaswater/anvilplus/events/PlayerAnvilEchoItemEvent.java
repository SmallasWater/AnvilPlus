package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.BaseCraftItem;
import com.smallaswater.anvilplus.inventorys.AnvilPlusInventory;

/**
 * 当铁砧可以输出物品的时候，触发这个事件
 * @author SmallasWater
 * Create on 2021/1/9 16:43
 * Package com.smallaswater.anvilplus.events
 */
public class PlayerAnvilEchoItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    private BaseCraftItem craftItem;

    private AnvilPlusInventory inventory;

    private Item local,second;

    public PlayerAnvilEchoItemEvent(Player player, Item local,Item second, BaseCraftItem craftItem, AnvilPlusInventory inventory){
        this.craftItem = craftItem;
        this.player = player;
        this.inventory = inventory;
        this.local = local;
        this.second = second;
    }

    public Item getLocal() {
        return local;
    }

    public Item getSecond() {
        return second;
    }

    public AnvilPlusInventory getInventory() {
        return inventory;
    }

    public BaseCraftItem getCraftItem() {
        return craftItem;
    }
}
