package com.smallaswater.anvilplus.craft;


import cn.nukkit.item.Item;
import com.smallaswater.anvilplus.craft.defaults.CraftItem;
import com.smallaswater.anvilplus.craft.defaults.FixItemCraft;

import java.lang.reflect.Constructor;
import java.util.LinkedList;

/**
 * 这里可以自定义配方
 * @author SmallasWater
 * Create on 2021/1/7 18:27
 * Package com.smallaswater.anvilplus.craft
 */
public class CraftItemManager {

    private static LinkedList<BaseCraftItem> craftItems = new LinkedList<>();
    private static final LinkedList<Class<? extends BaseCraftItem>> CRAFT_ITEMS_CLASS = new LinkedList<>();

    public static void init(){
        register(CraftItem.class);
        register(FixItemCraft.class);

        //---木制--//
        addCraftItem(new FixItemCraft(Item.get(268),Item.get(17),(int) Math.ceil(Item.get(268).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(269),Item.get(17),(int) Math.ceil(Item.get(269).getMaxDurability()/ 2.0)));
        addCraftItem(new FixItemCraft(Item.get(270),Item.get(17),(int) Math.ceil(Item.get(270).getMaxDurability() / 4.0)));
        addCraftItem(new FixItemCraft(Item.get(271),Item.get(17),(int) Math.ceil(Item.get(271).getMaxDurability() / 4.0)));
        addCraftItem(new FixItemCraft(Item.get(279),Item.get(17),(int) Math.ceil(Item.get(290).getMaxDurability() / 3.0)));
        //--石制---//
        addCraftItem(new FixItemCraft(Item.get(272),Item.get(4),(int) Math.ceil(Item.get(272).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(273),Item.get(4),(int) Math.ceil(Item.get(273).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(274),Item.get(4),(int) Math.ceil(Item.get(274).getMaxDurability() / 4.0)));
        addCraftItem(new FixItemCraft(Item.get(275),Item.get(4),(int) Math.ceil(Item.get(275).getMaxDurability() / 4.0)));
        addCraftItem(new FixItemCraft(Item.get(291),Item.get(4),(int) Math.ceil(Item.get(291).getMaxDurability() / 3.0)));
        //----铁---//
        addCraftItem(new FixItemCraft(Item.get(256),Item.get(265), (int) Math.ceil(Item.get(256).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(257),Item.get(265),(int) Math.ceil(Item.get(257).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(258),Item.get(265),(int) Math.ceil(Item.get(258).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(267),Item.get(265),(int) Math.ceil(Item.get(267).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(292),Item.get(265),(int) Math.ceil(Item.get(292).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(306),Item.get(265),(int) Math.ceil(Item.get(306).getMaxDurability() / 5.0)));
        addCraftItem(new FixItemCraft(Item.get(307),Item.get(265),(int) Math.ceil(Item.get(307).getMaxDurability() / 8.0)));
        addCraftItem(new FixItemCraft(Item.get(308),Item.get(265),(int) Math.ceil(Item.get(308).getMaxDurability() / 7.0)));
        addCraftItem(new FixItemCraft(Item.get(309),Item.get(265),(int) Math.ceil(Item.get(309).getMaxDurability() / 4.0)));
        //---金--//
        addCraftItem(new FixItemCraft(Item.get(283),Item.get(266),(int) Math.ceil(Item.get(283).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(284),Item.get(266),(int) Math.ceil(Item.get(284).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(285),Item.get(266),(int) Math.ceil(Item.get(285).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(286),Item.get(266),(int) Math.ceil(Item.get(286).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(294),Item.get(266),(int) Math.ceil(Item.get(294).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(314),Item.get(266),(int) Math.ceil(Item.get(314).getMaxDurability() / 5.0)));
        addCraftItem(new FixItemCraft(Item.get(315),Item.get(266),(int) Math.ceil(Item.get(315).getMaxDurability() / 8.0)));
        addCraftItem(new FixItemCraft(Item.get(316),Item.get(266),(int) Math.ceil(Item.get(316).getMaxDurability() / 7.0)));
        addCraftItem(new FixItemCraft(Item.get(317),Item.get(266),(int) Math.ceil(Item.get(317).getMaxDurability() / 4.0)));
        //--钻--//
        addCraftItem(new FixItemCraft(Item.get(276),Item.get(264),(int) Math.ceil(Item.get(276).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(277),Item.get(264),(int) Math.ceil(Item.get(277).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(278),Item.get(264),(int) Math.ceil(Item.get(278).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(279),Item.get(264),(int) Math.ceil(Item.get(279).getMaxDurability() / 3.0)));
        addCraftItem(new FixItemCraft(Item.get(293),Item.get(264),(int) Math.ceil(Item.get(293).getMaxDurability() / 2.0)));
        addCraftItem(new FixItemCraft(Item.get(310),Item.get(264),(int) Math.ceil(Item.get(310).getMaxDurability() / 5.0)));
        addCraftItem(new FixItemCraft(Item.get(311),Item.get(264),(int) Math.ceil(Item.get(311).getMaxDurability() / 8.0)));
        addCraftItem(new FixItemCraft(Item.get(312),Item.get(264),(int) Math.ceil(Item.get(312).getMaxDurability() / 7.0)));
        addCraftItem(new FixItemCraft(Item.get(313),Item.get(264),(int) Math.ceil(Item.get(313).getMaxDurability() / 4.0)));
    }


    public static void addCraftItem(BaseCraftItem craftItem){
        if(!craftItems.contains(craftItem)){
            craftItems.add(craftItem);
        }
    }



    public static void register(Class<? extends BaseCraftItem> craftItem){
        CRAFT_ITEMS_CLASS.add(craftItem);
    }

    public static BaseCraftItem getCraftItem(BaseCraftItem craftItem){
        if(craftItem != null) {
            for(BaseCraftItem craftItem1:craftItems){
                if(craftItem1.equals(craftItem)){
                    try {
                        return craftItem1.clone();
                    }catch (Exception e){
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static BaseCraftItem getCraftItem(Item local,Item second) {
        BaseCraftItem variable = null;
        for (Class<? extends BaseCraftItem> var : CRAFT_ITEMS_CLASS) {
            for (Constructor<?> constructor : var.getConstructors()) {
                try {
                    if(var == FixItemCraft.class){
                        variable = (BaseCraftItem) constructor.newInstance(local, second,0);
                    }else{
                        variable = (BaseCraftItem) constructor.newInstance(local, second,null);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return getCraftItem(variable);
    }
//        BaseCraftItem craftItem = new BaseCraftItem(local,second,null) {
//        }
//        if(craftItems.contains(craftItem)){
//            return craftItems.get(craftItems.indexOf(craftItem));
//        }
//        return null;

}
