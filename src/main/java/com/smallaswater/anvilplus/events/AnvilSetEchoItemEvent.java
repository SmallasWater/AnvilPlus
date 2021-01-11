package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * 可以对输出的物品进行设置
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

    private Item local,second;

    private boolean cancel;
    private String cause = "Unknown";

    public AnvilSetEchoItemEvent(Player player, Item local,Item second, BaseCraftItem echo){
        this.player = player;
        this.echo = echo;
        this.local = local;
        this.second = second;
    }

    public String getCause() {
        return cause;
    }

    public Item getLocal() {
        return local;
    }

    public Item getSecond() {
        return second;
    }

    public BaseCraftItem getEcho() {
        return echo;
    }

    public boolean isCancelledItem() {
        return this.cancel;
    }

    public void setCancelledItem(boolean cancel,String cause) {
        this.cancel = cancel;
        this.cause = cause;
    }

    public void setCancelledItem(String cause) {
        this.cancel = true;
        this.cause = cause;
    }
    public void setCancelledItem() {
        this.cancel = true;
    }
}
