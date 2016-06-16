import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 6/16/2016.
 */
public class ExplosiveBarrier extends Barrier implements IObsever {
    public ExplosiveBarrier(int positionX, int positionY, String pathImage) {
        super(positionX, positionY, pathImage);
    }

    @Override
    public void explosive() throws IOException, InterruptedException {
        this.image = ImageIO.read(new File("Resources/png/khoi.png"));
    }
}
