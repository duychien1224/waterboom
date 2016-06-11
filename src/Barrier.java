import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 6/11/2016.
 */
public abstract class Barrier {
    public int posX;
    public int posY;
    public BufferedImage image;
    String pathImage;
    public Barrier(int posX, int posY,String pathImage) {
        this.posX = posX;
        this.posY = posY;
        try {
            this.image = ImageIO.read(new File(pathImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics g) {
        g.drawImage(image, this.posX, this.posY, null);
    }
}
