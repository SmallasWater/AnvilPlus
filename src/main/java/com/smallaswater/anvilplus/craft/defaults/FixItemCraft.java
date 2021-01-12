package com.smallaswater.anvilplus.craft.defaults;

import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.BaseCraftItem;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:49
 * Package com.smallaswater.anvilplus.craft
 */
public class FixItemCraft extends BaseCraftItem {

    private int fixCount;

    public FixItemCraft(Item local, Item second,int fixCount) {
        super(local,second,null);
        this.fixCount = fixCount;
    }


    private Item getEchoItem(Item local,Item second) {
        Item i = local.clone();
        if(i.getDamage() > 0) {
            int damage;
            int count = (int) Math.ceil(((float)i.getDamage()) / ((float) fixCount));
            if(count < 1){
                count = 1;
            }
            if(second.getCount() >= count){
                damage = 0;
                this.second.setCount(count);
            }else{
                damage = local.getDamage() - (second.getCount() * fixCount);
            }
            if(damage < 0){
                damage = 0;
            }
            i.setDamage(damage);
        }else{
            return Item.get(0);
        }



        return i;
    }

    @Override
    public void onEcho(Item local, Item second) {
        this.echo = getEchoItem(local,second);
        super.onEcho(local, second);


    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FixItemCraft){
            return ((FixItemCraft) obj).getLocal().getId() == getLocal().getId() && ((FixItemCraft) obj).getSecond().getId() == getSecond().getId();
        }
        return false;
    }

    public void setFixCount(int fixCount) {
        this.fixCount = fixCount;
    }

    @Override
    public FixItemCraft clone() {
        FixItemCraft clone = null;
        try {
            clone = (FixItemCraft) super.clone();
            clone.setFixCount(fixCount);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
