package com.坦克大战.Tank;

public class Bomb {
    int x;
    int y;
    int live = 9;
    public boolean isLive = true;
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDown(){
        if (live>0){
            live--;
        } else {
            isLive = false;
        }
    }
}
