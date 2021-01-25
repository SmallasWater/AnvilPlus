package com.smallaswater.anvilplus.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import me.onebone.economyapi.EconomyAPI;
import money.Money;
import net.player.api.Point;

/**
 * @author SmallasWater
 */
public class LoadMoney {
    public static final int MONEY = 1;
    public static final int ECONOMY_API = 0;
    public static final int PLAYER_POINT = 2;
    public static final int EXP = 3;

    private int money;

    public LoadMoney(){
        if(Server.getInstance().getPluginManager().getPlugin("EconomyAPI") != null){
            money = ECONOMY_API;
        }else if(Server.getInstance().getPluginManager().getPlugin("Money") != null){
            money = MONEY;
        }else if(Server.getInstance().getPluginManager().getPlugin("PlayerPoint") != null){
            money = PLAYER_POINT;
        }else{
            money = EXP;
        }

    }

    public String getName(){
        switch (getMoney()){
            case MONEY:
                return Money.getInstance().getCurrency1();
            case ECONOMY_API:
                return "金钱";
            case PLAYER_POINT:
                return Point.getPointName();
                default:
                    return "经验值";
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getMonetaryUnit(){
        if (this.money == ECONOMY_API) {
            return EconomyAPI.getInstance().getMonetaryUnit();
        }
        return "$";
    }

    public double myMoney(Player player){
        return myMoney(player.getName());
    }

    public double myMoney(String player){
        switch (this.money){
            case MONEY:
                if(Money.getInstance().getPlayers().contains(player)){
                    return Money.getInstance().getMoney(player);
                }
                break;
            case ECONOMY_API:
                return EconomyAPI.getInstance().myMoney(player) ;
            case PLAYER_POINT:
                return Point.myPoint(player);
            default:
                Player player1 = Server.getInstance().getPlayer(player);
                if(player1 != null){
                    return player1.getExperience();
                }
                break;
        }
        return 0;
    }

    public void addMoney(Player player, double money){
        addMoney(player.getName(), money);
    }

    public void addMoney(String player, double money){
        switch (this.money){
            case MONEY:
                if(Money.getInstance().getPlayers().contains(player)){
                    Money.getInstance().addMoney(player, (float) money);
                    return;
                }
                break;
            case ECONOMY_API:
                EconomyAPI.getInstance().addMoney(player, money, true);
                return;
            case PLAYER_POINT:
                Point.addPoint(player, money);
                return;
            default:
                Player player1 = Server.getInstance().getPlayer(player);
                if(player1 != null){
                    player1.addExperience((int) money);
                }
                break;
        }
    }
    public boolean reduceMoney(Player player, double money){
        return reduceMoney(player.getName(), money);
    }

    public boolean reduceMoney(String player, double money){
        switch (this.money){
            case MONEY:
                if(Money.getInstance().getPlayers().contains(player)){
                    return Money.getInstance().reduceMoney(player, (float) money);

                }
                break;
            case ECONOMY_API:
                if(EconomyAPI.getInstance().reduceMoney(player, money, true) == 1){
                    return true;
                }

            case PLAYER_POINT:
                return Point.reducePoint(player, money);
            default:
                Player player1 = Server.getInstance().getPlayer(player);
                if(player1 != null){
                    if(player1.getExperience() > money){
                        player1.setExperience((int) (player1.getExperience() - money));
                        return true;
                    }else{
                        if(player1.getGamemode() == 1){
                            return true;
                        }
                    }

                }
                break;
        }
        return false;
    }

}
