import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public abstract class Character {
    public int positionX;
    public int positionY;
    public int speedX;
    public int speedY;
    public BufferedImage image;
    String pathImage;

    public Character(int positionX, int positionY, String pathImage) {
        this.pathImage = pathImage;
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/png/" + pathImage + "quayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() throws InterruptedException {
        this.positionX += this.speedX;
        this.positionY += this.speedY;
        if (speedX > 0) try {
            this.image = ImageIO.read(new File("Resources/png/" + pathImage + "quayphai.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedX < 0) try {
            this.image = ImageIO.read(new File("Resources/png/" + pathImage + "quaytrai.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY > 0) try {
            this.image = ImageIO.read(new File("Resources/png/" + pathImage + "quayxuong.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY < 0) try {
            this.image = ImageIO.read(new File("Resources/png/" + pathImage + "quaylen.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void draw(Graphics g);

    public abstract Boom dropBoom();

}


