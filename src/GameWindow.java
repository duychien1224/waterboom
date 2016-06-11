import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    Player player1;
    House house;
    Tree[] ArrayTree= new Tree[10];
    Brick[] ArrayBrick = new Brick[10];
    public GameWindow() {// constructor
        this.setSize(750, 650);
        this.setTitle("Boom-Techkids");
        this.setVisible(true);
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
        player1 = new Player(300,400);
        house = new House(200, 200, "Resources/png/house.png");
        ArrayTree[1] = new Tree(200, 500, "Resources/png/tree.png");
        ArrayBrick[1] = new Brick(400, 200, "Resources/png/brick.png");
        ArrayBrick[2] = new Brick(400, 290, "Resources/png/brick.png");
        ArrayBrick[3] = new Brick(400, 400, "Resources/png/brick.png");
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //vua an phim
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //phim duoc an va giu
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        player1.speedY = -3;
                        break;
                    case KeyEvent.VK_LEFT:
                        player1.speedX = -3;
                        break;
                    case KeyEvent.VK_DOWN:
                        player1.speedY = 3;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player1.speedX = 3;
                        break;
                    case KeyEvent.VK_SPACE:
                        player1.dropBomb();
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //tha phim ra
                player1.speedX = 0;
                player1.speedY = 0;
            }
        });// catch key and move
        try {
            background = ImageIO.read(new File("Resources/png/background.png"));// set background
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gameUpdate() {
        player1.update();
    }

    @Override
    public void update(Graphics g) {
        if(bufferedImage == null){
            bufferedImage = new BufferedImage(750, 650, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        player1.draw(bufferedGraphics);// draw player1
        house.draw(bufferedGraphics);
        ArrayBrick[1].draw(bufferedGraphics);
        ArrayBrick[2].draw(bufferedGraphics);
        ArrayBrick[3].draw(bufferedGraphics);
        ArrayTree[1].draw(bufferedGraphics);
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

