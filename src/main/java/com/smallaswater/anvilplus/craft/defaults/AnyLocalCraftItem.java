package com.smallaswater.anvilplus.craft.defaults;

import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/24 16:37
 * Package com.smallaswater.anvilplus.craft.defaults
 */
public class AnyLocalCraftItem extends BaseCraftItem {

    public AnyLocalCraftItem(Item second, Item echo) {
        super(null, second, echo);
    }



    @Override
    public AnyLocalCraftItem clone() {
        AnyLocalCraftItem clone = null;
        try {
            clone = (AnyLocalCraftItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseCraftItem){
            return ((BaseCraftItem) obj).getSecond().equals(second,true);
        }
        return false;
    }
}
