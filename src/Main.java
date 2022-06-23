import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        Enemy[] enemies = new Enemy[5];

        newEnemy(enemies, rand, 2);
        System.out.println(enemies[2].getEnemyHP());
        System.out.println(enemies[2].getEnemyAD());





    }

    public static void newEnemy(Enemy[] enemies, Random rand, int enemyID){
        enemies[enemyID] = new Enemy();
        enemies[enemyID].setEnemyHP(rand.nextInt(50, 150));
        enemies[enemyID].setEnemyAD(rand.nextInt(10,30));
    }




    public static void wait(int numSeconds){
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
        }
    }
}

