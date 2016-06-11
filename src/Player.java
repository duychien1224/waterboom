import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public class Player implements IDropBoom {
    Boom boom;
    public int positionX;
    public int positionY;
    public int speedX;
    public int speedY;
    public BufferedImage image;

    public Player(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/png/playerquayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        this.positionX += this.speedX;
        this.positionY += this.speedY;
        if (speedX > 0) try {
            this.image = ImageIO.read(new File("Resources/png/playerquayphai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedX < 0) try {
            this.image = ImageIO.read(new File("Resources/png/playerquaytrai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY > 0) try {
            this.image = ImageIO.read(new File("Resources/png/playerquayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY < 0) try {
            this.image = ImageIO.read(new File("Resources/png/playerquaylen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
        if (boom!=null)
        boom.draw(g);
    }

    @Override
    public void dropBomb() {
        boom= Boom.getInstance(this.positionX, this.positionY+45);
    }

    @Override
    public void deleteBoom(Boom boom) {

    }
}
