package com.smallaswater.anvilplus.items;

import cn.nukkit.item.Item;
import cn.nukkit.nbt.tag.CompoundTag;
import com.smallaswater.anvilplus.AnvilPlus;

/**
 * @author SmallasWater
 * Create on 2021/1/24 16:22
 * Package com.smallaswater.anvilplus.items
 */
public class AnvilNameTagItem extends Item {

    public static final String NAME = "&c&l未设置";

    public AnvilNameTagItem() {
        super(421);
        this.setCustomName(AnvilPlus.format("&r&e<潜行右键重命名>"));
        this.setLore(AnvilPlus.format("\n&r&7可以对物品进行重命名\n&r--------\n&r&e当前绑定名称:\n\n&r"+ NAME));
        CompoundTag tag = this.getNamedTag();
        tag.putString("anvilItem",this.getClass().getSimpleName());
        this.setNamedTag(tag);
    }


    public void setName(String name) {
        CompoundTag tag = this.getNamedTag();
        tag.putString("anvilName",name);
        tag.putString("anvilItem",this.getClass().getSimpleName());
        this.setNamedTag(tag);
        this.setLore(AnvilPlus.format("\n&r&7可以对物品进行重命名\n&r--------\n&r&e当前绑定名称:\n\n&r"+ name));
    }
}
