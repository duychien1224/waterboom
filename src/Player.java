import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 6/11/2016.
 */
public class Player implements IFighter {
    public int positionX;
    public int positionY;
    public int speedX;
    public int speedY;
    public BufferedImage image;

    public ArrayList<Boom> listBooms;

    public Player(int positionX, int positionY)  {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/playerquayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Player() {
        this.positionX = 350;
        this.positionY = 300;
        try {
            this.image = ImageIO.read(new File("Resources/playerquayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        this.positionX += this.speedX;
        this.positionY += this.speedY;
        if (speedX>0) try {
            this.image = ImageIO.read(new File("Resources/playerquayphai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedX<0) try {
            this.image = ImageIO.read(new File("Resources/playerquaytrai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY>0) try {
            this.image = ImageIO.read(new File("Resources/playerquayxuong.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (speedY<0) try {
            this.image = ImageIO.read(new File("Resources/playerquaylen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        g.drawImage(this.image, this.positionX, this.positionY, null);
    }

    @Override
    public void fire() {
        listBooms.add(new Boom(positionX,positionY));
    }
}
