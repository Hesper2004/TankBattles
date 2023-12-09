package com.坦克大战.Tank;

public class Bullet implements Runnable{
    int x;
    int y;
    private int direction = 0;
    int speed = 10;
    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction){
                case 0://Up
                    y-=speed;
                    break;
                case 1://Right
                    x+=speed;
                    break;
                case 2://Down
                    y+=speed;
                    break;
                case 3://Left
                    x-=speed;
                    break;
            }
            System.out.println(x + ' ' + y);
            if (!(x>=0&&x<=1000&&y>=0&&y<=750&&live)){
                live = false;
                break;
            }
        }

    }
}
