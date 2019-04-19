import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * An object which represents the player character
 */

public class Player {

    private Image sprite;
    private float x;
    private float y;

    // Initialize player object with desired starting coordinates
    public Player(float x, float y) throws SlickException {
        sprite = new Image("assets/scout.png");
        this.x = x;
        this.y = y;
    }

    // Get x-position of player
    public float getX() {
        return x;
    }

    // Get y-position of player
    public float getY() {
        return y;
    }

    // Set x-position of player
    public void setX(float x) {
        this.x = x;
    }

    // Set y-position of player
    public void setY(float y) {
        this.y = y;
    }

    // Draw the player to the screen using current player coordinates
    public void render(float x, float y) {
        sprite.draw(x,y);
    }

    // Return true when the player is within 0.25 pixels of the given coordinates
    public boolean atPosition(float x, float y) {
        return (Math.abs(y-this.y) <= 0.25 || Math.abs(x-this.x) <= 0.25);
    }
}
