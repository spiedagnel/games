import java.util.*;

/**
 * Save humans, destroy zombies!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            GameState gameState = new GameState();
            int x = in.nextInt();
            int y = in.nextInt();
            gameState.setAsh(new Coordinate(x,y));
            int humanCount = in.nextInt();
            for (int i = 0; i < humanCount; i++) {
                int humanId = in.nextInt();
                int humanX = in.nextInt();
                int humanY = in.nextInt();
                gameState.getHumans().add(new Coordinate(humanX,humanY));
            }
            int zombieCount = in.nextInt();
            for (int i = 0; i < zombieCount; i++) {
                int zombieId = in.nextInt();
                int zombieX = in.nextInt();
                int zombieY = in.nextInt();
                int zombieXNext = in.nextInt();
                int zombieYNext = in.nextInt();
                gameState.getZombies().add(new Coordinate(zombieXNext,zombieYNext));
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            Coordinate c = gameState.getAsh().closestTo(gameState.getZombies());
            System.out.println(c.getX()+ " "+ c.getY()); // Your destination coordinates
        }
    }
}

class Coordinate{
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance2(Coordinate other){
        return Math.pow((this.x - other.x),2) + Math.pow((this.y - other.y),2);
    }

    Coordinate closestTo(List<Coordinate> others){
        return others.stream().min( (a,b)-> (int) (this.distance2(a) - this.distance2(b))).get();
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

class GameState{
    private List<Coordinate> humans = new ArrayList<>();
    private List<Coordinate> zombies = new ArrayList<>();
    private Coordinate ash;

    GameState() {}

    public GameState(List<Coordinate> humans, List<Coordinate> zombies, Coordinate ash) {
        this.humans = humans;
        this.zombies = zombies;
        this.ash = ash;
    }

    List<Coordinate> getHumans() {
        return humans;
    }

    public void setHumans(List<Coordinate> humans) {
        this.humans = humans;
    }

    List<Coordinate> getZombies() {
        return zombies;
    }

    public void setZombies(List<Coordinate> zombies) {
        this.zombies = zombies;
    }

    Coordinate getAsh() {
        return ash;
    }

    void setAsh(Coordinate ash) {
        this.ash = ash;
    }
}