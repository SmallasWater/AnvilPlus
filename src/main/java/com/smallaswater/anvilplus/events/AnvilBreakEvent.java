package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

/**
 * @author SmallasWater
 * Create on 2021/1/12 20:53
 * Package com.smallaswater.anvilplus.events
 */
public class AnvilBreakEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    private Block block;
    public AnvilBreakEvent(Player player, Block block){
        this.player = player;
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
