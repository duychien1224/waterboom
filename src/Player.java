import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public class Player {
    public int positionX;
    public int positionY;
    public int speedX;
    public int speedY;
    public BufferedImage image;

    public Player(int positionX, int positionY)  {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/p474.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Player() {
        this.positionX = 350;
        this.positionY = 300;
        try {
            this.image = ImageIO.read(new File("Resources/p474.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }
    public void draw(Graphics g){
        g.drawImage(this.image, this.positionX, this.positionY, null);
    }
}
