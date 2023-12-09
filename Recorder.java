package com.坦克大战;

import com.坦克大战.Tank.EnemyTank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * @author ZhunJunHua
 * #Description 1.0
 * #Date: 2023.11.25
 * 该类记录游戏数据
 */
public class Recorder {
    //击毁坦克数量
    private static int Num = 0;
    private static BufferedWriter bufferedWriter = null;
    private static String FilePath = "D://Records.txt";
    private static Vector<EnemyTank>enemyTanks = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void keepRecords() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(FilePath));
        bufferedWriter.write(Num + "\r\n");
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.live){
                String records = enemyTank.getX() + " " +enemyTank.getY() + " " + enemyTank.getDirection();
                bufferedWriter.write(records + "\r\n");
            }
        }
        if (bufferedWriter != null){
            bufferedWriter.close();
        }
    }

    public static int getNum() {
        return Num;
    }

    public static void setNum(int num) {
        Num = num;
    }

    public static int addNum(){
        return Num++;
    }
}
