package com.smallaswater.anvilplus.craft;

import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.AnvilPlus;

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



    public double getUseMoney() {
        return AnvilPlus.getInstance().getConfig().getDouble("使用铁砧消耗数值",10.0);
    }

    public void onEcho(Item local, Item second){
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
        if(obj != null){
            if(obj instanceof BaseCraftItem){
                if(((BaseCraftItem) obj).getLocal() != null && local != null){
                    if(((BaseCraftItem) obj).getLocal().equals(local,true,true)){
                        if(((BaseCraftItem) obj).getSecond() != null && second != null){
                            if(((BaseCraftItem) obj).getSecond().equals(second,true,true)){
                                if(((BaseCraftItem) obj).getEcho() != null && echo != null){
                                    return ((BaseCraftItem) obj).getEcho().equals(echo, true, true);
                                }else{
                                    return ((BaseCraftItem) obj).getEcho() == null && echo == null;
                                }
                            }
                        }else{
                            if(((BaseCraftItem) obj).getSecond() == null && second == null){
                                if(((BaseCraftItem) obj).getEcho() != null && echo != null){
                                    if(((BaseCraftItem) obj).getEcho().equals(echo,true,true)){
                                        return true;
                                    }
                                }else{
                                    if(((BaseCraftItem) obj).getEcho() == null && echo == null){
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }

                    }
                }else{
                    if(((BaseCraftItem) obj).getLocal() == null && local == null){
                        if(((BaseCraftItem) obj).getSecond() != null && second != null){
                            if(((BaseCraftItem) obj).getSecond().equals(second,true,true)){
                                if(((BaseCraftItem) obj).getEcho() != null && echo != null){
                                    return ((BaseCraftItem) obj).getEcho().equals(echo, true, true);
                                }else{
                                    return ((BaseCraftItem) obj).getEcho() == null && echo == null;
                                }
                            }
                        }else{
                            if(((BaseCraftItem) obj).getSecond() == null && second == null){
                                if(((BaseCraftItem) obj).getEcho() != null && echo != null){
                                    if(((BaseCraftItem) obj).getEcho().equals(echo,true,true)){
                                        return true;
                                    }
                                }else{
                                    if(((BaseCraftItem) obj).getEcho() == null && echo == null){
                                        return true;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }

        }
//        if(obj instanceof CraftItem){
//            return ((CraftItem) obj).local.equals(local,true,true) && ((CraftItem) obj).second.equals(second,true,true);
//        }
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
