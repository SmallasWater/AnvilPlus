package com.smallaswater.anvilplus.craft;

import cn.nukkit.item.Item;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:28
 * Package com.smallaswater.anvilplus.craft
 */
public class CraftItem extends BaseCraftItem{


    public CraftItem(Item local, Item second, Item echo) {
        super(local, second, echo);
    }

    @Override
    public CraftItem clone() {
        try {
            CraftItem clone = (CraftItem) super.clone();
            Item local = this.local.clone();
            Item second = this.second.clone();
            Item echo = this.echo.clone();
            clone.setLocal(local);
            clone.setSecond(second);
            clone.setEcho(echo);
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
