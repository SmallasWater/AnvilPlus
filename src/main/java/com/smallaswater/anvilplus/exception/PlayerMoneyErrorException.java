package com.smallaswater.anvilplus.exception;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.item.Item;
import cn.nukkit.level.Explosion;
import cn.nukkit.level.Position;

/**
 * @author SmallasWater
 * Create on 2021/1/12 18:47
 * Package com.smallaswater.anvilplus.exception
 */
public class PlayerMoneyErrorException extends Exception {

    private Player player;
    private double money;
    private Item i;
    public PlayerMoneyErrorException(Player player, double money, Item i) {
        this.player = player;
        this.money = money;
        this.i = i;
    }

    public Item getI() {
        return i;
    }

    public double getMoney() {
        return money;
    }

    public Player getPlayer() {
        return player;
    }
}
