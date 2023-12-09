package com.坦克大战.Tank;

import java.util.Vector;

public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed = 1;
    public boolean live = true;
    public Vector<Bullet> bullets = new Vector<>();
    public int getSpeed() {
        return speed;
    }
    private Bullet bullet;
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //创建子弹并射击
    public void shot(){
        if (bullets.size() == 5){
            return;
        }
        switch (getDirection()){
            case 0://Up
                bullet = new Bullet(getX()+20,getY(),getDirection());
                break;
            case 1://Right
                bullet = new Bullet(getX() + 60,getY() + 20,getDirection());
                break;
            case 2://Down
                bullet = new Bullet(getX() + 20,getY() + 60,getDirection());
                break;
            case 3://Left
                bullet = new Bullet(getX(),getY() + 20,getDirection());
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();
    }
    //移动
    public void moveUp(){
        if (this.getY()>0){
            y-=speed;
        }
    }
    public void moveDown(){
        if(this.getY()+60<750){y+=speed;}
    }
    public void moveLeft(){
        if(this.getX()>0){x-=speed;}
    }
    public void moveRight(){
        if(this.getX()+60<1000){x+=speed;}
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
