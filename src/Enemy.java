public class Enemy {
    private Floors floor;
    double damage;
    boolean boss;

    int enemyHealth;

    public Enemy(Floors floors) {
        floor = floors;
    }

    public Enemy (Floors floors, boolean boss) {
        floor = floors;
        this.boss = boss;
    }


    public void standard() {
        enemyHealth = 10 + (2 * floor.getFloor() );
        damage = 1 + (0.5 * floor.getFloor());
    }

    public void boss() {
        enemyHealth = 50 + (int) (1.2 * floor.getFloor());
        damage = 5 + (2 * floor.getFloor());
    }

    public int attack() {
        return (int)(damage);
    }

    public void attacked(int damage) {
        enemyHealth = enemyHealth - damage;
        System.out.println("Enemy attacked for " + damage + " damage");
        System.out.println("Enemy health remaining: " + enemyHealth);
    }

    public boolean isDead () {
        return enemyHealth <= 0;
    }



}
