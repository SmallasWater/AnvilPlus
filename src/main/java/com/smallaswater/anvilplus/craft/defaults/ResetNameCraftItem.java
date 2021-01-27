package com.smallaswater.anvilplus.craft.defaults;

import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.BaseCraftItem;


/**
 * @author SmallasWater
 * Create on 2021/1/24 16:44
 * Package com.smallaswater.anvilplus.craft.defaults
 */
public class ResetNameCraftItem extends AnyLocalCraftItem{


    public ResetNameCraftItem(Item second) {
        super(second, null);
    }

    @Override
    public void onEcho(Item local, Item second) {
        this.local = local.clone();
        if(second.hasCompoundTag() && second.getNamedTag().contains("anvilName")){
            Item item = this.local.clone();
            if(second.getNamedTag().contains("anvilName")){
                item.setCustomName(second.getNamedTag().getString("anvilName"));
                this.echo = item;
            }
        }
        super.onEcho(local, second);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseCraftItem){
            boolean b = ((BaseCraftItem) obj).getSecond().equals(second,true,true);
            if(((BaseCraftItem) obj).getSecond().hasCompoundTag() && ((BaseCraftItem) obj).getSecond().getNamedTag().contains("anvilItem")){
                return true;
            }
            return b;
        }
        return false;
    }

}
