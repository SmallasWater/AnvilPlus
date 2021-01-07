package com.smallaswater.anvilplus.utils;

import cn.nukkit.item.Item;
import cn.nukkit.nbt.tag.CompoundTag;
import com.smallaswater.anvilplus.AnvilPlus;

/**
 * @author SmallasWater
 * Create on 2021/1/7 11:26
 * Package com.smallaswater.anvilplus.utils
 */
public class OccupyItem extends Item {

    public OccupyItem() {
        super(101);
        CompoundTag tag = new CompoundTag();
        tag.putString("tag_name","OccupyItem");
        this.setCompoundTag(tag);
        this.setCustomName(AnvilPlus.format("&r&c这里无法放置物品哦"));
//        this.setLore(AnvilPlus.format("&r&e================="),"", AnvilPlus.format("&r&a前面放置你要修复或附魔的工具"), AnvilPlus.format("&r&d后面请放置材料"),"",
//                AnvilPlus.format("&r&e================="));
    }


}
