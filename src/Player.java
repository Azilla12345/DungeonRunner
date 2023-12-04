/**
 * This class is the player's class
 *
 * @author Hayden Mak
 * @author Ryan Chan
 */

public class Player {
    /** The health of the player */
    int health;
    /** whether the players guard is up */
    boolean guardUp;

    /** the player's name */
    String name;
    /** the player's damage*/
    int damage;
    int damageBuff;


    /**
     * Instantiates a player object
     */
    public Player() {
        name = "";
        health = 100;
        guardUp = false;
        damageBuff = 0;
    }

    private Player (String name) {
        this.name = name;
        health = 100;
        guardUp = false;

    }


    /**
     * Sets the players name
     * @param name name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the players health
     * @return health
     */

    public int getHealth() {
        return health;
    }

    /**
     * Player's attack
     * @return attack
     */
    public int attack() {
        damage = (int)(Math.random() * (11 + damageBuff)) + 1;
        return damage;
    }

    public void heal() {
        health += 5;
        System.out.println("Heal up 5 health points");
    }

    /**
     * Set's the guardUp as a true
     */
    public void guard() {
        guardUp = true;
    }

    /**
     * Attacks if action is 1, guards if action is 2
     * @param action
     */
    public void action(int action) {
        if (action == 1) {
            attack();
            System.out.println(name + " attacks for " + damage + " damage");
        } else if (action == 2) {
            guard();
        } else if (action ==3){
            heal();
        } else {
            System.out.println("Invalid action!");
        }
    }

    public void healthBuff(int upgrade) {
        health += upgrade;
    }

    public void DamageBuff(int upgrade) {
        damageBuff += upgrade;
    }

    /**
     * If guard is up, attack gets blocked, otherwise the player loses "damage" worth of health points
     * @param damage
     */
    public void attacked(int damage) {
        if (guardUp) {
            System.out.println("Attack was blocked!");
            guardUp = false;
        } else {
            health -= damage;
            System.out.println("Attacked with " + damage + " damage!");
        }
    }

}