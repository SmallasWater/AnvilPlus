package com.smallaswater.anvilplus;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAnvil;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.InventoryTransaction;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.item.Item;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.smallaswater.anvilplus.craft.CraftItemManager;
import com.smallaswater.anvilplus.events.AnvilBreakEvent;
import com.smallaswater.anvilplus.events.AnvilSetEchoItemEvent;
import com.smallaswater.anvilplus.events.PlayerUseAnvilEvent;
import com.smallaswater.anvilplus.inventorys.AnvilPlusInventory;
import com.smallaswater.anvilplus.items.AnvilNameTagItem;
import com.smallaswater.anvilplus.utils.LoadMoney;
import com.smallaswater.anvilplus.utils.Tools;

import java.util.LinkedHashMap;


/**
 * @author SmallasWater
 * Create on 2021/1/4 15:25
 * Package com.smallaswater.anvilplus
 */
public class AnvilPlus extends PluginBase implements Listener {


    private static AnvilPlus instance;
    private static LoadMoney  loadMoney;

    private static LinkedHashMap<Player,AnvilNameTagItem> resetItem = new LinkedHashMap<>();
    public static LinkedHashMap<Player,Block> saveAnvilBlock = new LinkedHashMap<>();

    public static LinkedHashMap<Player,AnvilPlusInventory> inventory = new LinkedHashMap<>();
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        reloadConfig();
        loadMoney = new LoadMoney();
        String economy = getConfig().getString("消耗类型","default").toLowerCase();
        int load = LoadMoney.EXP;
        if("default".equalsIgnoreCase(economy)){
            load = -1;
        }
        if("money".equalsIgnoreCase(economy)){
            load = LoadMoney.MONEY;
        }
        if("playerpoint".equalsIgnoreCase(economy)){
            load = LoadMoney.PLAYER_POINT;
        }
        if("economyapi".equalsIgnoreCase(economy)){
            load = LoadMoney.ECONOMY_API;
        }
        if(load != -1) {
            loadMoney.setMoney(load);
        }
        if(loadMoney.getMoney() == LoadMoney.ECONOMY_API){
            this.getLogger().info("铁砧消耗类型已启用:"+ TextFormat.GREEN+" EconomyAPI");
        }
        if(loadMoney.getMoney()  == LoadMoney.MONEY){
            this.getLogger().info("铁砧消耗类型已启用:"+ TextFormat.GREEN+" Money");
        }
        if(loadMoney.getMoney()  == LoadMoney.PLAYER_POINT){
            this.getLogger().info("铁砧消耗类型已启用:"+ TextFormat.GREEN+" PlayerPoint");
        }
        if(loadMoney.getMoney()  == LoadMoney.EXP){
            this.getLogger().info("铁砧消耗类型已启用:"+ TextFormat.GREEN+" 经验值");
        }

        this.getLogger().info(format("&b[铁砧] 插件加载成功"));
        CraftItemManager.init();
        Item.addCreativeItem(new AnvilNameTagItem());
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    public static LoadMoney getLoadMoney() {
        return loadMoney;
    }

    public static AnvilPlus getInstance() {
        return instance;
    }

    @EventHandler
    public void onSetEchoItem(AnvilSetEchoItemEvent event){
        Player player = event.getPlayer();
        if(player.getGamemode() != 1) {
            double exp = getConfig().getDouble("使用铁砧消耗数值",10.0);
            if (loadMoney.myMoney(player) < exp) {
                event.setCancelledItem(loadMoney.getName()+"不足");
            }
        }
    }



    @EventHandler(priority = EventPriority.MONITOR)
    public void onInstance(PlayerInteractEvent event){
        Block block = event.getBlock();
        Item item = event.getItem();
        if (event.isCancelled()){
            return;
        }
        if(event.getAction() == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK
                || event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
                if (item.hasCompoundTag() && item.getNamedTag().contains("anvilItem")) {
                    if(event.getPlayer().isSneaking()) {
                        resetItem.put(event.getPlayer(), new AnvilNameTagItem());
                        FormWindowCustom custom = new FormWindowCustom("重命名");
                        custom.addElement(new ElementInput("请输入新的名称"));
                        event.getPlayer().showFormWindow(custom, 0x55a401);
                    }
                    event.setCancelled();
                    return;
                }

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
    public void onWindowListener(PlayerFormRespondedEvent event){
        if(event.getFormID() == 0x55a401 && event.getWindow() instanceof FormWindowCustom){
           if(event.getWindow().getResponse() != null) {
               String name = ((FormResponseCustom) event.getWindow().getResponse()).getInputResponse(0);
               if (name == null) {
                   return;
               }
               if (resetItem.containsKey(event.getPlayer())) {
                   AnvilNameTagItem item = resetItem.get(event.getPlayer());
                   item.setName(name);
                   event.getPlayer().getInventory().setItemInHand(item);
               }
           }
        }
    }

    @EventHandler
    public void onAnvilBreak(AnvilBreakEvent event){
        Block block = event.getBlock();
        if(getConfig().getStringList("铁砧损坏白名单").contains(block.level.getFolderName())){
            event.setCancelled();
        }
    }

    @EventHandler
    public void onPlayerUseAnvil(PlayerUseAnvilEvent event){
        Block block = event.getBlock();
        if(block instanceof BlockAnvil){
            AnvilBreakEvent event1 = new AnvilBreakEvent(event.getPlayer(),block);
            Server.getInstance().getPluginManager().callEvent(event1);
            if(!event1.isCancelled()) {
                if (block.getDamage() < 12) {
                    BlockAnvil anvil = new BlockAnvil();
                    anvil.setDamage(block.getDamage() + 2);
                    event.getBlock().level.setBlock(block, anvil, true);
                } else {
                    removeInventory(event.getBlock());
                    event.getBlock().level.setBlock(block, Block.get(0));
                }
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
