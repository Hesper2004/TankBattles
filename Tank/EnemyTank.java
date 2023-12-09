package com.坦克大战.Tank;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y);
        super.setDirection(direction);
    }
    //防止坦克重复
    public boolean isTouch(){
        switch (getDirection()){
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        //上下
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (enemyTank.getX()+40>=this.getX() && enemyTank.getX()<=this.getX()
                                    &&enemyTank.getY()+60>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()>=this.getX()+40 && enemyTank.getX()+40<=this.getX()+40
                                    &&enemyTank.getY()+60>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                        } else {
                            if (enemyTank.getX()<=this.getX() && enemyTank.getX()+60<=this.getX()
                                    &&enemyTank.getY()+40>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()<=this.getX()+40 && enemyTank.getX()+60>=this.getX()+40
                                    &&enemyTank.getY()+40>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank != this){
                    //上下
                    if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                        if (enemyTank.getX()+40>=this.getX()+60 && enemyTank.getX()<=this.getX()+60
                                &&enemyTank.getY()+60>=this.getY()&&this.getY()>=enemyTank.getY()){
                            return true;
                        }
                        if (enemyTank.getX()+40>=this.getX()+60 && enemyTank.getX()<=this.getX()+60
                                &&enemyTank.getY()+60>=this.getY()+40&&this.getY()+40>=enemyTank.getY()){
                            return true;
                        }
                    } else {
                        if (enemyTank.getX()<=this.getX()+60 && enemyTank.getX()+60<=this.getX()+60
                                &&enemyTank.getY()+40>=this.getY()&&this.getY()>=enemyTank.getY()){
                            return true;
                        }
                        if (enemyTank.getX()<=this.getX()+60 && enemyTank.getX()+60>=this.getX()+60
                                &&enemyTank.getY()+40>=this.getY()+40&&this.getY()+40>=enemyTank.getY()){
                            return true;
                        }
                    }
                }
            }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        //上下
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (enemyTank.getX()+40>=this.getX() && enemyTank.getX()<=this.getX()
                                    &&enemyTank.getY()+60>=this.getY()+60&&this.getY()+60>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()+40>=this.getX()+40 && enemyTank.getX()<=this.getX()+40
                                    &&enemyTank.getY()+60>=this.getY()+60&&this.getY()+60>=enemyTank.getY()){
                                return true;
                            }
                        } else {
                            if (enemyTank.getX()<=this.getX() && enemyTank.getX()+60>=this.getX()
                                    &&enemyTank.getY()+40>=this.getY()+60&&this.getY()+60>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()<=this.getX()+40 && enemyTank.getX()+60>=this.getX()+40
                                    &&enemyTank.getY()+40>=this.getY()+60&&this.getY()+60>=enemyTank.getY()){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        //上下
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (enemyTank.getX()+40>=this.getX() && enemyTank.getX()<=this.getX()
                                    &&enemyTank.getY()+60>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()+40>=this.getX() && enemyTank.getX()<=this.getX()
                                    &&enemyTank.getY()+60>=this.getY()+40&&this.getY()+40>=enemyTank.getY()){
                                return true;
                            }
                        } else {
                            if (enemyTank.getX()<=this.getX() && enemyTank.getX()+60>=this.getX()
                                    &&enemyTank.getY()+40>=this.getY()&&this.getY()>=enemyTank.getY()){
                                return true;
                            }
                            if (enemyTank.getX()<=this.getX() && enemyTank.getX()+60>=this.getX()
                                    &&enemyTank.getY()+40>=this.getY()+40&&this.getY()+40>=enemyTank.getY()){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }
    @Override
    public void run() {
        while (true){
            if (live && bullets.size()<4){
                shot();
            }
            switch (getDirection()){
                case 0:
                    for (int i = 0; i < 20 ; i++) {
                        if(!isTouch()){
                            moveUp();
                        }
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 20 ; i++) {
                        if(!isTouch()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 20 ; i++) {
                        if(!isTouch()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 20 ; i++) {
                        if(!isTouch()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            if (!live){
                break;
            }
            setDirection((int)(Math.random()*4));
        }
    }
}
