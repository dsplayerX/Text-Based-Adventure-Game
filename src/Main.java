import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System objects
        Random randNum = new Random();
        Scanner scanner = new Scanner(System.in);

        // Monster/s attributes
        String[] monsters = {"Granfaloon", "Deathclaw", "Djhin", "Leshin", "Silver Basilisk", "Lekhidna", "Kikimore", "Mendreaga",
                            "Drowner", "Tree Giant", "Nekker", "Chort", "Plague Wraith", "Bruxa", "Lesser Vampire", "Giant Centipede"};
        int maxMonsterHealth = 150;
        int monsterAD = 25;

        // Player attributes
        int healthPotMaxHeal = 40;
        int healthPotDropChance = 50; // Percentage
        Player player = new Player();
        int levelUpCounter = 0;

        boolean isRunning = true; // to stop the game on user command

        // Meeting scenarios
        String[] meetingMonster = {"As you turn to your right", "As you turn to your left", "As you turn around to check behind",
                                    "From the inside of a huge tree trunk", "From a pitch black cave", "In the blink of an eye",
                                    "Emerging from the lake in front of you", "As you were reaching the tall grass",
                                    "As you were passing a blood trail", "On the top of a black rock"};

        // Game title
        System.out.println("\n-----------------------------------------------");
        System.out.println("---------------- Monster Xlayer ---------------");
        System.out.println("-----------------------------------------------\n");
        wait(1);

        // Intro to game
        System.out.println(" # You get you gear and head towards the forest.");
        wait(3);
        System.out.println(" # You venture deep into the forest.");
        wait(2);
        System.out.println(" # Looking for monsters to slay.");
        wait(3);

        GAME:
        while(isRunning){

            String scenario = meetingMonster[randNum.nextInt(meetingMonster.length)];
            System.out.println(" # " + scenario + "... ");
            wait(1);

            int monsterHP = randNum.nextInt(maxMonsterHealth);
            String monster = monsters[randNum.nextInt(monsters.length)];
            System.out.println("\n\t## A " + monster + " has appeared! ##");
            wait(2);

            while (monsterHP > 0) {
                System.out.println("\n\tYour HP: " + player.getPlayerHP() + " \u2665️");
                System.out.println("\t" + monster + "'s HP: " + monsterHP + " \u2665");
                System.out.println("\t\tA. \u2694 Attack!");
                System.out.println("\t\tH. \u2665️ Heal");
                System.out.println("\t\tR. \uD83C\uDFC3 RUN‍️");
                System.out.print("\nWhat would you do? ");

                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("a")) {
                    int damageDealt = randNum.nextInt(player.getPlayerMaxAD());
                    int damageTaken = randNum.nextInt(monsterAD);

                    // Handling random damage dealt
                    if(damageDealt > monsterHP){
                        damageDealt = monsterHP;
                        monsterHP = 0;
                    } else {
                        monsterHP -= damageDealt;
                    }

                    // Handling random damage taken
                    if(damageTaken > player.getPlayerHP()){
                        damageTaken = player.getPlayerHP();
                        player.killPlayer();
                    } else {
                        player.takeDamage(damageTaken);
                    }

                    wait(1);
                    System.out.print("\t\t\u2694️️ ");
                    wait(1);
                    System.out.print("\t\u2694 ");
                    wait(1);
                    System.out.print("\t\u2694️️ ");
                    wait(1);

                    System.out.println("\n\t> You attack the " + monster + " for " + damageDealt + " damage.");
                    wait(1);
                    System.out.println("\t> You take " + damageTaken + " damage in return.");
                    wait(1);

                    if (!player.isPlayerAlive()) {
                        System.out.println("\t> You have taken critical damage. You are bleeding to death!");
                        wait(4);
                        break;
                    }
                } else if (userInput.equalsIgnoreCase("h")) {
                    if (player.getNumHealthPots() > 0) {
                        int healAmount = randNum.nextInt(10, healthPotMaxHeal);
                        player.useHealthPot(healAmount);

                        wait(1);
                        System.out.print("\t\t\uD83C\uDF77 ");
                        wait(1);
                        System.out.print("\t\uD83C\uDF77 ");
                        wait(1);
                        System.out.print("\t\uD83C\uDF77 ");
                        wait(1);

                        System.out.println("\n\t> You drank a health potion and healed for " + healAmount + " HP.");
                        wait(1);
                        System.out.println("\n\t> You now have " + player.getPlayerHP() + " \u2665️ HP.");
                        System.out.println("\t> You have " + player.getNumHealthPots() + " \uD83C\uDF77 health potions left.\n");
                        wait(1);
                    } else {
                        System.out.println("\t> You have no \uD83C\uDF77 health potions left! Defeat enemies for a change to get one.");
                        wait(1);
                    }
                } else if (userInput.equalsIgnoreCase("r")) {

                    wait(1);
                    System.out.print("\t\t\uD83C\uDFC3 ");
                    wait(1);
                    System.out.print("\t\uD83C\uDFC3 ");
                    wait(1);
                    System.out.print("\t\uD83C\uDFC3 ");
                    wait(1);

                    System.out.println("\n\t# You run away from the " + monster + "!");
                    wait(3);

                    System.out.println("\nC. Continue fighting");
                    System.out.println("S. Stop fighting and leave");
                    System.out.print("\nWhat would you like to do? ");

                    String runChoice = scanner.nextLine();

                    while(!runChoice.equals("c") && !runChoice.equals("s")){
                        System.out.println("Invalid command!");
                        runChoice = scanner.nextLine();
                    }

                    if(runChoice.equalsIgnoreCase("c")){
                        wait(1);
                        System.out.println("\n # You venture into another area of the dense forest.");
                        wait(2);
                        continue GAME;
                    } else {
                        wait(1);
                        System.out.println("\n # You limp out of the forest like a scaredy cat!");
                        wait(3);
                        isRunning = false;
                        continue GAME;
                    }

                } else {
                    System.out.println("Invalid command!");
                }
            }

            if(!player.isPlayerAlive()){
                System.out.println("\t> ️\uD83D\uDC80 You died! \uD83D\uDC80");
                wait(3);
                System.out.println("\t> G A M E O V E R!");
                wait(2);
                break;
            }

            wait(1);
            System.out.println("------------------------------------------------");
            System.out.println(" # " + monster + " was defeated! #");
            System.out.println("------------------------------------------------");
            wait(1);
            System.out.println(" # You have " + player.getPlayerHP() + "\u2665 HP left.");

            // Health potion drop from fallen enemies
            if (randNum.nextInt(100) < healthPotDropChance){
                int healthPotsFromMonster = randNum.nextInt(1,3);
                player.addHealthPot(healthPotsFromMonster);

                wait(1);
                System.out.println(" # The " + monster + " has dropped " + healthPotsFromMonster + " \uD83C\uDF77 health potion(s)!");
                wait(1);
                System.out.println(" # You now have " + player.getNumHealthPots() + " \uD83C\uDF77 health potion(s) left.");
                wait(1);
            }

            // Player leveling up system
            levelUpCounter += 1;
            if(levelUpCounter >= 3){ // Level up after every 3rd encounter
                levelUpCounter = 0;
                player.playerLevelUP();
                monsterAD += 5;
                maxMonsterHealth += 25;
                System.out.println();
                System.out.println(" # You just leveled up! \n # You gained HP and Max AD.");
                System.out.println(" # Your LVL: #" + player.getPlayerLVL());
                System.out.println(" # Your Max AD: " + player.getPlayerMaxAD());
                System.out.println(" # Your HP: " + player.getPlayerHP()+ "\u2665");
            }

            System.out.println("------------------------------------------------");
            System.out.println("C. Continue fighting");
            System.out.println("S. Stop fighting and leave");
            System.out.print("\nWhat would you like to do? ");

            String userChoice = scanner.nextLine();

            while(!userChoice.equals("c") && !userChoice.equals("s")){
                System.out.println("Invalid command!");
                userChoice = scanner.nextLine();
            }

            if(userChoice.equalsIgnoreCase("c")){
                wait(1);
                System.out.println("\n # You continue looking for monsters to hunt!");
                wait(2);
            } else {
                wait(1);
                System.out.println("\n # You return victorious with all the monster trophies!");
                wait(3);
                isRunning = false;
            }
        }
        System.out.println("\nThanks for playing. -dsplayerX");
        wait(3);
        System.out.println("Exiting the game...");


    }


    public static void wait(int numHalfSeconds){
        try {
            Thread.sleep(numHalfSeconds * 500L);
        } catch (InterruptedException e) {
            System.out.println("ERROR-007-wait-crash");
        }
    }
}

