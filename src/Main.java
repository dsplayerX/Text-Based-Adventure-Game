import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects
        Random randNum = new Random();
        Scanner scanner = new Scanner(System.in);

        // Monsters
        String[] monsters = {"Gargoyle", "Siren Spirit", "Giant Spider", "Leshin", "Botchered"};
        int maxMonsterHealth = 100;
        int monsterAD = 25;

        // Player
        int healthPotMaxHeal = 40;
        int healthPotDropChance = 50; // Percentage
        Player player = new Player();

        boolean isRunning = true;

        System.out.println("\n-----------------------------------------------");
        System.out.println("------------ Witcher Monster Hunt -------------");
        System.out.println("-----------------------------------------------\n");
        wait(1);

        // Intro
        System.out.println(" # You venture deep into the forest. #");
        wait(2);

        GAME:
        while(isRunning){

            int monsterHP = randNum.nextInt(maxMonsterHealth);
            String monster = monsters[randNum.nextInt(monsters.length)];
            System.out.println("\n\t# A " + monster + " has appeared! #");

            while (monsterHP > 0) {
                System.out.println("\n\tYour HP: " + player.getPlayerHP());
                System.out.println("\t" + monster + "'s HP: " + monsterHP);
                System.out.println("\t\tA. Attack!");
                System.out.println("\t\tH. Heal.");
                System.out.println("\t\tR. RUN");
                System.out.println("\nWhat would you do? ");

                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("a")) {
                    int damageDealt = randNum.nextInt(player.getPlayerAD());
                    int damageTaken = randNum.nextInt(monsterAD);

                    monsterHP -= damageDealt;
                    player.takeDamage(damageTaken);
                    wait(1);
                    System.out.println("\t> You attack the " + monster + " for " + damageDealt + " damage.");
                    wait(2);
                    System.out.println("\t> You take " + damageTaken + " damage in return.");
                    wait(1);

                    if (!player.isPlayerAlive()) {
                        System.out.println("\t> You have taken critical damage. You are bleeding to death!!");
                        wait(2);
                        break;
                    }
                } else if (userInput.equalsIgnoreCase("h")) {
                    if (player.getNumHealthPots() > 0) {
                        int healAmount = randNum.nextInt(10, healthPotMaxHeal);
                        player.useHealthPot(healAmount);
                        System.out.println("\t> You drank a health potion and healed for " + healAmount + " HP.");
                        wait(1);
                        System.out.println("\n\t> You now have " + player.getPlayerHP() + " HP.");
                        System.out.println("\t> You have " + player.getNumHealthPots() + " health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a change to get one.");
                    }
                } else if (userInput.equalsIgnoreCase("r")) {
                    System.out.println("\tYou run away from the " + monster + "!");
                    wait(1);
                    continue GAME;
                } else {
                    System.out.println("Invalid command!");
                }
            }

            if(!player.isPlayerAlive()){
                System.out.println("\t> You died!!");
                wait(1);
                System.out.println("\t> GAME OVER!");
                wait(1);
                break;
            }

            wait(1);
            System.out.println("------------------------------------------------");
            System.out.println(" # " + monster + " was defeated! #");
            System.out.println();
            wait(1);
            System.out.println(" # You have " + player.getPlayerHP() + " HP left.");
            if (randNum.nextInt(100) < healthPotDropChance){
                wait(1);
                System.out.println(" # The " + monster + " has dropped a health potion! #");
                player.addHealthPot();
                wait(1);
                System.out.println(" # You now have " + player.getNumHealthPots() + " health potion(s) left. # ");
                wait(1);
            }
            System.out.println("------------------------------------------------");
            System.out.println("C. Continue fighting");
            System.out.println("S. Stop fighting and leave");
            System.out.println("What would you like to do?");

            String userChoice = scanner.nextLine();

            while(!userChoice.equals("c") && !userChoice.equals("s")){
                System.out.println("Invalid command!");
                userChoice = scanner.nextLine();
            }

            if(userChoice.equalsIgnoreCase("c")){
                System.out.println(" # You continue looking for monsters to hunt! #");
                wait(2);
            } else {
                System.out.println(" # You stop monster hunting for now and leave! #");
                wait(2);
                isRunning = false;
            }
        }

        System.out.println("Thanks for playing!");

    }


    public static void wait(int numSeconds){
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
        }
    }
}

