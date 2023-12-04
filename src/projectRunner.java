import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class projectRunner {
    Scanner myScanner = new Scanner(System.in);

    int players;
    int action;

    Floors floor = new Floors(0);

    boolean answer = false;
    boolean gameRunning = true;
    Player player1 = new Player();

    public void runGame() throws InterruptedException {
        System.out.print("Single player or 2 players?(1 or 2): ");
        players = myScanner.nextInt();
        while (!answer) {
            if (players == 1) {
                System.out.println("Single player it is then");
                answer = true;
            } else if (players == 2) {
                System.out.println("This game is single player only, sorry!");
                answer = true;
            } else {
                System.out.print("Invalid number, please try again: ");
                players = myScanner.nextInt();
            }
        }
        myScanner.nextLine();

        System.out.print("What do you call yourself?: ");
        player1.setName(myScanner.nextLine());
        System.out.println("Player 1: " + player1.name);


        for(int i = 0; i <= 3; i++) {
            System.out.println("Loading...");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println();

        int moves = 1;
        boolean inRound = false;
        Enemy enemy = new Enemy(floor);
        Enemy boss = new Enemy(floor);

        while (gameRunning) {
            if (inRound) {
                if ((moves == 5) || (player1.health <= 0)) {
                    gameRunning = false;
                } else {
                    System.out.print("Pick action: 1.Attack, 2. Guard, 3. Heal:  ");
                    action = myScanner.nextInt();
                    player1.action(action);
                    Thread.sleep(500);
                    if (action == 1) {
                        enemy.attacked(player1.attack());
                    }
                    moves++;
                    Thread.sleep(500);
                    if (enemy.isDead()) {
                        inRound = false;
                    }
                    if (floor.getFloor()%5 == 0) {
                        if (boss.isDead()) {
                            inRound = false;
                        }
                    }
                    if (floor.getFloor()%5 == 0) {
                        player1.attacked(boss.attack());
                        System.out.println(player1.name + " health: " + player1.getHealth());
                        System.out.println("");
                        Thread.sleep(500);
                    } else {
                        player1.attacked(enemy.attack());
                        System.out.println(player1.name + " health: " + player1.getHealth());
                        System.out.println("");
                        Thread.sleep(500);
                    }


                }
            } else {
                floor.addFloor();
                System.out.println("Moving to floor " + floor.getFloor() + "\n");

                moves = 0;
                if (floor.getFloor()%5 == 0) {
                    System.out.print("Welcome to the shop, what upgrade do you want to purchase?: 1 - +2 attack multiplier, 2 - +10 hp: ");
                    int answer = myScanner.nextInt();
                    if (answer == 1) {
                        player1.DamageBuff(2);
                    } else if (answer == 2) {
                        player1.healthBuff(10);
                    }
                    System.out.println("Looks like your done shopping, move on to the next floor");
                    System.out.println("");
                }
                inRound = true;
                enemy.standard();
                if (floor.getFloor()%5 == 0) {
                    boss.boss();
                }
            }
        }

        System.out.println("You got to floor " + floor.getFloor());



    }

}
