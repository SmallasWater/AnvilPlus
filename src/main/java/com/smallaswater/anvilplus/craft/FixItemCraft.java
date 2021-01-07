package com.smallaswater.anvilplus.craft;

import cn.nukkit.item.Item;

/**
 * @author SmallasWater
 * Create on 2021/1/7 18:49
 * Package com.smallaswater.anvilplus.craft
 */
public class FixItemCraft extends BaseCraftItem{

    private int fixCount;

    public FixItemCraft(Item local, Item second,int fixCount) {
        super(local,second,null);
        this.fixCount = fixCount;
    }


    private Item getEchoItem() {
        Item i = getLocal().clone();
        int damage = i.getDamage() - fixCount;
        if(damage < 0){
            damage = 0;
        }
        i.setDamage(damage);



        return i;
    }

    @Override
    public void onEcho(Item local, Item second) {
        this.echo = getEchoItem();
        super.onEcho(local, second);


    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FixItemCraft){
            return ((FixItemCraft) obj).getLocal().getId() == getLocal().getId() && ((FixItemCraft) obj).getSecond().getId() == getSecond().getId();
        }
        return false;
    }
}
