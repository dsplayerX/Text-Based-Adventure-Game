public class Enemy {
    private String enemyName;
    private int enemyHP;
    private int enemyAD;

    public Enemy(){

    }

    public int getEnemyHP(){
        return enemyHP;
    }

    public int getEnemyAD(){
        return enemyAD;
    }

    public void setEnemyHP(int newHP){
        enemyHP = newHP;
    }

    public void setEnemyAD(int newAD){
        enemyAD = newAD;
    }
}
