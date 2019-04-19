import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * This class should be used to contain all the different objects in your game world, and schedule their interactions.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class World {
    private Player player;
    private Map map;
    private Camera camera;
    private static final double speed = 0.25;

    // Variables used to keep track of player destination
    private float targetX;
    private float targetY;

    public World() throws SlickException {
        // Initialize map
        map = new Map();

        // Initialize player in centre of map
        float initialPositionY = map.getHeight() / 2;
        float initialPositionX = map.getWidth() / 2;

        player = new Player(initialPositionX, initialPositionY);
        targetX = initialPositionX;
        targetY = initialPositionY;

        // Initialize player camera
        camera = new Camera(map,player);
    }

    public void update(Input input, int delta) {
        // Get target
        if (input.isMousePressed(1)) {
            targetX = input.getMouseX()+camera.getLeft();
            targetY = input.getMouseY()+camera.getTop();
        }
        // If player has not reached the target ...
        if (!player.atPosition(targetX,targetY)) {
            // Calculate speed to approach target
            double angle = Math.atan2(targetY-player.getY(),targetX-player.getX());
            double xSpeed = Math.cos(angle)*speed;
            double ySpeed = Math.sin(angle)*speed;

            // Check if the next coordinates will be within a solid tile
            float nextX = (float)(player.getX()+delta*xSpeed);
            float nextY = (float)(player.getY()+delta*ySpeed);
            // If solid, stop moving
            if (map.isSolidTile(nextX,nextY)) {
                targetX = player.getX();
                targetY = player.getY();
            }
            // Or else move into next coordinate
            else {
                player.setX(nextX);
                player.setY(nextY);
            }
        }
    }
	
    public void render(Graphics g) {
        map.render(camera);
        camera.drawPlayer();
    }
}
