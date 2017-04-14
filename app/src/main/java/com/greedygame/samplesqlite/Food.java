package com.greedygame.samplesqlite;

/**
 * Created by nikhil on 4/4/17.
 */

public class Food {
    int id;
    String foodName;

    public Food()
    {
    }

//    public  Food (int id, String foodName)
//    {
//        this.id = id;
//        this.foodName = foodName;
//    }

    public int getid(){
        return id;
    }

    public String getfoodName(){
        return foodName;
    }

    public void setid(int id){
        this.id = id;
    }

    public void setfoodName(String foodName)
    {
        this.foodName = foodName;
    }
}
