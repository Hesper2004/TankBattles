package com.坦克大战.Tank;


import com.坦克大战.AePlayWave;
import com.坦克大战.Recorder;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener ,Runnable{
    public MyTank myTank = null;
    Vector<EnemyTank>enemyTanks = new Vector<>();
    Vector<Bomb>bombs = new Vector<>();
    private int enemyTankSize(){
        return enemyTanks.size();
    }
    //爆炸图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel() {
        Recorder.setEnemyTanks(enemyTanks);
        this.myTank = new MyTank(500,100);//初始化坦克
        this.myTank.setSpeed(2);
        //初始化敌人坦克
        for(int i=0;i<3;i++){
            EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 0, 2);
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            new Thread(enemyTank).start();
            enemyTank.bullets.add(bullet);
            new Thread(bullet).start();
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTanks.add(enemyTank);
        }
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/th.jpg"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/OIP-C.jpg"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/C.jpg"));
        new AePlayWave("D://1.wav").start();
    }
    //展示数据
    public void showInfo(Graphics g){
        g.setColor(Color.cyan);
        Font font = new Font("宋体", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("击毁坦克数量：" + Recorder.getNum(),800,20);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        showInfo(g);
        //画自己的坦克
        if(myTank!= null &&myTank.live){
            TankPanel(myTank.getX(),myTank.getY(),myTank.getDirection(),0,g);
            for (int i = 0; i < myTank.bullets.size(); i++) {
                Bullet bullet = myTank.bullets.get(i);
                if (bullet != null && bullet.isLive() == true) {
                    g.draw3DRect(bullet.x, bullet.y, 2, 2, false);
                } else {
                    myTank.bullets.remove(bullet);
                }
            }
        }
        //画敌人的坦克
        for (int i = 0; i < enemyTankSize(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank !=null && enemyTank.live) {
                TankPanel(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirection(), 1, g);
                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive()) {
                        g.draw3DRect(bullet.x, bullet.y, 2, 2, false);
                    } else {
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if(bomb.live>6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            } else if(bomb.live>3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            } else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            if(bomb.isLive == false){
                bombs.remove(bomb);
            }
        }
    }
    //画坦克方法
    @Test
    public void TankPanel(int x, int y, int direction, int type, Graphics g){
            switch (type){
                case 0://我的坦克
                    g.setColor(Color.cyan);
                    break;
                case 1://敌人坦克
                    g.setColor(Color.blue);
                    break;
            }
            switch (direction){
                case 0://表示向上
                    g.fill3DRect(x,y,10,60,false);
                    g.fill3DRect(x+30,y,10,60,false);
                    g.fill3DRect(x+10,y+10,20,40,false);
                    g.fillOval(x+10,y+20,20,20);
                    g.drawLine(x+20,y+30,x+20,y);
                    break;
                case 1://表示向右
                    g.fill3DRect(x,y,60,10,false);
                    g.fill3DRect(x,y+30,60,10,false);
                    g.fill3DRect(x+10,y+10,40,20,false);
                    g.fillOval(x+20,y+10,20,20);
                    g.drawLine(x+30,y+20,x+60,y+20);
                    break;
                    case 2://表示向下
                    g.fill3DRect(x,y,10,60,false);
                    g.fill3DRect(x+30,y,10,60,false);
                    g.fill3DRect(x+10,y+10,20,40,false);
                    g.fillOval(x+10,y+20,20,20);
                    g.drawLine(x+20,y+30,x+20,y+60);
                    break;
                case 3://表示向左
                    g.fill3DRect(x,y,60,10,false);
                    g.fill3DRect(x,y+30,60,10,false);
                    g.fill3DRect(x+10,y+10,40,20,false);
                    g.fillOval(x+20,y+10,20,20);
                    g.drawLine(x+30,y+20,x,y+20);
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
    public void hit(Tank enemyTank,Tank myTank){
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if(bullet == null || !bullet.isLive()){
                continue;
            }
            switch (enemyTank.getDirection()){
                case 0:
                case 2:
                    if(bullet.x>enemyTank.getX()&& bullet.x<enemyTank.getX()+40
                    && bullet.y>enemyTank.getY() && bullet.y<enemyTank.getY()+60){
                        bullet.setLive(false);
                        if(enemyTank instanceof EnemyTank){
                            enemyTanks.remove(enemyTank);
                            Recorder.addNum();
                        } else if(enemyTank instanceof MyTank && !enemyTank.live){
                            break;
                        }
                        enemyTank.live = false;
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }
                    break;
                case 1:
                case 3:
                    if(bullet.x>enemyTank.getX()&& bullet.x<enemyTank.getX()+60
                            && bullet.y>enemyTank.getY() && bullet.y<enemyTank.getY()+40){
                        bullet.setLive(false);
                        if (enemyTank instanceof EnemyTank){
                            enemyTanks.remove(enemyTank);
                            Recorder.addNum();
                        } else if(enemyTank instanceof MyTank && !enemyTank.live){
                            break;
                        }
                        enemyTank.live = false;
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }
                    break;
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            myTank.setDirection(0);
            myTank.moveUp();
        } else if(e.getKeyCode() == KeyEvent.VK_S){
            myTank.setDirection(2);
            myTank.moveDown();
        } else if(e.getKeyCode() == KeyEvent.VK_D){
            myTank.setDirection(1);
            myTank.moveRight();
        } else if(e.getKeyCode() == KeyEvent.VK_A){
            myTank.setDirection(3);
            myTank.moveLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_J && myTank.live){
            //if(myTank.bullet == null || !myTank.bullet.isLive()) {
                myTank.shot();
            //}
        }
        this.repaint();//重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                for (int i = 0; i < enemyTankSize(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hit(enemyTank,myTank);
                    hit(myTank,enemyTank);
                }
            this.repaint();
        }
    }
}
