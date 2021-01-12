package com.smallaswater.anvilplus.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;
import com.smallaswater.anvilplus.BaseCraftItem;

/**
 * 玩家从铁砧取出物品
 * @author SmallasWater
 * Create on 2021/1/8 11:55
 * Package com.smallaswater.anvilplus.events
 */
public class PlayerUseAnvilEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlers() {
        return HANDLER_LIST;
    }


    private BaseCraftItem craftItem;
    private Block block;
    private double exp;
    public PlayerUseAnvilEvent(Player player, BaseCraftItem craftItem, Block block,double exp){
        this.player = player;
        this.craftItem = craftItem;
        this.block = block;
        this.exp = exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getExp() {
        return exp;
    }

    public Block getBlock() {
        return block;
    }


    public BaseCraftItem getCraftItem() {
        return craftItem;
    }

}
