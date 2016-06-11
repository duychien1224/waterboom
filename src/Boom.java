import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public class Boom {

    IBoom iBoom;
    private int positionX;
    private int positionY;
    BufferedImage image;

    public Boom(IBoom iBoom, int positionX, int positionY) {

        try {
            this.iBoom = iBoom;
            image = ImageIO.read(new File("Resources/boom.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, this.positionX, this.positionY, null);
    }

    public void update(){

    }

}
