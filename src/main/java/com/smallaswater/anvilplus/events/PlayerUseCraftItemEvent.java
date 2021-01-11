package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:40
 * Package com.smallaswater.anvilplus.events
 */
public class PlayerUseCraftItemEvent extends PlayerEvent implements Cancellable{

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }


    private BaseCraftItem craftItem;
    private Item local,second;
    public PlayerUseCraftItemEvent(Player player, Item local,Item second, BaseCraftItem craftItem){
        this.player = player;
        this.craftItem = craftItem;
        this.local = local;
        this.second = second;
    }

    public Item getSecond() {
        return second;
    }

    public Item getLocal() {
        return local;
    }

    public BaseCraftItem getCraftItem() {
        return craftItem;
    }

    public void setCraftItem(BaseCraftItem craftItem) {
        this.craftItem = craftItem;
    }
}
