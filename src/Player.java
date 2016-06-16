import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 6/15/2016.
 */
public class Player extends Character {
    ArrayList<BoomPlayer> boomPlayers;

    public Player(int positionX, int positionY, String pathImage) {
        super(positionX, positionY, pathImage);
        boomPlayers = new ArrayList<BoomPlayer>();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
        for (BoomPlayer boomPlayer : boomPlayers) {
            boomPlayer.draw(g);
        }
    }

    @Override
    public BoomPlayer dropBoom() {
        BoomPlayer boomPlayer = new BoomPlayer(this.positionX, this.positionY);
        boomPlayers.add(boomPlayer);
        return  boomPlayer;
    }
}
