import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 6/11/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    BufferedImage bufferedImage;

    public GameWindow() throws IOException {// constructor
        this.setSize(750,750);
        this.setTitle("Boom-Techkids");
        this.setVisible(true);
        background = ImageIO.read(new File("Resources/background.jpg"));
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });// closing window
    }

    public void gameUpdate() {
        // do something here before repaint method reDraw components
        System.out.println("Thay doi cac thuoc tinh cua doi tuong trươc ve lai");
    }

    @Override
    public void update(Graphics g) {
        if(bufferedImage == null){
            bufferedImage = new BufferedImage(750, 750, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        g.drawImage(bufferedImage, 0, 0,null);

    }

    @Override
    public void run() {
        // muon chay cai gi phai dat o day
        while (true) {
            try {

                Thread.sleep(17);
                gameUpdate();
                repaint();// this method will invoke update method above which is overided
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

