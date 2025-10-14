package coconuts;

import javafx.scene.image.Image;

// Represents the beam of light moving from the crab to a coconut; can hit only falling objects
// This is a domain class; do not introduce JavaFX or other GUI components here
public class LaserBeam extends IslandObject {
    private static final int WIDTH = 20; // must be updated with image
    private static final Image laserImage = new Image("file:images/laser-1.png");

    public LaserBeam(OhCoconutsGameManager game, int eyeHeight, int crabCenterX) {
        super(game, crabCenterX, eyeHeight, WIDTH, laserImage);
        System.out.println("laserImage: " + laserImage);
    }

    public int hittable_height() {
        return y;
    }

    @Override
    public boolean isTouching(IslandObject other) {
        return y == other.y && x == other.x;
    }

    @Override
    public boolean canHit(IslandObject other) {
        return other instanceof Coconut;
    }

    @Override
    public void step() {
        y -= 3;
    }
}
