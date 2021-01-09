package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/9 17:38
 * Package com.smallaswater.anvilplus.events
 */
public class AnvilSetEchoItemEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    private BaseCraftItem echo;

    private boolean cancel;

    public AnvilSetEchoItemEvent(Player player, BaseCraftItem echo){
        this.player = player;
        this.echo = echo;
    }

    public BaseCraftItem getEcho() {
        return echo;
    }

    public boolean isCancelledItem() {
        return this.cancel;
    }

    public void setCancelledItem(boolean cancel) {
        this.cancel = cancel;
    }
    public void setCancelledItem() {
        this.cancel = true;
    }
}
