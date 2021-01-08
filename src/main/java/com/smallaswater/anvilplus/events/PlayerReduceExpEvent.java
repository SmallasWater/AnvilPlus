package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/8 14:58
 * Package com.smallaswater.anvilplus.events
 */
public class PlayerReduceExpEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }
    private BaseCraftItem craftItem;
    private int exp;

    public PlayerReduceExpEvent(Player player, int exp, BaseCraftItem  craftItem){
        this.craftItem = craftItem;
        this.player = player;
        this.exp = exp;
    }

    public BaseCraftItem getCraftItem() {
        return craftItem;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
