package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import com.smallaswater.anvilplus.craft.BaseCraftItem;
import com.smallaswater.anvilplus.craft.CraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:40
 * Package com.smallaswater.anvilplus.events
 */
public class UseCraftItemEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }


    private BaseCraftItem craftItem;
    public UseCraftItemEvent(Player player, BaseCraftItem craftItem){
        this.player = player;
        this.craftItem = craftItem;
    }

    public BaseCraftItem getCraftItem() {
        return craftItem;
    }

    public void setCraftItem(BaseCraftItem craftItem) {
        this.craftItem = craftItem;
    }
}
