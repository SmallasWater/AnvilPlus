package com.smallaswater.anvilplus;

import cn.nukkit.item.Item;

/**
 * @author SmallasWater
 * Create on 2021/1/7 20:42
 * Package com.smallaswater.anvilplus.craft
 */
public abstract class BaseCraftItem implements Cloneable{



    protected Item local,second,echo;

    public BaseCraftItem(Item local,Item second,Item echo) {
        this.local = local;
        this.second = second;
        this.echo = echo;
    }



    public void onEcho(Item local,Item second){
        if(local.getCount() - this.local.getCount() > 0){
            this.local.setCount(local.getCount() - this.local.getCount());
        }else{
            this.local = Item.get(0);
        }
        if(second.getCount() - this.second.getCount() > 0){
            this.second.setCount(second.getCount() - this.second.getCount());
        }else{
            this.second = Item.get(0);
        }

    }


    public Item getEcho() {
        return echo;
    }

    public Item getLocal() {
        return local;
    }

    public Item getSecond() {
        return second;
    }

    public void setEcho(Item echo) {
        this.echo = echo;
    }

    public void setLocal(Item local) {
        this.local = local;
    }

    public void setSecond(Item second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseCraftItem){
            return ((BaseCraftItem) obj).local.equals(local,true,true) && ((BaseCraftItem) obj).second.equals(second,true,true);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }


    @Override
    public BaseCraftItem clone() throws CloneNotSupportedException {
        return (BaseCraftItem) super.clone();
    }
}
