public class Player {
    private int playerLVL;
    private int playerHP;
    private int playerMaxAD;
    private int numHealthPots;

    public Player(){
        this.playerLVL = 1;
        this.playerHP = 100;
        this.playerMaxAD = 50;
        this.numHealthPots = 3;
    }

    public int getPlayerHP(){
        return playerHP;
    }

    public int getPlayerMaxAD(){
        return playerMaxAD;
    }

    public int getNumHealthPots(){
        return numHealthPots;
    }

    public int getPlayerLVL(){
        return playerLVL;
    }

    public void addHealthPot(int droppedHealthPots){
        this.numHealthPots += droppedHealthPots;
    }

    public void takeDamage(int damageAmount){
        this.playerHP -= damageAmount;
    }

    public void useHealthPot(int healAmount){
        this.playerHP += healAmount;
        this.numHealthPots -= 1;
    }

    public boolean isPlayerAlive(){
        return playerHP > 0;
    }

    public void playerLevelUP(){
        this.playerHP += 20;
        this.playerMaxAD += 15;
        this.playerLVL += 1;
    }

}
