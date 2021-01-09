package com.smallaswater.anvilplus;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAnvil;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.smallaswater.anvilplus.craft.CraftItemManager;
import com.smallaswater.anvilplus.events.PlayerUseAnvilEvent;
import com.smallaswater.anvilplus.inventorys.AnvilPlusInventory;
import com.smallaswater.anvilplus.utils.Tools;

import java.util.LinkedHashMap;


/**
 * @author SmallasWater
 * Create on 2021/1/4 15:25
 * Package com.smallaswater.anvilplus
 */
public class AnvilPlus extends PluginBase implements Listener {

    public static LinkedHashMap<Player,Block> saveAnvilBlock = new LinkedHashMap<>();

    public static LinkedHashMap<Player,AnvilPlusInventory> inventory = new LinkedHashMap<>();
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
                saveAnvilBlock.put(event.getPlayer(),block);
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onPlayerUseAnvil(PlayerUseAnvilEvent event){
        Block block = event.getBlock();
        if(block instanceof BlockAnvil){
            if(block.getDamage() < 12) {
                BlockAnvil anvil = new BlockAnvil();
                anvil.setDamage(block.getDamage() + 2);
                event.getBlock().level.setBlock(block,anvil,true);
            }else{
                removeInventory(event.getBlock());
                event.getBlock().level.setBlock(block,Block.get(0));
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        AnvilPlus.inventory.remove(event.getPlayer());
        AnvilPlus.saveAnvilBlock.remove(event.getPlayer());
    }

    public static String format(String msg){
        return TextFormat.colorize('&',msg);
    }

    private void removeInventory(Block block){
        Block b;
        for(Player player: saveAnvilBlock.keySet()){
            b = saveAnvilBlock.get(player);
            if(b.equals(block)){
                if(inventory.containsKey(player)){
                    player.removeWindow(inventory.get(player));
                }
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent  event){
        if(event.isCancelled()){
            return;
        }
        removeInventory(event.getBlock());

    }


    @EventHandler
    public void onItemChange(InventoryTransactionEvent event){
        InventoryTransaction transaction = event.getTransaction();
        for(InventoryAction action:transaction.getActions()){
            Item item =  action.getSourceItem();
            for(Inventory inventory:transaction.getInventories()){
                if(inventory instanceof AnvilPlusInventory){
                    if(item.getNamedTag() != null){
                        if(item.getNamedTag().contains("tag_name") && "OccupyItem".equalsIgnoreCase(item.getNamedTag().getString("tag_name"))){
                            event.setCancelled();
                            return;
                        }
                    }
                }
            }

        }
    }



}
