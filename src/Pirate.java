import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 6/15/2016.
 */
public class Pirate extends Character {
    ArrayList<BoomPirate> boomPirates;
    public Pirate(int positionX, int positionY, String pathImage) {
        super(positionX, positionY, pathImage);
        boomPirates = new ArrayList<BoomPirate>();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
        for (BoomPirate boomPirate : boomPirates) {
            boomPirate.draw(g);
        }
    }

    @Override
    public BoomPirate dropBoom() {
        BoomPirate boomPirate = new BoomPirate(this.positionX, this.positionY);
        boomPirates.add(boomPirate);
        return  boomPirate;

    }
}
