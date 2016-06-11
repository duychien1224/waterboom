import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public class Boom implements subjectBomb {
    private static Boom instance;
     BufferedImage image;
    private int positionX;
    private int positionY;

    private Boom(int positionX, int positionY) {

        try {
            image = ImageIO.read(new File("Resources/png/boom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public static Boom getInstance(int x, int y){
        if (instance==null){
            instance = new Boom(x, y);
        }
        return instance;

    }
    public void draw(Graphics g) {
        g.drawImage(image, this.positionX, this.positionY, null);
    }

    public void update() {
    // do somthing here :)) later
    }

    @Override
    public void registerBomb() {

    }

    @Override
    public void cancelBomb() {

    }

    @Override
    public void notifyBomb() {

    }
}
