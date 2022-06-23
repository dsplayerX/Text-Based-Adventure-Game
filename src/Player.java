public class Player {
    private int playerHP;
    private int playerAD;
    private int numHealthPots;

    public Player(){
        this.playerHP = 100;
        this.playerAD = 50;
        this.numHealthPots = 3;
    }

    public int getPlayerHP(){
        return playerHP;
    }

    public int getPlayerAD(){
        return playerAD;
    }

    public int getNumHealthPots(){
        return numHealthPots;
    }

    public void addHealthPot(){
        this.numHealthPots += 1;
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

}
