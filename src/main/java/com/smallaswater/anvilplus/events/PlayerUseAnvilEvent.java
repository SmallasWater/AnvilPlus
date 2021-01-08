package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/8 11:55
 * Package com.smallaswater.anvilplus.events
 */
public class PlayerUseAnvilEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }


    private BaseCraftItem craftItem;
    private Block block;
    public PlayerUseAnvilEvent(Player player, BaseCraftItem craftItem, Block block){
        this.player = player;
        this.craftItem = craftItem;
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }


    public BaseCraftItem getCraftItem() {
        return craftItem;
    }

}
