package Scripts.Entities;

import Scripts.Graphics.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class Player extends Humanoid
{
    // ======================
    // Variables
    // ======================

    private BufferedImage playerImage;
    final private int imageWidth = 64;
    final private int imageHeight = 64;

    // Animation system
    private Animation idleUp;
    private Animation idleDown;
    private Animation idleLeft;
    private Animation idleRight;

    private Animation currentAnimation;

    private BufferedImage playerSheet;

    // ======================
    // Constructors
    // ======================

    public Player(BufferedImage playerImage,String name , int health , float speed , float posX, float posY)
    {
        super(name,health,speed,posX,posY);
        init();
    }

    public Player()
    {
        super();
        init();
    }

    // ======================
    // Init
    // ======================

    private void init()
    {
        try
        {
            playerSheet = ImageIO.read(new File("src/Assets/Player/IdlePlayer.png"));

            IdleUp();
            IdleLeft();
            IdleDown();
            IdleRight();

            currentAnimation = idleDown; // default
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ======================
    // Update
    // ======================

    public void update()
    {
        switch(current_directionState)
        {
            case up:
                currentAnimation = idleUp;
                break;

            case left:
                currentAnimation = idleLeft;
                break;

            case down:
                currentAnimation = idleDown;
                break;

            case right:
                currentAnimation = idleRight;
                break;
        }

        currentAnimation.update();
    }

    // ======================
    // Paint
    // ======================

    public void paintPlayer(Graphics g)
    {
        playerImage = currentAnimation.getFrame();

        g.drawImage(
                playerImage,
                (int)posX,
                (int)posY,
                imageWidth,
                imageHeight,
                null
        );
    }

    // ======================
    // Animations
    // ======================

    private void IdleUp()
    {
        int frameWidth = playerSheet.getWidth() / 2;
        int frameHeight = playerSheet.getHeight() / 4;

        int row = 0;

        BufferedImage[] frames = new BufferedImage[2];

        frames[0] = playerSheet.getSubimage(0, row * frameHeight, frameWidth, frameHeight);
        frames[1] = playerSheet.getSubimage(frameWidth, row * frameHeight, frameWidth, frameHeight);

        idleUp = new Animation(frames, 22);
    }

    private void IdleLeft()
    {
        int frameWidth = playerSheet.getWidth() / 2;
        int frameHeight = playerSheet.getHeight() / 4;

        int row = 1;

        BufferedImage[] frames = new BufferedImage[2];

        frames[0] = playerSheet.getSubimage(0, row * frameHeight, frameWidth, frameHeight);
        frames[1] = playerSheet.getSubimage(frameWidth, row * frameHeight, frameWidth, frameHeight);

        idleLeft = new Animation(frames, 22);
    }

    private void IdleDown()
    {
        int frameWidth = playerSheet.getWidth() / 2;
        int frameHeight = playerSheet.getHeight() / 4;

        int row = 2;

        BufferedImage[] frames = new BufferedImage[2];

        frames[0] = playerSheet.getSubimage(0, row * frameHeight, frameWidth, frameHeight);
        frames[1] = playerSheet.getSubimage(frameWidth, row * frameHeight, frameWidth, frameHeight);

        idleDown = new Animation(frames, 22);
    }

    private void IdleRight()
    {
        int frameWidth = playerSheet.getWidth() / 2;
        int frameHeight = playerSheet.getHeight() / 4;

        int row = 3;

        BufferedImage[] frames = new BufferedImage[2];

        frames[0] = playerSheet.getSubimage(0, row * frameHeight + 3, frameWidth , frameHeight);
        frames[1] = playerSheet.getSubimage(frameWidth, row * frameHeight + 3, frameWidth, frameHeight);

        idleRight = new Animation(frames, 22);
    }
}