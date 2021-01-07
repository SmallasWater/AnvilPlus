package com.smallaswater.anvilplus.craft;


import cn.nukkit.item.Item;

import java.util.LinkedList;

/**
 * 这里可以自定义配方
 * @author SmallasWater
 * Create on 2021/1/7 18:27
 * Package com.smallaswater.anvilplus.craft
 */
public class CraftItemManager {

    private static LinkedList<BaseCraftItem> craftItems = new LinkedList<>();

    public static void init(){
        //---木制--//
        register(new FixItemCraft(Item.get(268),Item.get(17),10));
        register(new FixItemCraft(Item.get(269),Item.get(17),10));
        register(new FixItemCraft(Item.get(270),Item.get(17),10));
        register(new FixItemCraft(Item.get(271),Item.get(17),10));
        register(new FixItemCraft(Item.get(279),Item.get(17),10));
        //--石制---//
        register(new FixItemCraft(Item.get(272),Item.get(4),10));
        register(new FixItemCraft(Item.get(273),Item.get(4),10));
        register(new FixItemCraft(Item.get(274),Item.get(4),10));
        register(new FixItemCraft(Item.get(275),Item.get(4),10));
        register(new FixItemCraft(Item.get(291),Item.get(4),10));
        //----铁---//
        register(new FixItemCraft(Item.get(256),Item.get(265),10));
        register(new FixItemCraft(Item.get(257),Item.get(265),10));
        register(new FixItemCraft(Item.get(258),Item.get(265),10));
        register(new FixItemCraft(Item.get(267),Item.get(265),10));
        register(new FixItemCraft(Item.get(292),Item.get(265),10));
        register(new FixItemCraft(Item.get(306),Item.get(265),10));
        register(new FixItemCraft(Item.get(307),Item.get(265),10));
        register(new FixItemCraft(Item.get(308),Item.get(265),10));
        register(new FixItemCraft(Item.get(309),Item.get(265),10));
        //---金--//
        register(new FixItemCraft(Item.get(283),Item.get(266),10));
        register(new FixItemCraft(Item.get(284),Item.get(266),10));
        register(new FixItemCraft(Item.get(285),Item.get(266),10));
        register(new FixItemCraft(Item.get(286),Item.get(266),10));
        register(new FixItemCraft(Item.get(294),Item.get(266),10));
        register(new FixItemCraft(Item.get(314),Item.get(266),10));
        register(new FixItemCraft(Item.get(315),Item.get(266),10));
        register(new FixItemCraft(Item.get(316),Item.get(266),10));
        register(new FixItemCraft(Item.get(317),Item.get(266),10));
        //--钻--//
        register(new FixItemCraft(Item.get(276),Item.get(264),10));
        register(new FixItemCraft(Item.get(277),Item.get(264),10));
        register(new FixItemCraft(Item.get(278),Item.get(264),10));
        register(new FixItemCraft(Item.get(279),Item.get(264),10));
        register(new FixItemCraft(Item.get(293),Item.get(264),10));
        register(new FixItemCraft(Item.get(310),Item.get(264),10));
        register(new FixItemCraft(Item.get(311),Item.get(264),10));
        register(new FixItemCraft(Item.get(312),Item.get(264),10));
        register(new FixItemCraft(Item.get(313),Item.get(264),10));
    }



    public static void register(BaseCraftItem craftItem){
        if(!craftItems.contains(craftItem)){
            craftItems.add(craftItem);
        }
    }

    public static BaseCraftItem getCraftItem(Item local,Item second){
        CraftItem craftItem = new CraftItem(local,second,null);
        FixItemCraft fixItem = new FixItemCraft(local,second,0);
        for(BaseCraftItem baseCraftItem: craftItems){
            if(baseCraftItem.equals(craftItem) ){
                return baseCraftItem.clone();
            }
            if(baseCraftItem.equals(fixItem)){
                return baseCraftItem.clone();
            }
        }
        return null;
    }
}
