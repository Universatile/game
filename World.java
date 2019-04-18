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
    private float playerDestinationX;
    private float playerDestinationY;

    public World() throws SlickException {
        // Initialize map
        map = new Map();

        // Initialize player in centre of map
        float initialPositionY = map.getHeight() / 2;
        float initialPositionX = map.getWidth() / 2;

        // Initialize player and player position
        player = new Player(initialPositionX, initialPositionY);
        playerDestinationX = initialPositionX;
        playerDestinationY = initialPositionY;

        // Initialize player camera
        camera = new Camera(map,player);
    }

    public void update(Input input, int delta) {
        if (input.isMousePressed(0)) {
            playerDestinationX = input.getMouseX()+camera.getLeft();
            playerDestinationY = input.getMouseY()+camera.getTop();
        }
        if (map.isSolidTile(player.getX(), player.getY())) {
            playerDestinationX = player.getX();
            playerDestinationY = player.getY();
        }
        if (!player.atPosition(playerDestinationX,playerDestinationY)) {
            player.moveTo(playerDestinationX,playerDestinationY,delta,World.speed);
        }
	}
	
    public void render(Graphics g) {
        map.render(camera);
        camera.drawPlayer();
    }
}
