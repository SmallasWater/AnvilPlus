package com.smallaswater.anvilplus;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAnvil;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.smallaswater.anvilplus.craft.CraftItemManager;
import com.smallaswater.anvilplus.inventorys.AnvilPlusInventory;
import com.smallaswater.anvilplus.utils.Tools;


/**
 * @author SmallasWater
 * Create on 2021/1/4 15:25
 * Package com.smallaswater.anvilplus
 */
public class AnvilPlus extends PluginBase implements Listener {


    @Override
    public void onEnable() {
        this.getLogger().info(format("&b[铁砧] 插件加载成功"));
        CraftItemManager.init();
        this.getServer().getPluginManager().registerEvents(this,this);
    }



    @EventHandler(priority = EventPriority.MONITOR)
    public void onInstance(PlayerInteractEvent event){
        Block block = event.getBlock();
        if (event.isCancelled()){
            return;
        }
        if(block instanceof BlockAnvil){
            if(event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
                Tools.getAnvilInventory(event.getPlayer());
                event.setCancelled();
            }
        }
    }

    public static String format(String msg){
        return TextFormat.colorize('&',msg);
    }

    @EventHandler
    public void onItemChange(InventoryTransactionEvent event){
        InventoryTransaction transaction = event.getTransaction();
        for(InventoryAction action:transaction.getActions()){
            Item item =  action.getSourceItem();
            if(item.getNamedTag() != null){
                if(item.getNamedTag().contains("tag_name") && "OccupyItem".equalsIgnoreCase(item.getNamedTag().getString("tag_name"))){
                    for(Inventory inventory:transaction.getInventories()){
                        if(inventory instanceof AnvilPlusInventory){
                            event.setCancelled();
                            return;
                        }
                    }
                }
            }
        }
    }

}
