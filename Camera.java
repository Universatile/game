
/**
 * This class restricts the game's view to a subset of the entire world.
 */
public class Camera {
    private Map map;
    private Player player;

    public Camera(Map map, Player player) {
        this.map = map;
        this.player = player;
    }
	public float getLeft() {
        float left = player.getX()-App.WINDOW_WIDTH/2;
		if (left < 0) return 0;
		else if (getRight()==map.getWidth()) {
		    return map.getWidth()-App.WINDOW_WIDTH;
        }
		else return left;
	}
	public float getTop() {
        float top = player.getY()-App.WINDOW_HEIGHT/2;
        if (top < 0) return 0;
        else if (getBottom()==map.getHeight()) {
            return map.getHeight()-App.WINDOW_HEIGHT;
        }
        else return top;
	}
	public float getRight() {
        float right = player.getX()+App.WINDOW_WIDTH/2;
        if (right > map.getWidth()) {
            return map.getWidth();
        }
        return right;
	}
	public float getBottom() {
        float bottom = player.getY()+App.WINDOW_HEIGHT/2;
        if (bottom > map.getHeight()) {
            return map.getHeight();
        }
        return bottom;
	}
	public void drawPlayer() {
        float x = App.WINDOW_WIDTH/2;
        float y = App.WINDOW_HEIGHT/2;
        if (getLeft() == 0) x = player.getX();
        if (getTop() == 0) y = player.getY();
        if (getRight() == map.getWidth()) {
            x = player.getX()+App.WINDOW_WIDTH-map.getWidth();
        }
        if (getBottom() == map.getHeight()) {
            y = player.getY()+App.WINDOW_HEIGHT-map.getHeight();
        }
        player.render(x,y);
    }
}
