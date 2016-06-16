import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 6/13/2016.
 */
public abstract class Boom implements ISubject {
    public int positionX;
    public int positionY;
    public BufferedImage image;

    ArrayList<IObsever> iObsevers;
    public Boom(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/png/boom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        iObsevers = new ArrayList<IObsever>();
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
    }

    @Override
    public void register(IObsever iObsever) {
        iObsevers.add(iObsever);
    }

    @Override
    public void cancel(IObsever iObsever) {
        iObsevers.remove(iObsevers);
    }

    @Override
    public void notifyBarrier() throws IOException, InterruptedException {
        for (IObsever iObsever : iObsevers) {
            iObsever.explosive();// denpend on object, will create appropriate method inside ExplosiveBarrier class


        }

    }
}
