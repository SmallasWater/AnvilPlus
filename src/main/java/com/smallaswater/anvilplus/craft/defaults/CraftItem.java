package com.smallaswater.anvilplus.craft.defaults;

import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:28
 * Package com.smallaswater.anvilplus.craft
 */
public final class CraftItem extends BaseCraftItem {



    public CraftItem(Item local, Item second, Item echo) {
        super(local, second, echo);
    }

    @Override
    public CraftItem clone() {
        CraftItem clone = null;
        try {
            clone = (CraftItem) super.clone();
            Item local = this.local.clone();
            Item second = this.second.clone();
            Item echo = this.echo.clone();
            clone.setLocal(local);
            clone.setSecond(second);
            clone.setEcho(echo);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;

    }




}
